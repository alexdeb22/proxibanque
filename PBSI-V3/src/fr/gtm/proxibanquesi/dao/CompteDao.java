package fr.gtm.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.gtm.proxibanquesi.dao.util.BddConnector;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/**
 * Cette classe implémentent les méthodes de CRUD pour la table Compte de la
 * base de données.
 * 
 * @author Alexandre et Coralie
 *
 */
public class CompteDao implements ICompteDao {

	@Override
	public int createEpargne(CompteEpargne comt) {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();

			// Statement preparation
			String sql = "insert into compte(numCompte, solde, dateOuverture, idclient, type, autodecouvert, taux)"
					+ " values " + "( seq_numcompte.nextval, ? , sysdate , ?, 'Epargne', 0, ?)";
			PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setDouble(1, comt.getSolde());
			stat.setInt(2, comt.getIdcli());
			stat.setDouble(3, comt.getTauxRemuneration());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return res;
	}

	public int createCourant(CompteCourant comt) {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();

			// Statement preparation
			String sql = "insert into compte(numCompte, solde, dateOuverture, idclient, type, autodecouvert, taux)"
					+ " values " + "( seq_numcompte.nextval, ? , sysdate , ?, 'Courant', ?, 0)";
			PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setDouble(1, comt.getSolde());
			stat.setInt(2, comt.getIdcli());
			stat.setInt(3, comt.getAutorisationDecouvert());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return res;
	}

	public Compte read(Compte comt) throws LigneInexistanteException {
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
			comt.setSolde(res.getInt(3));
			comt.setDateOuverture(res.getDate(7));
			comt.setIdcli(res.getInt(6));

			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return comt;
	}

	public int updateCourant(CompteCourant comt) throws LigneInexistanteException {
		// TODO update compte
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
			String sql = "update compte set solde=?, autodecouvert=? where numcompte=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setDouble(1, comt.getSolde());
			stat.setDouble(2, comt.getAutorisationDecouvert());
			stat.setInt(3, comt.getNumCompte());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);

		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return res;
	}

	public int delete(Compte comt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> getListeComptesCourant(int id) {
		ArrayList<Integer> listeComptes = new ArrayList<Integer>();
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select numcompte from Compte where idclient = ? and type='Courant'";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet res = stat.executeQuery();
			while (res.next()) {
				listeComptes.add(res.getInt(1));
			}

		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeComptes;
	}

	@Override
	public ArrayList<Integer> getListeComptesEpargne(int id) {
		ArrayList<Integer> listeComptes = new ArrayList<Integer>();
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select numcompte from Compte where idclient = ? and type='Epargne'";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet res = stat.executeQuery();
			while (res.next()) {
				listeComptes.add(res.getInt(1));
			}

		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeComptes;
	}

	@Override
	public boolean debiter(int numcompte, Double montant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean crediter(int numcompte, Double montant) {
		// TODO Auto-generated method stub
		return false;
	}

}
