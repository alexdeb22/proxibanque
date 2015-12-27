package fr.gtm.proxibanquesi.domaine;

/**
 * Classe représentant un compte courant, héritant de la classe abstraite Compte, avec autorisation de découvert déclarée de 1000 euro.
 * @author Alexandre De Bruyn et Clement Peberge
 */
public class CompteCourant extends Compte {

	// Propriétés
	/** Autorisation de découvert */
	private double autorisationDecouvert = 1000;
	
	// Constructeurs
	/**
	 * Constructeur par défaut du compte courant
	 * 
	 */
	public CompteCourant() {
		super();
	}
	/**
	 * Constructeur permettant créer un compte courant avec un solde
	 * @param double solde : le solde du compte courant à créer
	 */
	public CompteCourant(double solde) {
		super();
		setSolde(solde);
	}
	

	// Getters & Setters
	/**
	 * Getter de la propriété autorisationDecouvert
	 * 
	 * @return La propriété autorisationDecouvert
	 */
	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	/**
	 * Setter de la propriété autorisationDecouvert
	 * 
	 * @return void
	 */
	public void setAutorisationDecouvert(double d) {
		this.autorisationDecouvert = d;
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
	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet CompteCourant
	 * 
	 * @return String décrivant le compte courant
	 */
	@Override
	public String toString() {
		return "CompteCourant [numcompte=" + this.getNumCompte() + ", autorisationDecouvert=" + autorisationDecouvert
				+ ", solde=" + getSolde() + "]";
	}

}