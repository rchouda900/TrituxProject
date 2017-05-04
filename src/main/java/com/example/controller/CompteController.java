package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entités.Compte;
import com.example.entités.Etat;
import com.example.services.CompteService;

@RestController
@RequestMapping(value="/comptes")
public class CompteController {
	
	@Autowired
	public CompteService compteservice;
	
	@RequestMapping (method=RequestMethod.GET,value="/retourner/{login}")
	public Compte getCompte(@PathVariable(value="login") String login)
	{
		return compteservice.getCompte(login);
	}
	@RequestMapping(value="/authentifier", method=RequestMethod.POST)
	public Compte authentifier(@RequestParam("login") String login, @RequestParam("mdp") String mdp){
		return compteservice.authentifier(login, mdp);
	}
	
	
	@RequestMapping (method=RequestMethod.DELETE,value="/supprimer/{login}")
	public long deleteCompte(@PathVariable(value="login") String login)
	{
		return compteservice.deleteCompte(login);
	}
	
	@RequestMapping (method=RequestMethod.POST,value="/creer")
	public Compte créerCompte(@RequestParam(value="login") String login,@RequestParam(value="mdp") String mdp,@RequestParam(value="email") String email,@RequestParam(value="role") String role,@RequestParam(value="specialite") String specialite)
	{
		if (getCompte(login)==null)
		{
		Compte cp=new Compte(login,mdp,email,role,specialite);
		
		Date date=new Date();Date date2=new Date();
		
	    compteservice.createCompte(cp);
	    
	    Compte cp1=compteservice.getCompte(cp.getLogin());
	    
Etat etat=new Etat(1,date,date2,cp.getLogin(),"TestsEnligne",cp1);
		
		compteservice.createEtat(etat);
		return cp1;
	    
		}
		else return null;
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/modifier")
	public int ModifierCompte(@RequestParam(value="login") String login,@RequestParam(value="mdp") String mdp)
	{
		return compteservice.updateMdp(login, mdp);
	}

	
	@RequestMapping (method={RequestMethod.GET,RequestMethod.POST},value="/afficheremail")
	public Compte getCompteByEmail(@RequestParam(value="email") String email)
	{
		return compteservice.getCompteByEmail(email);
	}
	
	
	@RequestMapping (method=RequestMethod.GET,value="/affichertous")
	public List <Compte> getCompteAll()
	{
		return compteservice.getAllCompte();
	}
	
	
	
}
