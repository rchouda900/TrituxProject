package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entités.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
	
	@SuppressWarnings("unchecked")
	public Compte save(Compte compte);
	
	public Compte findByLogin(String login);
	
	public long deleteByLogin(String login);
	
	@Modifying
    @Query("UPDATE Compte C SET C.mdp = :mdp WHERE C.login = :login")
    public int updateMdp(@Param("login") String login, @Param("mdp") String mdp);
	
}
