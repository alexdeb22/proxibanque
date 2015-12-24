package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

@Stateless
public class ClientService implements IClientService {
	
	@Inject
	IClientDao dao;
	
	@Override
	public Client createClient(Client cli) throws LigneExistanteException, LigneInexistanteException {
		return dao.create(cli);
	}

	@Override
	public Client consulterClient(Client cli) throws LigneInexistanteException {
		cli = dao.read(cli);
		return cli;
	}

	@Override
	public Client modifierClient(Client cli) throws LigneInexistanteException {
		return dao.update(cli);
	}

	@Override
	public int supprimerClient(Client cli) throws LigneInexistanteException {
		return dao.delete(cli);
	}

	@Override
	public ArrayList<Compte> getListeComptesClient(Client client) {
		return dao.getListeComptesClient(client);
	}
	
	

}
