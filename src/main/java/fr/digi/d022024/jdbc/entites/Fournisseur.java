package fr.digi.d022024.jdbc.entites;

public class Fournisseur {

	public int id;
	public String nom;

	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Fournisseur(String nom) {
		super();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
