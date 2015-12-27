package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Client
 * Elle liste les méthodes de CRUD d'un client, et les méthodes pour lister ses différents types de comptes.
 * @author Alexandre et Coralie
 *
 */
public interface IClientService {
	/**
	 * Méthode de création d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneExistanteException
	 */
	public Client createClient(Client cli) throws LigneExistanteException;
	
	/**
	 * Méthode pour lire les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client consulterClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * Méthode pour modifier les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client modifierClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * Méthode pour supprimer un client et ses comptes.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * Méthode qui récupère la liste des comptes d'un client.
	 * 
	 * @param client : Le client
	 * @return Une liste de comptes
	 */
	public ArrayList<Compte> getListeComptesClient(Client client);

}
