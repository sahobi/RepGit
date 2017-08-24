package com.formation.wiki.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
 
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name="Article.findById",query="SELECT art FROM Article art WHERE art.idArticle=:id")

public class Article implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idArticle;
	private String title;
	private String keywords;
	
	@Temporal(TemporalType.DATE)
	private Date publishDate;
	private String nomArticle;
	private int idUser;
	private String contenu;
	
	@Lob
	@Column(name="PHOTO")
	private Serializable photo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Utilisateur user;
	
	@OneToMany(fetch=FetchType.LAZY)
	private List<Commentaire> commentaires;
	
	@OneToOne
	private Statut statut;

	public Article(){
 		
 	}
 		
	public Article(int idArticle, String title, String keywords, Date publishDate, String nomArticle, int idUser,
			String contenu, Serializable photo, Utilisateur user, List<Commentaire> commentaires, Statut statut) {
		super();
		this.idArticle = idArticle;
		this.title = title;
		this.keywords = keywords;
		this.publishDate = publishDate;
		this.nomArticle = nomArticle;
		this.idUser = idUser;
		this.contenu = contenu;
		this.photo = photo;
		this.user = user;
		this.commentaires = commentaires;
		this.statut = statut;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Serializable getPhoto() {
		return photo;
	}

	public void setPhoto(Serializable photo) {
		this.photo = photo;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
 	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", idUser=" + idUser + ", contenu="
				+ contenu + "]";
	}

}
