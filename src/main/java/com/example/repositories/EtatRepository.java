package com.example.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entités.Compte;
import com.example.entités.Etat;

public interface EtatRepository extends JpaRepository<Etat, String> {
	
	public Etat findByNumetat (long numetat);
	
	@SuppressWarnings("unchecked")
	public Etat save(Etat etat);
	
	public long deleteByNumetat(long numetat);
	
	@Modifying
    @Query("UPDATE Etat E SET E.libelle = :libelle,E.modifDate = :modifDate WHERE E.compte.compteid = :compteid AND E.numetat = :numetat")
    public int updateEtat( @Param("libelle") String libelle,@Param ("modifDate") Date date,@Param("compteid") long compteid,@Param ("numetat") long numetat);
	
	@Modifying
    @Query("UPDATE Etat E SET E.numetat = :numetat WHERE E.libelle = :libelle AND E.compte.compteid = :compteid")
    public int updateEtatNum(@Param("numetat") long numetat, @Param("libelle") String libelle, @Param ("compteid") long compteid);

	public Etat findByCompte(Compte c);
	
}
