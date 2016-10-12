package com.iia.btse2.Carsgbd;

import java.io.Console;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Console console = System.console();
		Scanner scan = new Scanner(System.in);
		int application = 1;
		int choix = 0;
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
				System.out.println("4 - Afficher toutes les voitures");
				System.out.println("5 - Quitter");
				System.out.println("");
				choix = scan.nextInt();
				switch (choix) {
				case 1:
					System.out.println("Insérer");
					break;

				case 2:
					System.out.println("Modifier");
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
