package fr.digi.d022024.jdbc.dao;

import fr.digi.d022024.jdbc.entites.Fournisseur;

public class TestDaoJdbc2 {

	public static void main(String[] args) {

		FournisseurDao dao = new FournisseurDaoJdbc();

		try {

//			dao.insert(new Fournisseur("France de matériaux"));
//
//			dao.extraire();
//
//			dao.update("France de matériaux", "France matériaux");
//
//			System.out.println("---------");
//
//			dao.extraire();
//
//			dao.delete(new Fournisseur("France matériaux"));
//
//			System.out.println("---------");
//
//			dao.extraire();
//
//			dao.insert(new Fournisseur("L''Espace Création"));
//
//			System.out.println("---------");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
