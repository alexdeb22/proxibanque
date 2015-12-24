package fr.gtm.proxibanquesi.service;

import java.util.ArrayList;

import javax.inject.Inject;

import fr.gtm.proxibanquesi.dao.ICompteDao;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;
import fr.gtm.proxibanquesi.exceptions.SoldeInsuffisantException;

public class CompteService implements ICompteService {
	
	@Inject
	ICompteDao dao;

	@Override
	public Compte creerCompte(Compte compte) {
		return dao.createCompte(compte);
	}

	@Override
	public Compte consulterCompte(Compte compte) throws LigneInexistanteException {
		compte = dao.readCompte(compte);
		return compte;
	}


	@Override
	public Compte modifierCompte(Compte compte) throws LigneInexistanteException {
		return dao.updateCompte(compte);
	}


	@Override
	public int supprimerCompte(Compte compte) throws LigneInexistanteException {
		return dao.delete(compte);
	}

	@Override
	public int virement(Compte compteDebiteur, Compte compteCrediteur, double montant)
			throws SoldeInsuffisantException, LigneInexistanteException {
		if (compteDebiteur instanceof CompteCourant && (compteDebiteur.getSolde() + ((CompteCourant) compteDebiteur).getAutorisationDecouvert()) < montant) {
				throw new SoldeInsuffisantException();
		} else if (compteDebiteur instanceof CompteEpargne && compteDebiteur.getSolde() < montant) {
				throw new SoldeInsuffisantException();
		} else {
			compteDebiteur.setSolde(compteDebiteur.getSolde() - montant);
			compteCrediteur.setSolde(compteCrediteur.getSolde() + montant);
			dao.updateCompte(compteDebiteur);
			dao.updateCompte(compteCrediteur);
		}

		return 0;
	}

	@Override
	public ArrayList<Compte> getListeComptes(Conseiller cons) {
		return dao.getListeComptes(cons);
	}





}
