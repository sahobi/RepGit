package com.formation.wiki.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({@NamedQuery(name = "Utilisateur.getAllUsers", query = "SELECT u FROM Utilisateur u"),
		@NamedQuery(name = "Utilisateur.findById", query = "SELECT u FROM Utilisateur u WHERE u.idUser= :id"),
		@NamedQuery(name = "Utilisateur.findByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login= :login") })
public class Utilisateur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUser;

	@Column(length = 20, nullable = false, unique = true)
	private String login;

	@Column(length = 25, nullable = false)
	private String password;

	@Column(name = "nom")
	private String nom;
	private String prenom;
	private String email;
	private String tel;
	private Boolean activer;

	// mapping entre utilisateur et articles
	@OneToMany(fetch = FetchType.LAZY)
	private List<Article> articles;

	// mapping entre utilisateur et articles
	@OneToMany(fetch = FetchType.LAZY)
	private List<Commentaire> commentaires;

	@OneToOne
	private Role role;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Boolean getActiver() {
		return activer;
	}

	public void setActiver(Boolean activer) {
		this.activer = activer;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

