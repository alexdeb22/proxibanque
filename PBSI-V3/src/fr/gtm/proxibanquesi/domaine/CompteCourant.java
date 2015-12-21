package fr.gtm.proxibanquesi.domaine;

/**
 * Classe représentant un compte courant, avec autorisation de découvert.
 * @author Martin Coralie - De Bruyn Alexandre
 */
public class CompteCourant extends Compte {

	// Propriétés
	private int autorisationDecouvert = 1000;
	
	// Constructeurs
	public CompteCourant() {
		super();
	}
	public CompteCourant(int numCompte) {
		super();
		setNumCompte(numCompte);
	}
	public CompteCourant(double solde, int numCompte) {
		super();
		setSolde(solde);
	}

	// Getters & Setters
	public int getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	public void setAutorisationDecouvert(int autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}

	// Méthodes
//	@Override
//	public void typeCompte(ICompteBancaire compte) {
//		CompteCourant.class.getTypeName();
//		
//	}
//	@Override
//	public void getProprietaire(Client client) {
//		// TODO Auto-generated method stub
//		
//	}
	
	// Affichage
	@Override
	public String toString() {
		return "CompteCourant [numcompte=" + this.getNumCompte() + ", autorisationDecouvert=" + autorisationDecouvert
				+ ", solde=" + getSolde() + "]";
	}

}