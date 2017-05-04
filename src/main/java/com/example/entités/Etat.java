package com.example.entités;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long etatid;
	
	
	private long numetat;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "dd-mm-yyyy")
	private Date creationDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "dd-mm-yyyy")
	private Date modifDate;
	
	
	private String lastModifBy;
	
	@Column
	private String libelle;

	public Etat() {
		super();
	}

	public Etat(long numEtat, Date creationDate, Date modifDate, String lastModifBy, String libelle, Compte cp) {
		super();
		this.numetat=numEtat;
		this.creationDate = creationDate;
		this.modifDate = modifDate;
		this.lastModifBy = lastModifBy;
		this.libelle = libelle;
		this.compte=cp;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	
	public long getCompteid ()
	{
		return compte.getCompteid();
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModifDate() {
		return modifDate;
	}

	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}

	public String getLastModifBy() {
		return lastModifBy;
	}

	public void setLastModifBy(String lastModifBy) {
		this.lastModifBy = lastModifBy;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	public long getNumetat() {
		return numetat;
	}

	public void setNumetat(long numetat) {
		this.numetat = numetat;
	}




	@ManyToOne
	@JoinColumn(name="compteid")
	private Compte compte;
	
	

}
