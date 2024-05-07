package fr.digi.d022024.jdbc.dao;

import fr.digi.d022024.jdbc.entites.Fournisseur;

public class TestDaoJdbc {

	public static void main(String[] args) {

		FournisseurDao dao = new FournisseurDaoJdbc();

//		try {
//			dao.insert(new Fournisseur("France de matériaux"));
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}

//		try {
//			dao.update("France de matériaux", "France matériaux");
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}

//		try {
//			dao.delete(new Fournisseur("France matériaux"));
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}

//		dao.extraire();

//		try {
//			dao.insert(new Fournisseur("L''Espace Création"));
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}

		dao.extraire();

	}
}
