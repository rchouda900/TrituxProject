package com.example.services;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entités.Compte;
import com.example.entités.Etat;
import com.example.repositories.CompteRepository;

@Service(value="CompteService")
public class CompteServiceImpl implements CompteService{

	@Resource
	private CompteRepository compteRepository;
	
	@Override
	public Compte authentifier(String login, String mdp){
		return compteRepository.findByLoginAndMdp(login, mdp);
	}	
	
	@Override
	public Compte getCompte(String login) {
		// TODO Auto-generated method stub
		return this.compteRepository.findByLogin(login);
	}

	@Transactional
	@Override
	public long deleteCompte(String login) {
		// TODO Auto-generated method stub
		
		return compteRepository.deleteByLogin(login);
		
	}

	@Override
	public Compte createCompte(Compte compte) {
		// TODO Auto-generated method stub
		return this.compteRepository.save(compte);
	}

	@Transactional
	@Override
	public int updateMdp(String login, String mdp) {
		// TODO Auto-generated method stub
		return this.compteRepository.updateMdp(login, mdp);
		
	}

	@Override
	public Compte getCompteByEmail(String email) {
		// TODO Auto-generated method stub
		return this.compteRepository.findByEmail(email);
	}

	@Override
	public List<Compte> getAllCompte() {
		// TODO Auto-generated method stub
		return this.compteRepository.findAll();
	}

	@Override
	public Etat createEtat(Etat etat) {
		// TODO Auto-generated method stub
		return this.compteRepository.save(etat);
	}


}
