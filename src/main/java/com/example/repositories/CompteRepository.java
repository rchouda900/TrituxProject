package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entités.Compte;
import com.example.entités.Etat;

public interface CompteRepository extends JpaRepository<Compte, String> {
	
	@SuppressWarnings("unchecked")
	public Compte save(Compte compte);
	
	public Compte findByLogin(String login);
	
	public Compte findByLoginAndMdp(String login, String mdp);
	
	
	public List <Compte> findAll();
	
	public Compte findByEmail(String email);
	
	public long deleteByLogin(String login);
	
	@Modifying
    @Query("UPDATE Compte C SET C.mdp = :mdp WHERE C.login = :login")
    public int updateMdp(@Param("login") String login, @Param("mdp") String mdp);
	
	public Etat save (Etat etat);
	
	
	
	
}
