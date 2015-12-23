package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

public interface IConseillerService {
	
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException;

	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException;
	
	public ArrayList<Client> getListeClients(Conseiller cons);

}
