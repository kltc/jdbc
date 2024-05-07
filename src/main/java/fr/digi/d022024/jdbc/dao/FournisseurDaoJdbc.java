package fr.digi.d022024.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.digi.d022024.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR(NOM) VALUES('%s')";
	private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = ('%s') WHERE NOM = ('%s')";
	private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = ('%s')";

	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;

	static {

		ResourceBundle dbConfig = ResourceBundle.getBundle("db");
		DB_URL = dbConfig.getString("db.url");
		DB_USER = dbConfig.getString("db.user");
		DB_PWD = dbConfig.getString("db.pwd");
	}

	@Override
	public List<Fournisseur> extraire() {

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM FOURNISSEUR")) {

			List<Fournisseur> fournisseurs = new ArrayList<>();

			while (rs.next()) {

				int id = rs.getInt("ID");// getInt(1);
				String nom = rs.getString("NOM");// getInt(2);
				fournisseurs.add(new Fournisseur(id, nom));
			}

			fournisseurs.forEach(System.out::println);
			return fournisseurs;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public void insert(Fournisseur fournisseur) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				Statement st = connection.createStatement();) {

			// C -> Insertion
			String query = String.format(INSERT_QUERY, fournisseur.getNom());
			st.executeUpdate(query);
		}
	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				Statement st = connection.createStatement();) {

			// U -> Update
			String query = String.format(UPDATE_QUERY, nouveauNom, ancienNom);
			st.executeUpdate(query);
		}
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				Statement st = connection.createStatement();) {

			// D -> Delete
			String query = String.format(DELETE_QUERY, fournisseur.getNom());
			st.executeUpdate(query);
		}
		return false;
	}

}
