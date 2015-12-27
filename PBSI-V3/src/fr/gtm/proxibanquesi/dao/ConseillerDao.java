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
import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/** Cette classe implémentent les méthodes de CRUD pour la table 
 * CONSEILLER de la base de données.
 * 
 * @author Alexandre De Bruyn et Clement Peberge
 *
 */
public class ConseillerDao implements IConseillerDao {

	/**
	 * Méthode de création un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller créé
	 * @throws LigneExistanteException
	 */
	@Override
	public Conseiller create(Conseiller cons) throws LigneExistanteException {
		try {
			Connection cnx = BddConnector.connect();

			String check = "select count(*) from Conseiller where nom = ?"
					+ " and prenom = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setString(1, cons.getNom().toUpperCase());
			checkstat.setString(2, cons.getPrenom().toUpperCase());
			ResultSet checkres = checkstat.executeQuery(); 
			checkres.next();
			if (checkres.getInt(1) != 0) {
				BddConnector.unconnect(cnx);
				throw new LigneExistanteException("Ce conseiller existe déja.");
			}
			// Statement preparation
			String sql = "insert into conseiller(idcons, nom, prenom, idagence, login, mdp)"
					+ " values "
					+ "( seq_idcons.nextval, ? , ? , ?, ?, ?)";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);			
			stat.setString(1, cons.getNom().toUpperCase());
			stat.setString(2, cons.getPrenom().toUpperCase());
			stat.setInt(3, cons.getIdagence());
			stat.setString(4, cons.getLogin().toUpperCase());
			stat.setString(5, cons.getMdp());
			// Statement execution
			stat.executeUpdate();
			
			// Recupere l'id client assigné
			String sql2 = "select seq_idcons.currval from dual";
			Statement idstat = cnx.createStatement(); 
			ResultSet id = idstat.executeQuery(sql2);
			id.next();
			cons.setIdcons(id.getInt(1));

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		
		return cons;
	}

	/**
	 * Méthode pour lire les informations d'un conseiller.
	 * @param cons qui est le conseiller (doit avoir un login et un mdp).
	 * @return Le conseiller consulté
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller read(Conseiller cons) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Conseiller where login = ? and mdp = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setString(1, cons.getLogin().toUpperCase());
			checkstat.setString(2, cons.getMdp());
			ResultSet checkres = checkstat.executeQuery(); 
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "select * from conseiller where login = ? and mdp = ?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);			
			stat.setString(1, cons.getLogin().toUpperCase());
			stat.setString(2, cons.getMdp());
			// Statement execution
			ResultSet res = stat.executeQuery();
			while(res.next()) {
			cons.setNom(res.getString("nom"));
			cons.setPrenom(res.getString("prenom"));
			cons.setIdagence(res.getInt("idagence"));
			cons.setIdcons(res.getInt("idcons"));
			}
			BddConnector.unconnect(cnx);			
			
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return cons;
	}

	/**
	 * Méthode pour modifier les informations d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return Le conseiller mis à jour
	 * @throws LigneInexistanteException
	 */
	@Override
	public Conseiller update(Conseiller cons) throws LigneInexistanteException {
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Conseiller where idcons = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cons.getIdcons());
			ResultSet checkres = checkstat.executeQuery(); 
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "update conseiller set nom=?, prenom=?, idagence=? "
					+ "where idcons=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);			
			stat.setString(1, cons.getNom().toUpperCase());
			stat.setString(2, cons.getPrenom().toUpperCase());
			stat.setInt(3, cons.getIdagence());
			stat.setInt(4, cons.getIdcons());
			// Statement execution
			stat.executeUpdate();

			BddConnector.unconnect(cnx);			
			
		} catch (SQLException ex) {
			Logger.getLogger(ConseillerDao.class.getName()).log(Level.SEVERE, null, ex);
		} 
		return cons;
	}
	
	/**
	 * Méthode pour supprimer un conseiller.
	 * @param cons qui est le conseiller.
	 * @return res : un int représentant le nombre de lignes supprimée en base de données
	 * @throws LigneInexistanteException
	 */
	@Override
	public int delete(Conseiller cons) throws LigneInexistanteException {
		int res = 0;
		try {
			Connection cnx = BddConnector.connect();
			String check = "select count(*) from Conseiller where idcons = ?";
			PreparedStatement checkstat = cnx.prepareStatement(check);
			checkstat.setInt(1, cons.getIdcons());
			ResultSet checkres = checkstat.executeQuery();
			checkres.next();
			if (checkres.getInt(1) == 0) {
				BddConnector.unconnect(cnx);
				throw new LigneInexistanteException("Ce conseiller n'existe pas dans la base.");
			}
			// Statement preparation
			String sql = "delete from Conseiller where idcons=?";
			java.sql.PreparedStatement stat;
			stat = cnx.prepareStatement(sql);
			stat.setInt(1, cons.getIdcons());
			// Statement execution
			res = stat.executeUpdate();

			BddConnector.unconnect(cnx);
		} catch (SQLException ex) {
			Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return res;
	}


	/**
	 * Méthode pour récupérer la liste des clients et leurs comptes d'un conseiller.
	 * @param cons qui est le conseiller.
	 * @return La liste de clients et de comptes du conseiller
	 */
	@Override
	public ArrayList<Client> getListeClients(Conseiller cons) {
		ArrayList<Client> listeClients = new ArrayList<Client>();
		
		Compte coTemp = null;
		try {
			Connection cnx = BddConnector.connect();

			String sql = "select * from Client where idcons = ?";
			PreparedStatement stat = cnx.prepareStatement(sql);
			stat.setInt(1, cons.getIdcons());
			ResultSet res = stat.executeQuery();
			while(res.next()) {
				Client cTemp = new Client();
				cTemp.setId(res.getInt("idclient"));
				cTemp.setNom(res.getString("nom"));
				cTemp.setPrenom(res.getString("prenom"));
				cTemp.setAdresse(res.getString("adresse"));
				cTemp.setCodePostal(res.getString("codepostal"));
				cTemp.setVille(res.getString("ville"));
				cTemp.setTelephone(res.getString("telephone"));
				cTemp.setCons(cons.getIdcons());
				listeClients.add(cTemp);
			}
			
			for (Client c : listeClients) {
			ArrayList<Compte> listeComptes = new ArrayList<Compte>();
			String sql2 = "select * from compte where idclient = ?";
			PreparedStatement stat2 = cnx.prepareStatement(sql2);
			stat2.setInt(1, c.getId());
			ResultSet res2 = stat2.executeQuery();
			while(res2.next()) {
				if (res2.getString("type").equals("Courant")) {
					coTemp = new CompteCourant();
					((CompteCourant) coTemp).setAutorisationDecouvert(res2.getDouble("autodecouvert"));
				} else if (res2.getString("type").equals("Epargne")) {
					coTemp = new CompteEpargne();
					((CompteEpargne) coTemp).setTauxRemuneration(res2.getDouble("taux"));
				}
				coTemp.setIdcli(res2.getInt("idclient"));
				coTemp.setNumCompte(res2.getInt("numCompte"));
				coTemp.setSolde(res2.getDouble("solde"));
				coTemp.setDateOuverture(res2.getDate("dateOuverture"));
				listeComptes.add(coTemp);
			}
			c.setListeComptes(listeComptes);
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeClients;
	}

}
