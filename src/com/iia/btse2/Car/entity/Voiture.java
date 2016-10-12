package com.iia.btse2.Car.entity;

public class Voiture {
	
	private int ID;
	private String Marque;
	private int Annee;
	private String Modele;
	private String Couleur;
	private float Prix;
	private int Vitesse;
	
	public Voiture(int iD, String marque, int annee, String modele, String couleur, float prix, int vitesse) {
		super();
		ID = iD;
		Marque = marque;
		Annee = annee;
		Modele = modele;
		Couleur = couleur;
		Prix = prix;
		Vitesse = vitesse;
	}

	public Voiture() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMarque() {
		return Marque;
	}

	public void setMarque(String marque) {
		Marque = marque;
	}

	public int getAnnee() {
		return Annee;
	}

	public void setAnnee(int annee) {
		Annee = annee;
	}

	public String getModele() {
		return Modele;
	}

	public void setModele(String modele) {
		Modele = modele;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public float getPrix() {
		return Prix;
	}

	public void setPrix(float prix) {
		Prix = prix;
	}

	public int getVitesse() {
		return Vitesse;
	}

	public void setVitesse(int vitesse) {
		Vitesse = vitesse;
	}
	
	
}
