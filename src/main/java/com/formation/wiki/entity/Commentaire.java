package com.formation.wiki.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity 
public class Commentaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	private Date commentaire;
	
	private String comment;
	
	@OneToOne
	private Article article;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Date commentaire) {
		this.commentaire = commentaire;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commentaire(Integer id, Date commentaire, String comment, Article article) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.comment = comment;
		this.article = article;
	}

	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
