package com.iia.btse2.Carsgbd;

import java.util.Scanner;

import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;

public class Main {

	public static void main(String[] args) {
		//Création de la voiture DAO
		VoitureDAO cDao = new VoitureDAO();
		boolean result;
		Scanner scan = new Scanner(System.in);
		int application = 1;
		int choix = 0;
		int i = 0;
		System.out.println("Bienvenue dans notre Magasin !");
		System.out.println("");
		System.out.println("1 - RESTER ");
		System.out.println("0 - QUITTER ");
		int entree = scan.nextInt();
		switch (entree) {
		case 1:
			while (application == 1) {
				System.out.println("");
				System.out.println("1 - Insérer une voiture");
				System.out.println("2 - Modifier une voiture");
				System.out.println("3 - Supprimer une voiture");
				System.out.println("4 - Afficher une voiture");
				System.out.println("5 - Afficher toutes les voitures");
				System.out.println("6 - Quitter");
				System.out.println("");
				choix = scan.nextInt();
				switch (choix) {
				case 1:
					String marque, modele, couleur;
					int annee, vitesse;
					float prix;
					Voiture newcar = new Voiture();
					System.out.println("INSERTION D'UN VEHICULE");
					
					System.out.println("");
					System.out.println("Saissisez la marque");
					marque = scan.nextLine();
					newcar.setMarque(marque);
					
					System.out.println("");
					System.out.println("Saissisez l'année");
					annee = scan.nextInt();
					newcar.setAnnee(annee);
					
					System.out.println("");
					System.out.println("Saissisez le modele");
					modele = scan.nextLine();
					newcar.setModele(modele);
					
					System.out.println("");
					System.out.println("Saissisez la couleur");
					couleur = scan.nextLine();
					newcar.setCouleur(couleur);
					
					System.out.println("");
					System.out.println("Saissisez le prix");
					prix = scan.nextFloat();
					newcar.setPrix(prix);
					
					System.out.println("");
					System.out.println("Saissisez le vitesse");
					vitesse = scan.nextInt();
					newcar.setVitesse(vitesse);
					
					result = cDao.create(newcar);
					break;

				case 2:
					
					break;
					
				case 3:
					System.out.println("Supprimer");
					break;
					
				case 4:
					System.out.println("Afficher");
					break;
	
				case 5:
					application = 0;
					break;
					
				default:
					break;
				}
			}
			break;

		case 0:
			application = 0;
			System.out.println("AU REVOIR");
		default:
			break;
		}
		
		
	}

}
