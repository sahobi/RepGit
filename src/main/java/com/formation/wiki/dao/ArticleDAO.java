package com.formation.wiki.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import com.formation.wiki.entity.Article;
import com.formation.wiki.entity.Utilisateur;

import javax.persistence.*;


public class ArticleDAO {
	
	private EntityManager em;
	private EntityTransaction tx;
	
	public ArticleDAO() {
		super();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU_WIKI");
		em = emf.createEntityManager();
		tx=em.getTransaction();
	}

	public static Article getArticlebyId(int idArticle) {
		
		
		return null;
 
			//		String request = " select * from article where idArticle=" + idArticle;
			//		System.out.println(request);
			//		Article art = null;
			//		try {
			//			Connection c = ConnexionManager.getConnexion();
			//			Statement st = c.createStatement();
			//			ResultSet rs = st.executeQuery(request);
			//			if (rs.next()) {
			//				art = new Article();
			//				art.setIdArticle(rs.getInt("idArticle"));
			//				art.setContenu(rs.getString("contenu"));
			//				art.setNomArticle(rs.getString("nomArticle"));
			//				art.setIdUser(rs.getInt("idUser"));
			//				System.out.println("l'article dont l'id " + idArticle + " est : " + art);
			//			}
			//		} catch (Exception e) {
			//			e.printStackTrace();
			//		}
			//		return art;
	}

	public static Article getArticlebyName(String nomArticle) {
		// on met entre ' ' car c'est un string.
		String request = " select * from article where nomArticle='" + nomArticle + "'";
		Article art = null;
		try {
			Connection c = ConnexionManager.getConnexion();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(request);
			if (rs.next()) {
				art = new Article();
				art.setIdArticle(rs.getInt("idArticle"));
				art.setContenu(rs.getString("contenu"));
				art.setNomArticle(rs.getString("nomArticle"));
				art.setIdUser(rs.getInt("idUser"));
				System.out.println("l'article dont le nom " + nomArticle + " est : " + art);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
	}

/**	public static Article insertArticle() throws SQLException,  TimeoutException{
		String request = "INSERT INTO article values (NULL,'livreC++','livre pour apprendre C++',6)";
		//try {
			ConnexionManager.getConnexion();
			Connection c = ConnexionManager.getConnexion();
			Statement st = c.createStatement();
			st.executeUpdate(request);
			System.out.println("Article inserer avec success");
		//} catch (Exception e) {
		//	e.printStackTrace();
		//}
		return null;
	}
 * @throws SQLException 
*/	

 	public void insertArticle(int idArticle, String nomArticle,String contenu, int idUser) throws SQLException,TimeoutException{
		
 		Utilisateur user=new Utilisateur();
 		
 		tx.begin();
		em.persist(user);
		//Suppression d'un objet em.remove(entity);
		//Mise à jour d'un objet em.merge(entity);
		//Récupération d'un objet em.find(entityClass, primaryKey);
		tx.commit();
		 
	}
 		
		       
				//		String request="INSERT INTO Article values "
				//				+ "(" + idArticle+",'"+nomArticle+"','"+contenu+"',"+idUser+")";
				//		ConnexionManager.getConnexion();
				//		Connection c = ConnexionManager.getConnexion();
				//		Statement st = c.createStatement();
				//		st.executeUpdate(request);
				//		System.out.println("Article inserer avec success");
				//		return null;
	 

	public static List<Article> getAllArticle() {
		String requestGetAllUser = " select * from article";
		List<Article> listArticle = null;
		Connection c = ConnexionManager.getConnexion();
		try {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(requestGetAllUser);
			listArticle = new ArrayList<Article>();

			while (rs.next()) {
				Article art = new Article();

				art.setIdArticle(rs.getInt("idArticle"));
				art.setContenu(rs.getString("contenu"));
				art.setIdUser(rs.getInt("idUser"));
				art.setNomArticle(rs.getString("nomArticle"));
				listArticle.add(art);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticle;
	}

	public static void removeArticlebyId(int idArticle) {
		String request = "delete from article where idArticle=" + idArticle;
		Article art = null;
		try {
			Connection c = ConnexionManager.getConnexion();
			Statement st = c.createStatement();
			int a = st.executeUpdate(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
