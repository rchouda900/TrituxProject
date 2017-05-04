package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entités.Compte;
import com.example.entités.Etat;
import com.example.entités.utils.Enumeration;
import com.example.entités.utils.Enumeration2;
import com.example.services.CompteService;
import com.example.services.EtatService;

@RestController
@RequestMapping(value="/etats")
public class EtatController {
	
	@Autowired
	public EtatService etatservice;
	
	
	@Autowired
	public CompteService compteservice;
	
	
	@RequestMapping (method={RequestMethod.GET,RequestMethod.POST},value="/retourner")
	public Etat getEtat(@RequestParam(value="email") String email)
	{
		Compte compte=compteservice.getCompteByEmail(email);
		return etatservice.getEtatByCompte(compte);
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/modifier/{numetatancien}/{numetat}/{email}")
	public int updateEtat(@PathVariable(value="numetatancien") long numetatancien,@PathVariable(value="numetat") long numetat,@PathVariable(value="email") String email)
	{String libelle;
	
	Compte compte=compteservice.getCompteByEmail(email);
	
	if (compte!=null){
	if (numetat==1)libelle=String.valueOf(Enumeration.TestsEnligne);
	else if (numetat==2)libelle=String.valueOf(Enumeration.EntretienTechnique);
	else if (numetat==3)libelle=String.valueOf(Enumeration.entretienRh);
	else if (numetat==4)libelle=String.valueOf(Enumeration.Acceptation);
	else return -1;
	
	Date date=new Date();

	int i= etatservice.updateEtat(libelle,date,compte.getCompteid(), numetatancien);
	int j=etatservice.updateEtatNum(numetat, libelle,compte.getCompteid());
	
		
		if (i==1&&j==1)return 1;
		else if (i!=1&&j!=1) return -4;
		else if (i!=1)return -2;
		else return -3;}
	else return -5;
	}
	
	
	
	@RequestMapping (method=RequestMethod.PUT,value="/modifier2/{numetatancien}/{numetat}/{email}")
	public int updateEtat2(@PathVariable(value="numetatancien") long numetatancien,@PathVariable(value="numetat") long numetat, @PathVariable(value="email") String email)
	{String libelle;
	
	Compte compte=compteservice.getCompteByEmail(email);
	
	if (compte!=null)
	{
	if (numetat==1)libelle=String.valueOf(Enumeration2.TestsEnligne);
	else if (numetat==2)libelle=String.valueOf(Enumeration2.EntretienTechnique);
	else if (numetat==3)libelle=String.valueOf(Enumeration2.EntretienDemandeur);
	else if (numetat==4)libelle=String.valueOf(Enumeration2.Acceptation);
	else return -1;
	
	Date date=new Date();
	
		int i= etatservice.updateEtat(libelle,date,compte.getCompteid(), numetatancien);
		int j=etatservice.updateEtatNum(numetat, libelle,compte.getCompteid());
		
		if (i==1&&j==1)return 1;
		else if (i!=1&&j!=1) return -4;
		else if (i!=1)return -2;
		else return -3;}
	
	else return -5;
	
	}

	

	
	
	@RequestMapping (method=RequestMethod.DELETE,value="/supprimer/{numetat}")
	public long deleteEtat(@PathVariable(value="numetat") long numetat)
	{
		return etatservice.deleteEtat(numetat);
	}
	
	

}
