package com.iia.btse2.Car.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iia.btse2.Car.entity.Voiture;

public class VoitureDAO implements IDao<Voiture>{
	private static final String TABLE = "Car";
	private static final String ID = "Identifiant";
	private static final String MARQUE = "Marque";
	private static final String YEAR = "Annee";
	private static final String MODEL = "Modele";
	private static final String COLOR = "Couleur";
	private static final String PRICE = "Prix";
	private static final String SPEED = "Vitesse";

	@Override
	public boolean create(Voiture object) {
		String req = "INSERT INTO " + VoitureDAO.TABLE + "(" + VoitureDAO.MARQUE + ", " + VoitureDAO.YEAR + ", " + VoitureDAO.MODEL + ", " + VoitureDAO.COLOR + ", " + VoitureDAO.SPEED + ", " + VoitureDAO.PRICE + ")" 
				+ " VALUES('" + object.getMarque()+ "'," + object.getAnnee()+ ", '" + object.getModele()+ "', '" + object.getCouleur()+ "', " + object.getVitesse()+ ", " + object.getPrix()+ ");";
				
		try {
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(req) == 1) {
				return true;}
		} catch (SQLException e) {
			System.out.println("erreur lors de l'insertion de la voiture");
		}

		return false;
	}

	@Override
	public boolean update(Voiture object) {
		String req = String.format("UPDATE %s SET %s=%s,Annee=GETDATE(), %s=%s, %s=%s, %s=%s, %s=%s WHERE %s=?",
				VoitureDAO.TABLE,
				VoitureDAO.MARQUE,
				object.getMarque(),
				VoitureDAO.MODEL,
				object.getModele(),
				VoitureDAO.COLOR,
				object.getCouleur(),
				VoitureDAO.PRICE,
				object.getPrix(),
				VoitureDAO.SPEED,
				object.getVitesse(),
				VoitureDAO.ID,
				object.getID());
		
		try {
			PreparedStatement st = Connexion.getConnection().prepareStatement(req);
			st.setInt(object.getID(), 0);
			if (st.executeUpdate() >= 1) {
				return true;
			}
			/*Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(req) >= 1) {
				return true;}
			*/
		} catch (SQLException e) {
			System.out.println("erreur lors de la mise à jour de la voiture");
		}

		return false;
	}

	@Override
	public boolean delete(Voiture object) {
		String req = String.format("DELETE FROM %s WHERE %s=?",
				VoitureDAO.TABLE,
				VoitureDAO.ID);

		try {
			PreparedStatement st = Connexion.getConnection().prepareStatement(req);
			st.setInt(1, object.getID());
			if (st.executeUpdate() >= 1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la suppression de la voiture");
		}

		return false;
	}

	@Override
	public Voiture findById(int id) {
		String req = "SELECT * FROM "+ VoitureDAO.TABLE +" WHERE " + VoitureDAO.ID + "= " + id ;
		try {
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);

			if (rs.next()) {
				return this.cursorToVoiture(rs);
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la récupération de la voiture");
		}
		return null;
	}

	@Override
	public List<Voiture> findAll() {
		List<Voiture> voitures = new ArrayList<Voiture>();
		String req = String.format("SELECT * FROM %s", VoitureDAO.TABLE);
		try {
			PreparedStatement st = Connexion.getConnection().prepareStatement(req);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				voitures.add(this.cursorToVoiture(rs));
			}

			return voitures;

		} catch (SQLException e) {
			System.out.println("erreur lors de la récupération des voitures");
		}

		return null;
	}

	private Voiture cursorToVoiture(ResultSet resultSet) {
		Voiture voiture = null;
		try {
			voiture = new Voiture();
			voiture.setID(resultSet.getInt(VoitureDAO.ID));
			voiture.setMarque(resultSet.getString(VoitureDAO.MARQUE));
			voiture.setAnnee(resultSet.getInt(VoitureDAO.YEAR));
			voiture.setModele(resultSet.getString(VoitureDAO.MODEL));
			voiture.setCouleur(resultSet.getString(VoitureDAO.COLOR));
			voiture.setPrix(resultSet.getFloat(VoitureDAO.PRICE));
			voiture.setVitesse(resultSet.getInt(VoitureDAO.SPEED));
		} catch (SQLException e) {
			System.out.println("erreur lors de la récupération de la voiture");
		}

		return voiture;
	}
}
