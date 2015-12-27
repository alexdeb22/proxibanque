package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Client
 * Elle liste les méthodes de CRUD d'un client, et une méthode pour lister les comptes d'un client.
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public interface IClientService {
	/**
	 * Méthode de création de client.
	 * 
	 * @param cli : le client
	 * @return le client créé
	 * @throws LigneExistanteException
	 */
	public Client createClient(Client cli) throws LigneExistanteException;
	
	/**
	 * Méthode de lecture des informations du client.
	 * 
	 * @param cli : le client
	 * @return le client consulté
	 * @throws LigneInexistanteException
	 */
	public Client consulterClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier les informations du client.
	 * 
	 * @param cli : le client
	 * @return le client mis à jour
	 * @throws LigneInexistanteException
	 */
	public Client modifierClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * Méthode pour effacer un client.
	 * 
	 * @param cli : le client
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	public int supprimerClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * Méthode qui récupère la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return La liste de comptes d'un client
	 */
	public ArrayList<Compte> getListeComptesClient(Client client);

}
