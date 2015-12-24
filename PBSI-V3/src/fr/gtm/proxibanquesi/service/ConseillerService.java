package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.IConseillerDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

@Stateless
public class ConseillerService implements IConseillerService {
	
	@Inject
	IConseillerDao dao;
	
	@Override
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException {
		return dao.create(cons);
	}

	@Override
	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException {
		return dao.read(userTemp);
	}

	@Override
	public ArrayList<Client> getListeClients(Conseiller cons) {
		return dao.getListeClients(cons);
	}

	@Override
	public Conseiller updateConseiller(Conseiller userTemp) throws LigneInexistanteException {
		return dao.update(userTemp);
	}

	@Override
	public int delete(Conseiller cons) throws LigneInexistanteException {
		return dao.delete(cons);
	}


}
