package com.formation.wiki.dao;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import com.formation.wiki.dao.UtilisateurDAO;
import com.formation.wiki.entity.Utilisateur;
public class Main {
	public static void main(String[] args) throws SQLException {
			
		Utilisateur user = new Utilisateur();
		user.setLogin("Taha");
		user.setPassword("taha");
		user.setActiver(true);
		user.setEmail("bellbattach.taha");
		UtilisateurDAO dao = new UtilisateurDAO();
		
		try {
			System.out.println(dao.isUserExist("chat01", "chat01"));
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(TimeoutException e){
		e.printStackTrace();		
	}		
		System.out.println(dao.findbyId(1).getActiver());
		dao.changerEtatUser(dao.findbyId(1));
		System.out.println(dao.findbyId(1).getActiver());
		
		
		
		//UtilisateurDAO.insertUser();
		//List<Utilisateur> listUser = UtilisateurDAO.getAllUser();
  		//for(Utilisateur u: listUser){
		//	System.out.println(u);
		//} 
		 
		// if(UtilisateurDAO.isUserExist("abdel", "abdel"))
		// System.out.println("l'utilisateur existe");
		// else
		// System.out.println("l'utilisateur n'existe pas!");
	
		//ArticleDAO.insertArticle();
		//ArticleDAO.insertArticle(8, "LivreDelphi", "Pour apprendre Delphi7",5);
	
		//List<Article> listArt = ArticleDAO.getAllArticle();
		//for(Article art:listArt){
		//		System.out.println(art);
		//}
		
		//UtilisateurDAO.getUser(6);
		//ArticleDAO.getArticlebyId(3);
		
		//ArticleDAO.getArticlebyName("livreJava");
		//ArticleDAO.removeArticlebyId(4);
		
	}
}	
