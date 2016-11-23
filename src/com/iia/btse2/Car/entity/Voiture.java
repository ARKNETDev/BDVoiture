package com.iia.btse2.Car.entity;

public class Voiture {
	
	private int id;
	private String marque;
	private String annee;
	private String modele;
	private String couleur;
	private float prix;
	private int vitesse;
	
	public Voiture(int iD, String marque, String annee, String modele, String couleur, float prix, int vitesse) {
		super();
		this.id = iD;
		this.marque = marque;
		this.annee = annee;
		this.modele = modele;
		this.couleur = couleur;
		this.prix = prix;
		this.vitesse = vitesse;
	}

	public Voiture() {
		super();
	}

	public int getID() {
		return this.id;
	}

	public void setID(int iD) {
		this.id = iD;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getAnnee() {
		return this.annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getVitesse() {
		return this.vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String value =  "Identifiant : " + this.id + " - Marque : " + this.marque + " - Modele :"
		+ this.modele + " - Couleur : " + this.couleur + " - Annee : " + this.annee + " - Vitesse : " 
		+ this.vitesse;
		return value;
	}
	
	
}
