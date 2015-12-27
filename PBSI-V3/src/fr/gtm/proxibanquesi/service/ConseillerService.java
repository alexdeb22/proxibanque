package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.IConseillerDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Classe de la couche Service du Conseiller.
 * Elle implémente les méthodes de CRUD d'un conseiller, et une méthode pour lister les clients,
 *  et leurs comptes, d'un conseiller.
 * Cette classe est un EJB Stateless.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
@Stateless
public class ConseillerService implements IConseillerService {
	
	/** Déclaration de l'interface Dao pour l'injection*/
	@Inject
	IConseillerDao dao;
	
	/**
	 * Méthode de création un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller créé
	 * @throws LigneExistanteException
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller createConseiller(Conseiller cons) throws LigneExistanteException, LigneInexistanteException {
		return dao.create(cons);
	}

	/**
	 * Méthode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller (doit avoir un login et un mdp).
	 * @return Le conseiller consulté
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller checkUser(Conseiller userTemp) throws LigneInexistanteException {
		return dao.read(userTemp);
	}

	/**
	 * Méthode pour récupérer la liste des clients et leurs comptes d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return La liste de clients et de comptes du conseiller
	 */
	@Override
	public ArrayList<Client> getListeClients(Conseiller cons) {
		return dao.getListeClients(cons);
	}

	/**
	 * Méthode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis à jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller updateConseiller(Conseiller userTemp) throws LigneInexistanteException {
		return dao.update(userTemp);
	}

	/**
	 * Méthode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	@Override
	public int delete(Conseiller cons) throws LigneInexistanteException {
		return dao.delete(cons);
	}


}
