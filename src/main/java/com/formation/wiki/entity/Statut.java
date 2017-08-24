package com.formation.wiki.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statut implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private boolean published;
	private boolean waitingforvalidation;
	private boolean reportedasabused;
	
	public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public boolean isWaitingforvalidation() {
		return waitingforvalidation;
	}
	public void setWaitingforvalidation(boolean waitingforvalidation) {
		this.waitingforvalidation = waitingforvalidation;
	}
	public boolean isReportedasabused() {
		return reportedasabused;
	}
	public void setReportedasabused(boolean reportedasabused) {
		this.reportedasabused = reportedasabused;
	}
	 
	public Statut(Integer id, boolean published, boolean waitingforvalidation, boolean reportedasabused) {
		super();
		this.id = id;
		this.published = published;
		this.waitingforvalidation = waitingforvalidation;
		this.reportedasabused = reportedasabused;
	}

}
