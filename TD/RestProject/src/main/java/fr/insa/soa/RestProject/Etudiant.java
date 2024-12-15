package fr.insa.soa.RestProject;

public class Etudiant {
	private String nom;
	private String prenom;
	private Binome binome;
	public Etudiant() {
		super();
	}
	public Etudiant(String nom, String prenom, Binome binome) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.binome = binome;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom =  nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom =  prenom;
	}
	public Binome getBinome() {
		return binome;
	}
	public void setBinome(Binome binome) {
		this.binome =  binome;
	}
}
