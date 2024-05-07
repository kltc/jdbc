package fr.digi.d022024.jdbc.dao;

import java.util.List;

import fr.digi.d022024.jdbc.entites.Fournisseur;

public interface FournisseurDao {

	List<Fournisseur> extraire();

	void insert(Fournisseur fournisseur) throws Exception;

	int update(String ancienNom, String nouveauNom) throws Exception;

	boolean delete(Fournisseur fournisseur) throws Exception;
}
