package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Interface de la couche Service du Client
 * Elle liste les m�thodes de CRUD d'un client, et les m�thodes pour lister ses diff�rents types de comptes.
 * @author Alexandre et Coralie
 *
 */
public interface IClientService {
	/**
	 * M�thode de cr�ation d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneExistanteException
	 * @throws LigneInexistanteException
	 */
	public Client createClient(Client cli) throws LigneExistanteException, LigneInexistanteException;
	
	/**
	 * M�thode pour lire les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client consulterClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour modifier les informations d'un client.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public Client modifierClient(Client cli) throws LigneInexistanteException;
	
	/**
	 * M�thode pour supprimer un client et ses comptes.
	 * @param cli : le client
	 * @return
	 * @throws LigneInexistanteException
	 */
	public int supprimerClient(Client cli) throws LigneInexistanteException;
	
	

}
