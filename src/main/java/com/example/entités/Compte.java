package com.example.entités;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String mdp;
	
	@Column(unique=true,nullable=false)
	private String email;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String login, String mdp, String email) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
