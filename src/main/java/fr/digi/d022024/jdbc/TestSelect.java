package fr.digi.d022024.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.digi.d022024.jdbc.entites.Fournisseur;

public class TestSelect {

	private static final String DB_URL;
	private static final String DB_USER;
	private static final String DB_PWD;

	static {

		ResourceBundle dbConfig = ResourceBundle.getBundle("db");
		DB_URL = dbConfig.getString("db.url");
		DB_USER = dbConfig.getString("db.user");
		DB_PWD = dbConfig.getString("db.pwd");
	}

	public static void main(String[] args) throws SQLException {

		Connection maConnexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

		Statement monStatement = maConnexion.createStatement();

		ResultSet curseur = monStatement.executeQuery("SELECT * FROM fournisseur");

		ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

		while (curseur.next()) {
			Integer id = curseur.getInt("ID");
			String nom = curseur.getString("NOM");

			Fournisseur fournisseurCourant = new Fournisseur(id, nom);

			fournisseurs.add(fournisseurCourant);

		}

		curseur.close();
		monStatement.close();
		maConnexion.close();

		for (int i = 0; i < fournisseurs.size(); i++) {
			System.out.println(fournisseurs.get(i).toString());
		}

	}

}