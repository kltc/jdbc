package fr.digi.d022024.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.digi.d022024.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc2 implements FournisseurDao {

	private static final String SELECT_QUERY = "SELECT * FROM FOURNISSEUR";
	private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR(NOM) VALUES (?)";
	private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?";
	private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = ?";

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
				PreparedStatement st = connection.prepareStatement(SELECT_QUERY);
				ResultSet rs = st.executeQuery()) {

			List<Fournisseur> fournisseurs = new ArrayList<>();

			// R -> Read
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
				PreparedStatement st = connection.prepareStatement(INSERT_QUERY);) {

			// C -> Create
			st.setString(1, fournisseur.getNom());
			st.executeUpdate();
		}
	}

	@Override
	public int update(String ancienNom, String nouveauNom) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				PreparedStatement st = connection.prepareStatement(UPDATE_QUERY);) {

			// U -> Update
			st.setString(1, nouveauNom);
			st.setString(2, ancienNom);
			st.executeUpdate();
		}
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) throws SQLException {

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
				PreparedStatement st = connection.prepareStatement(DELETE_QUERY);) {

			// D -> Delete
			st.setString(1, fournisseur.getNom());
			st.executeUpdate();
		}
		return false;
	}

}
