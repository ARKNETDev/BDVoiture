package com.iia.btse2.Carsgbd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;

public class WinMain {

	private JFrame frame;
	private JTextField Txt_Identifiant;
	private JTextField Txt_Marque;
	private JTextField Txt_Annee;
	private JTextField Txt_Couleur;
	private JTextField Txt_Modele;
	private JTextField Txt_Vitesse;
	private JTextField Txt_Prix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinMain window = new WinMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WinMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnInsertcar = new JButton("INSERTCAR");
		menuBar.add(btnInsertcar);
		
		JButton btnUpdateCar = new JButton("UPDATE CAR");
		menuBar.add(btnUpdateCar);
		
		JButton btnDeleteCar = new JButton("DELETE CAR");
		menuBar.add(btnDeleteCar);
		
		JButton btnExit = new JButton("EXIT");
		menuBar.add(btnExit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
		gbc_lblIdentifiant.anchor = GridBagConstraints.EAST;
		gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentifiant.gridx = 0;
		gbc_lblIdentifiant.gridy = 0;
		frame.getContentPane().add(lblIdentifiant, gbc_lblIdentifiant);
		
		Txt_Identifiant = new JTextField();
		GridBagConstraints gbc_Txt_Identifiant = new GridBagConstraints();
		gbc_Txt_Identifiant.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Identifiant.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Identifiant.gridx = 1;
		gbc_Txt_Identifiant.gridy = 0;
		frame.getContentPane().add(Txt_Identifiant, gbc_Txt_Identifiant);
		Txt_Identifiant.setColumns(10);
		
		JLabel lblAnnee = new JLabel("Annee");
		GridBagConstraints gbc_lblAnnee = new GridBagConstraints();
		gbc_lblAnnee.anchor = GridBagConstraints.EAST;
		gbc_lblAnnee.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnee.gridx = 2;
		gbc_lblAnnee.gridy = 0;
		frame.getContentPane().add(lblAnnee, gbc_lblAnnee);
		
		Txt_Annee = new JTextField();
		GridBagConstraints gbc_Txt_Annee = new GridBagConstraints();
		gbc_Txt_Annee.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Annee.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Annee.gridx = 3;
		gbc_Txt_Annee.gridy = 0;
		frame.getContentPane().add(Txt_Annee, gbc_Txt_Annee);
		Txt_Annee.setColumns(10);
		
		JLabel lblModele = new JLabel("Modele");
		GridBagConstraints gbc_lblModele = new GridBagConstraints();
		gbc_lblModele.anchor = GridBagConstraints.EAST;
		gbc_lblModele.insets = new Insets(0, 0, 5, 5);
		gbc_lblModele.gridx = 4;
		gbc_lblModele.gridy = 0;
		frame.getContentPane().add(lblModele, gbc_lblModele);
		
		Txt_Modele = new JTextField();
		GridBagConstraints gbc_Txt_Modele = new GridBagConstraints();
		gbc_Txt_Modele.anchor = GridBagConstraints.NORTH;
		gbc_Txt_Modele.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Modele.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Modele.gridx = 5;
		gbc_Txt_Modele.gridy = 0;
		frame.getContentPane().add(Txt_Modele, gbc_Txt_Modele);
		Txt_Modele.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix");
		GridBagConstraints gbc_lblPrix = new GridBagConstraints();
		gbc_lblPrix.anchor = GridBagConstraints.EAST;
		gbc_lblPrix.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrix.gridx = 6;
		gbc_lblPrix.gridy = 0;
		frame.getContentPane().add(lblPrix, gbc_lblPrix);
		
		Txt_Prix = new JTextField();
		GridBagConstraints gbc_Txt_Prix = new GridBagConstraints();
		gbc_Txt_Prix.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Prix.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Prix.gridx = 7;
		gbc_Txt_Prix.gridy = 0;
		frame.getContentPane().add(Txt_Prix, gbc_Txt_Prix);
		Txt_Prix.setColumns(10);
		
		JLabel lblMarque = new JLabel("Marque");
		GridBagConstraints gbc_lblMarque = new GridBagConstraints();
		gbc_lblMarque.anchor = GridBagConstraints.EAST;
		gbc_lblMarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarque.gridx = 0;
		gbc_lblMarque.gridy = 1;
		frame.getContentPane().add(lblMarque, gbc_lblMarque);
		
		Txt_Marque = new JTextField();
		GridBagConstraints gbc_Txt_Marque = new GridBagConstraints();
		gbc_Txt_Marque.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Marque.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Marque.gridx = 1;
		gbc_Txt_Marque.gridy = 1;
		frame.getContentPane().add(Txt_Marque, gbc_Txt_Marque);
		Txt_Marque.setColumns(10);
		
		JLabel lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.anchor = GridBagConstraints.EAST;
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 2;
		gbc_lblCouleur.gridy = 1;
		frame.getContentPane().add(lblCouleur, gbc_lblCouleur);
		
		Txt_Couleur = new JTextField();
		GridBagConstraints gbc_Txt_Couleur = new GridBagConstraints();
		gbc_Txt_Couleur.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Couleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Couleur.gridx = 3;
		gbc_Txt_Couleur.gridy = 1;
		frame.getContentPane().add(Txt_Couleur, gbc_Txt_Couleur);
		Txt_Couleur.setColumns(10);
		
		JLabel lblVitesse = new JLabel("Vitesse");
		GridBagConstraints gbc_lblVitesse = new GridBagConstraints();
		gbc_lblVitesse.anchor = GridBagConstraints.EAST;
		gbc_lblVitesse.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitesse.gridx = 4;
		gbc_lblVitesse.gridy = 1;
		frame.getContentPane().add(lblVitesse, gbc_lblVitesse);
		
		Txt_Vitesse = new JTextField();
		GridBagConstraints gbc_Txt_Vitesse = new GridBagConstraints();
		gbc_Txt_Vitesse.insets = new Insets(0, 0, 5, 5);
		gbc_Txt_Vitesse.fill = GridBagConstraints.HORIZONTAL;
		gbc_Txt_Vitesse.gridx = 5;
		gbc_Txt_Vitesse.gridy = 1;
		frame.getContentPane().add(Txt_Vitesse, gbc_Txt_Vitesse);
		Txt_Vitesse.setColumns(10);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 11;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		frame.getContentPane().add(list, gbc_list);
	}

}
