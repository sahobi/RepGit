package com.formation.wiki.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="NAME")
	private String nom;
	
	private String description;

	public Integer getId() {
		return id;
	}
	 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

}
