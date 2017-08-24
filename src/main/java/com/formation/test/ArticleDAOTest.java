package com.formation.test;

import static org.junit.Assert.*;

import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.junit.Before;
import org.junit.Test;

import com.formation.wiki.dao.*;
import com.formation.wiki.entity.Article;

//import com.formation.wiki.dao.*;
 


public class ArticleDAOTest {
	ArticleDAO art = new ArticleDAO();
	
 
	@Before
	public void init(){
		art = new ArticleDAO();
	}
	
	@Test(expected=SQLException.class)
	public void insertArticleTest() throws SQLException, Throwable{
		
		/**assertTrue(ArticleDAO.insertArticle(11,"livreSQL","livre pour apprendre SQL",6));
		assertTrue(ArticleDAO.insertArticle(12,"livreC ","livre pour apprendre C ",4));
		assertTrue(ArticleDAO.insertArticle(13,"livreOracle","livre pour apprendre C++",3));
		assertTrue(ArticleDAO.insertArticle(14,"livreOracle","livre pour apprendre oracle",8));
		*/
		if(ArticleDAO.getArticlebyId(20) != null){
			System.out.println("Article existant");
 		}else{
 			System.out.println("je vais inserer mec");
 			assertTrue(ArticleDAO.insertArticle(20,"livreOracle","livre pour apprendre oracle",8));}
		
	}
	
	@Test(expected=SQLException.class)
	public void getAllArticle(){
		List<Article> listArt = ArticleDAO.getAllArticle();
		for(Article art:listArt){
		System.out.println(art);
		}
	}
	private void assertTrue(Article insertArticle) {
	}
	
	

}
