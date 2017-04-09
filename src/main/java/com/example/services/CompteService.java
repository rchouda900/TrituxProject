package com.example.services;

import com.example.entités.Compte;

public interface CompteService {

	public Compte getCompte(String login);
	public long deleteCompte(String login);
	public Compte createCompte (Compte compte);
	public int updateMdp (String login,String mdp);
	
}
