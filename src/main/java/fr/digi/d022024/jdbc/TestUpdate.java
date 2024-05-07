package fr.digi.d022024.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

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
		int nb = monStatement.executeUpdate(
				"UPDATE fournisseur SET nom = 'La Maison des Peintures' WHERE nom = 'La Maison de la Peinture'");
		maConnexion.close();

	}

}