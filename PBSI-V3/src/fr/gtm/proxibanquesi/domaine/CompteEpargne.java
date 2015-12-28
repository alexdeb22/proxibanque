package fr.gtm.proxibanquesi.domaine;

/**
 * Classe représentant un compte épargne, héritant de la classe abstraite Compte, avec un taux de rémuneration déclaré à 3%.
 * @author Alexandre De Bruyn et Clement Peberge
 */
public class CompteEpargne extends Compte {

	// Propriétés
	/** Taux de rémunération du compte épargne */
	private double tauxRemuneration = 0.03;
	
	// Constructeurs
	/**
	 * Constructeur par défaut du compte épargne
	 * 
	 */
	public CompteEpargne() {
		super();
	}
	/**
	 * Constructeur permettant créer un compte épargne avec un solde
	 * @param double solde : le solde du compte épargne à créer
	 */
	public CompteEpargne(double solde) {
		super();
		setSolde(solde);
	}

	// Getters & Setters
	/**
	 * Getter de la propriété tauxRemuneration
	 * 
	 * @return La propriété tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	/**
	 * Setter de la propriété tauxRemuneration
	 * 
	 * @return void
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	// Méthodes
//	@Override
//	public void typeCompte(ICompteBancaire compte) {
//		CompteEpargne.class.getTypeName();
//	}
//	@Override
//	public void getProprietaire(Client client) {
//		// TODO Auto-generated method stub
//		
//	}

	// Affichage
	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet CompteEpargne
	 * 
	 * @return String décrivant le compte épargne
	 */
	@Override
	public String toString() {
		return "Epargne";
	}

}