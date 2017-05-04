package com.example.entités;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

/**
 * @author rchouda
 *
 */
@Entity
public class Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long compteid;
	
	@Column(nullable=false,unique=true)
	private String login;
	
	@Column(nullable=false)
	private String mdp;
	
	@Column(unique=true,nullable=false)
	@Email
	private String email;
	

	@Column (nullable=false)
	private String role;
	
	@Column
	private String specialite;

	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Compte(String login, String mdp, String email, String role, String specialite) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.email = email;
		this.role = role;
		this.specialite = specialite;
	}







	public long getCompteid() {
		return compteid;
	}

	public void setCompteid(long compteid) {
		this.compteid = compteid;
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
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Etat> getEtats() {
		return etats;
	}

	public void setEtats(Collection<Etat> etats) {
		this.etats = etats;
	}
	

	public String getSpecialite() {
		return specialite;
	}



	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}





	@OneToMany(mappedBy="compte",cascade={CascadeType.REMOVE,CascadeType.MERGE})
	private Collection <Etat> etats;
	
	

}
