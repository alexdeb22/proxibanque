package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Classe de la couche Service du Client.
 * Elle implémente les méthodes de CRUD d'un client, et une méthode pour lister les comptes d'un client.
 * Cette classe est un EJB Stateless.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
@Stateless
public class ClientService implements IClientService {
	
	/** Déclaration de l'interface Dao pour l'injection*/
	@Inject
	IClientDao dao;
	/**
	 * Méthode de création de client.
	 * 
	 * @param cli : le client
	 * @return le client créé
	 * @throws LigneExistanteException
	 */
	@Override
	public Client createClient(Client cli) throws LigneExistanteException {
		return dao.create(cli);
	}
	/**
	 * Méthode de lecture des informations du client.
	 * 
	 * @param cli : le client
	 * @return le client consulté
	 * @throws LigneInexistanteException
	 */
	@Override
	public Client consulterClient(Client cli) throws LigneInexistanteException {
		cli = dao.read(cli);
		return cli;
	}
	/**
	 * Méthode pour modifier les informations du client.
	 * 
	 * @param cli : le client
	 * @return le client mis à jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Client modifierClient(Client cli) throws LigneInexistanteException {
		return dao.update(cli);
	}
	/**
	 * Méthode pour effacer un client.
	 * 
	 * @param cli : le client
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	@Override
	public int supprimerClient(Client cli) throws LigneInexistanteException {
		return dao.delete(cli);
	}
	/**
	 * Méthode qui récupère la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	@Override
	public ArrayList<Compte> getListeComptesClient(Client client) {
		return dao.getListeComptesClient(client);
	}
	
	

}
