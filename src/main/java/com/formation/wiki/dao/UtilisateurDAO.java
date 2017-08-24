package com.formation.wiki.dao;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.formation.wiki.entity.Utilisateur;

public class UtilisateurDAO {
	
	private EntityManager em;
	private EntityTransaction tx;
	
	public UtilisateurDAO() {
		super();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}

	public String isUserExist(String login ,String mdp) throws SQLException,TimeoutException {

		String role_user=null;
		Query q=em.createQuery("select user from Utilisateur user where user.login = :login and "
				+ "user.password= : mdp");
		q.setParameter("login", login);
		q.setParameter("mdp", mdp);
		Utilisateur user_exist=(Utilisateur) q.getSingleResult();
		if(user_exist != null ) {
			role_user=user_exist.getRole().getNom();
		}	
		return role_user;
	}
	//Methode d'ajout d'utilisateur
	public void addUser(Utilisateur user) {
		tx.begin();
		em.persist(user);
		//Suppression d'un objet em.remove(entity);
		//Mise � jour d'un objet em.merge(entity);
		//R�cup�ration d'un objet em.find(entityClass, primaryKey);
		tx.commit();
	}
	public Utilisateur findbyId(int id) {
		Query q=em.createNamedQuery("Utilisateur.findById");
		q.setParameter("id", id);
		Utilisateur user=(Utilisateur) q.getSingleResult();
		return user;
	}
	
	public void changerEtatUser(Utilisateur user) {
		if(user.getActiver()== false) {
			user.setActiver(true);
		}
		else {
			user.setActiver(false);
		}
		tx.begin();
		em.merge(user);
		tx.commit();
	}
	
}




