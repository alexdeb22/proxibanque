package fr.gtm.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.DaoException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette classe implémentent les méthodes de CRUD pour la table Compte de la
 * base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public class CompteDao implements ICompteDao {



	/**
	 * Méthode de création d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte créé
	 * @throws DaoException 
	 */
	@Override
	public Compte createCompte(Compte comt) throws DaoException {
		try {
			Connection cnx = BddConnector.connect();

			// Statement preparation
			String sql = "insert into compte(numCompte, solde, dateOuverture, idclient, type, autodecouvert, taux)"
					+ " values " + "( seq_numcompte.nextval, ? , sysdate , ?, ?, ?, ?)";
			PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setDouble(1, comt.getSolde());
			stat.setInt(2, comt.getIdcli());
			if (comt instanceof CompteCourant) {
				stat.setString(3, "Courant");	
				stat.setDouble(4, ((CompteCourant) comt).getAutorisationDecouvert());
				stat.setDouble(5, 0);
			} else if (comt instanceof CompteEpargne) {
				stat.setString(3, "Epargne");	
				stat.setDouble(4, 0);
				stat.setDouble(5, ((CompteEpargne) comt).getTauxRemuneration());
			}
			// Statement execution
			stat.executeUpdate();
			// Recupere le numéro de compte assigné
			String sql2 = "select seq_numcompte.currval from dual";
			Statement numstat = cnx.createStatement(); 
			ResultSet num = numstat.executeQuery(sql2);
			num.next();
			comt.setNumCompte(num.getInt(1));

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException();
		}

		return comt;
	}
	

	/**
	 * Méthode pour lire les informations d'un compte.
	 * 
	 * @param comt : le compte
	 * @return Le compte consulté
	 * @throws LigneInexistanteException
	 */
	@Override
	public Compte readCompte(Compte comt) throws LigneInexistanteException {
		// TODO Auto-generated method stub
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Compte where numCompte = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, comt.getNumCompte());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce compte n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "select * from compte where numCompte=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setInt(1, comt.getNumCompte());
			// Statement execution
			ResultSet res = stat.executeQuery();
			res.next();
			comt.setSolde(res.getDouble(3));
			if (comt instanceof CompteCourant) {
				((CompteCourant) comt).setAutorisationDecouvert(res.getDouble(5));
			} else if (comt instanceof CompteEpargne) {
				((CompteEpargne) comt).setTauxRemuneration(res.getDouble(4));
			}
			comt.setDateOuverture(res.getDate(7));
			comt.setIdcli(res.getInt(6));

			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return comt;
	}
	
	/**
	 * Méthode pour supprimer un compte.
	 * 
	 * @param comt : le compte
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	@Override
	public int delete(Compte comt) throws LigneInexistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Compte where numCompte = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, comt.getNumCompte());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce compte n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "delete from compte where numcompte=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setInt(1, comt.getNumCompte());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return res;
	}

	/**
	 * Méthode qui récupère la liste des comptes des clients d'un conseiller.
	 * 
	 * @param cons : Le conseiller en session
	 * @return La liste de tous les comptes des clients d'un conseiller
	 */
	@Override
	public ArrayList<Compte> getListeComptes(Conseiller cons) {
		ArrayList<Compte> listeComptes = new ArrayList<Compte>();
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select numCompte, solde, dateOuverture, idclient, type, autodecouvert, taux from Compte JOIN Client USING (idclient) WHERE idcons = ?";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setInt(1, cons.getIdcons());
			ResultSet res = stat.executeQuery();
			Compte compTemp = null;
			while (res.next()) {
				if (res.getString("type").equals("Courant")) {
					compTemp = new CompteCourant();
					((CompteCourant) compTemp).setAutorisationDecouvert(res.getDouble("autodecouvert"));
				} else if (res.getString("type").equals("Epargne")) {
					compTemp = new CompteEpargne();
					((CompteEpargne) compTemp).setTauxRemuneration(res.getDouble("taux"));
				}
				compTemp.setIdcli(res.getInt("idclient"));
				compTemp.setNumCompte(res.getInt("numCompte"));
				compTemp.setSolde(res.getDouble("solde"));
				compTemp.setDateOuverture(res.getDate("dateOuverture"));
				listeComptes.add(compTemp);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeComptes;
	}


	/**
	 * Méthode de modification d'un compte.
	 * @param compte : compte
	 * @return Le compte mis à jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Compte updateCompte(Compte comt) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Compte where numCompte = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, comt.getNumCompte());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce compte n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "update compte set solde=?, autodecouvert=?, taux=? where numcompte=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setDouble(1, comt.getSolde());
			if (comt instanceof CompteCourant) {
				stat.setDouble(2, ((CompteCourant) comt).getAutorisationDecouvert());
				stat.setDouble(3, 0);
			} else if (comt instanceof CompteEpargne) {
				stat.setDouble(2, 0);
				stat.setDouble(3, ((CompteEpargne) comt).getTauxRemuneration());
			}
			
			stat.setInt(4, comt.getNumCompte());
			// Statement execution
			stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return comt;
	}







}
