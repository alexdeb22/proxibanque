package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

public interface IClientService {
	public Client createClient(Client cons) throws LigneExistanteException, LigneInexistanteException;
	
	public Client getListeComptesCourant(Client cli);
	
	public Client getListeComptesEpargne(Client cli);
	
	public ArrayList<Compte> getComptes(Client cli) throws LigneInexistanteException;
	
	public boolean virement(Compte compteDebiteur, Compte compteCrediteur, Double montant) throws SoldeInsuffisantException;
}
