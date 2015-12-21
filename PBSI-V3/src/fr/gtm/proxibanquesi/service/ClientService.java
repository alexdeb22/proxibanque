package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import fr.gtm.proxibanquesi.dao.ClientDao;
import fr.gtm.proxibanquesi.dao.CompteDao;
import fr.gtm.proxibanquesi.dao.IClientDao;
import fr.gtm.proxibanquesi.dao.ICompteDao;
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

public class ClientService implements IClientService {

	@Override
	public Client createClient(Client cli) throws LigneExistanteException, LigneInexistanteException {
		IClientDao dao = new ClientDao();
		dao.create(cli);
		cli = dao.getID(cli);
		return cli;
	}

	@Override
	public Client getListeComptesCourant(Client cli) {
		ICompteDao dao = new CompteDao();
		cli.setListeComptesCourant(dao.getListeComptesCourant(cli.getId()));
		return cli;
	}

	@Override
	public Client getListeComptesEpargne(Client cli) {
		ICompteDao dao = new CompteDao();
		cli.setListeComptesEpargne(dao.getListeComptesCourant(cli.getId()));
		return cli;
	}
	
	@Override
	public ArrayList<Compte> getComptes(Client cli) throws LigneInexistanteException {
		ICompteDao dao = new CompteDao();
		ArrayList<Integer> listeIndex = cli.getListeComptesCourant();
		if (listeIndex.size() > 0) {
			ArrayList<Compte> listeComptes = new ArrayList<Compte>();
			for(int i = 0; i < listeIndex.size(); i++) {
				Compte co = new CompteCourant();
				co.setNumCompte(listeIndex.get(i));
				co = dao.read(co);
				listeComptes.add(co);
				}
			return listeComptes;
		} else return null;
	}

	@Override
	public boolean virement(Compte compteDebiteur, Compte compteCrediteur, Double montant) throws SoldeInsuffisantException {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
