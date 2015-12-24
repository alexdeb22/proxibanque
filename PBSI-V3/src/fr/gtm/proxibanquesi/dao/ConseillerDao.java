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
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.exceptions.LigneExistanteException;
import fr.gtm.proxibanquesi.exceptions.LigneInexistanteException;

/** Cette classe implémentent les méthodes de CRUD pour la table 
 * CONSEILLER de la base de données.
 * 
 * @author Alexandre De Bruyn
 *
 */
public class ConseillerDao implements IConseillerDao {

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


	
	@Override
	public ArrayList<Client> getListeClients(Conseiller cons) {
		ArrayList<Client> listeClients = new ArrayList<Client>();
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

		} catch (SQLException ex) {
			Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listeClients;
	}

}
