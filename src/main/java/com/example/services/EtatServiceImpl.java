package com.example.services;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entités.Compte;
import com.example.entités.Etat;
import com.example.repositories.EtatRepository;
@Service(value="EtatService")
public class EtatServiceImpl implements EtatService{
	
	@Resource
	private EtatRepository etatRepository;

	@Override
	public Etat getEtat(long numetat) {
		// TODO Auto-generated method stub
		return this.etatRepository.findByNumetat(numetat);
	}

	@Transactional
	@Override
	public long deleteEtat(long numetat) {
		// TODO Auto-generated method stub
		return this.etatRepository.deleteByNumetat(numetat);
	}


	@Transactional
	@Override
	public int updateEtat(String libelle,Date date,long compteid,long numetat) {
		// TODO Auto-generated method stub
		return this.etatRepository.updateEtat(libelle, date, compteid,numetat);
	}

	@Transactional
	@Override
	public int updateEtatNum(long numetat, String libelle, long compteid) {
		// TODO Auto-generated method stub
		return this.etatRepository.updateEtatNum(numetat, libelle, compteid);
	}

	@Override
	public Etat getEtatByCompte(Compte compte) {
		// TODO Auto-generated method stub
		return this.etatRepository.findByCompte(compte);
	}

}
