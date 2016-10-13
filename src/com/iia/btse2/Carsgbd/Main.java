package com.iia.btse2.Carsgbd;

import java.util.List;
import java.util.Scanner;

import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;

public class Main {

	public static void main(String[] args) {
		// Création de la voiture DAO
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
					/*String marque, modele, couleur;
					int annee, vitesse;
					float prix;*/
					Voiture newcar = new Voiture();
					result = cDao.create(newcar);
					/*System.out.println("INSERTION D'UN VEHICULE");

					System.out.println("");
					System.out.println("Saissisez la marque");
					newcar.setMarque(scan.nextLine(marque));

					System.out.println("");
					System.out.println("Saissisez l'année");
					newcar.setAnnee(scan.nextInt(annee));

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
					newcar.setVitesse(vitesse);*/

					
					break;

				case 2:
					Voiture carupdate;
					int choixupdate = 0;
					System.out.println("MODIFICATION D'UN VEHICULE");
					System.out.println("");
					System.out.println("Selectionner une voiture parmi celles de la base de données");
					i = scan.nextInt();
					carupdate = (Voiture) cDao.findById(i);
					System.out.println("");
					System.out.println("Identifiant : " + carupdate.getID());
					System.out.println("Marque : " + carupdate.getMarque());
					System.out.println("Annee : " + carupdate.getAnnee());
					System.out.println("Modéle : " + carupdate.getModele());
					System.out.println("Couleur : " + carupdate.getCouleur());
					System.out.println("Prix : " + carupdate.getPrix());
					System.out.println("Vitesse : " + carupdate.getVitesse());
					System.out.println("");
					System.out.println("Voulez-vous vraiment la modifier");
					choixupdate = scan.nextInt();
					switch (choixupdate) {
					case 1:
						
						String updatemarque, updatemodele, updatecouleur;
						int updateannee, updatevitesse;
						float updateprix;

						System.out.println("");
						System.out.println("Saissisez la marque");
						updatemarque = scan.nextLine();
						carupdate.setMarque(updatemarque);

						System.out.println("");
						System.out.println("Saissisez l'année");
						updateannee = scan.nextInt();
						carupdate.setAnnee(updateannee);

						System.out.println("");
						System.out.println("Saissisez le modele");
						updatemodele = scan.nextLine();
						carupdate.setModele(updatemodele);

						System.out.println("");
						System.out.println("Saissisez la couleur");
						updatecouleur = scan.nextLine();
						carupdate.setCouleur(updatecouleur);

						System.out.println("");
						System.out.println("Saissisez le prix");
						updateprix = scan.nextFloat();
						carupdate.setPrix(updateprix);

						System.out.println("");
						System.out.println("Saissisez le vitesse");
						updatevitesse = scan.nextInt();
						carupdate.setVitesse(updatevitesse);
						result = cDao.update(carupdate);
						break;
						
					case 2:
						System.out.println("ANNULER");
						break;

					default:
						break;
					}
					break;

				case 3:
					System.out.println("SUPPRESSION D'UNE VOITURE");
					Voiture cardelete;
					int choixdelete = 0;
					System.out.println("MODIFICATION D'UN VEHICULE");
					System.out.println("");
					System.out.println("Selectionner une voiture parmi celles de la base de données");
					i = scan.nextInt();
					cardelete = (Voiture) cDao.findById(i);
					System.out.println("");
					System.out.println("Identifiant : " + cardelete.getID());
					System.out.println("Marque : " + cardelete.getMarque());
					System.out.println("Annee : " + cardelete.getAnnee());
					System.out.println("Modéle : " + cardelete.getModele());
					System.out.println("Couleur : " + cardelete.getCouleur());
					System.out.println("Prix : " + cardelete.getPrix());
					System.out.println("Vitesse : " + cardelete.getVitesse());
					System.out.println("");
					System.out.println("Voulez-vous vraiment la modifier");
					choixdelete = scan.nextInt();
					switch (choixdelete) {
					case 1:
						result = cDao.delete(cardelete);
						break;

					case 2:
						System.out.println("ANNULER");
						break;

					default:
						break;
					}
					break;

				case 4:
					Voiture cardisplay;
					System.out.println("AFFICHAGE D'UNE VOITURE");
					System.out.println("Selectionner une voiture parmi celles de la base de données");
					i = scan.nextInt();
					cardisplay = (Voiture) cDao.findById(i);
					System.out.println("");
					System.out.println("Identifiant : " + cardisplay.getID());
					System.out.println("Marque : " + cardisplay.getMarque());
					System.out.println("Annee : " + cardisplay.getAnnee());
					System.out.println("Modéle : " + cardisplay.getModele());
					System.out.println("Couleur : " + cardisplay.getCouleur());
					System.out.println("Prix : " + cardisplay.getPrix());
					System.out.println("Vitesse : " + cardisplay.getVitesse());
					System.out.println("");
					break;

				case 5:
					List<Voiture> car = cDao.findAll();
					for (Voiture carlist : car) {
						System.out.println(carlist.getID());
					}
					break;
					
				case 6:
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
