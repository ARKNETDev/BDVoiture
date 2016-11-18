package com.iia.btse2.Carsgbd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;

public class InsertWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Marque;
	private JTextField txt_Modele;
	private JTextField txt_Couleur;
	private JTextField txt_Annee;
	private JTextField txt_Vitesse;
	private JTextField txt_Prix;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertWindow frame = new InsertWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InsertWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblMarque = new JLabel("Marque");
		GridBagConstraints gbc_lblMarque = new GridBagConstraints();
		gbc_lblMarque.anchor = GridBagConstraints.EAST;
		gbc_lblMarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarque.gridx = 1;
		gbc_lblMarque.gridy = 1;
		contentPane.add(lblMarque, gbc_lblMarque);
		
		txt_Marque = new JTextField();
		GridBagConstraints gbc_txt_Marque = new GridBagConstraints();
		gbc_txt_Marque.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Marque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Marque.gridx = 2;
		gbc_txt_Marque.gridy = 1;
		contentPane.add(txt_Marque, gbc_txt_Marque);
		txt_Marque.setColumns(10);
		
		JLabel lblVitesse = new JLabel("Vitesse");
		GridBagConstraints gbc_lblVitesse = new GridBagConstraints();
		gbc_lblVitesse.anchor = GridBagConstraints.EAST;
		gbc_lblVitesse.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitesse.gridx = 4;
		gbc_lblVitesse.gridy = 1;
		contentPane.add(lblVitesse, gbc_lblVitesse);
		
		txt_Vitesse = new JTextField();
		GridBagConstraints gbc_txt_Vitesse = new GridBagConstraints();
		gbc_txt_Vitesse.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Vitesse.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Vitesse.gridx = 5;
		gbc_txt_Vitesse.gridy = 1;
		contentPane.add(txt_Vitesse, gbc_txt_Vitesse);
		txt_Vitesse.setColumns(10);
		
		JLabel lblModele = new JLabel("Modele");
		GridBagConstraints gbc_lblModele = new GridBagConstraints();
		gbc_lblModele.anchor = GridBagConstraints.EAST;
		gbc_lblModele.insets = new Insets(0, 0, 5, 5);
		gbc_lblModele.gridx = 1;
		gbc_lblModele.gridy = 3;
		contentPane.add(lblModele, gbc_lblModele);
		
		txt_Modele = new JTextField();
		GridBagConstraints gbc_txt_Modele = new GridBagConstraints();
		gbc_txt_Modele.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Modele.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Modele.gridx = 2;
		gbc_txt_Modele.gridy = 3;
		contentPane.add(txt_Modele, gbc_txt_Modele);
		txt_Modele.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix");
		GridBagConstraints gbc_lblPrix = new GridBagConstraints();
		gbc_lblPrix.anchor = GridBagConstraints.EAST;
		gbc_lblPrix.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrix.gridx = 4;
		gbc_lblPrix.gridy = 3;
		contentPane.add(lblPrix, gbc_lblPrix);
		
		txt_Prix = new JTextField();
		GridBagConstraints gbc_txt_Prix = new GridBagConstraints();
		gbc_txt_Prix.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Prix.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Prix.gridx = 5;
		gbc_txt_Prix.gridy = 3;
		contentPane.add(txt_Prix, gbc_txt_Prix);
		txt_Prix.setColumns(10);
		
		JLabel lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.anchor = GridBagConstraints.EAST;
		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleur.gridx = 1;
		gbc_lblCouleur.gridy = 5;
		contentPane.add(lblCouleur, gbc_lblCouleur);
		
		txt_Couleur = new JTextField();
		GridBagConstraints gbc_txt_Couleur = new GridBagConstraints();
		gbc_txt_Couleur.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Couleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Couleur.gridx = 2;
		gbc_txt_Couleur.gridy = 5;
		contentPane.add(txt_Couleur, gbc_txt_Couleur);
		txt_Couleur.setColumns(10);
		
		JLabel lblAnnee = new JLabel("Annee");
		GridBagConstraints gbc_lblAnnee = new GridBagConstraints();
		gbc_lblAnnee.anchor = GridBagConstraints.EAST;
		gbc_lblAnnee.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnee.gridx = 1;
		gbc_lblAnnee.gridy = 7;
		contentPane.add(lblAnnee, gbc_lblAnnee);
		
		txt_Annee = new JTextField();
		GridBagConstraints gbc_txt_Annee = new GridBagConstraints();
		gbc_txt_Annee.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Annee.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Annee.gridx = 2;
		gbc_txt_Annee.gridy = 7;
		contentPane.add(txt_Annee, gbc_txt_Annee);
		txt_Annee.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		GridBagConstraints gbc_btnInsert = new GridBagConstraints();
		gbc_btnInsert.insets = new Insets(0, 0, 0, 5);
		gbc_btnInsert.gridx = 2;
		gbc_btnInsert.gridy = 9;
		contentPane.add(btnInsert, gbc_btnInsert);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 5;
		gbc_btnCancel.gridy = 9;
		contentPane.add(btnCancel, gbc_btnCancel);
		
		btnInsert.addActionListener(new ActionListener() {
			Voiture insertcar = new Voiture();
			VoitureDAO cDao = new VoitureDAO();
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnInsert){	
					insertcar.setMarque(InsertWindow.this.txt_Marque.getText());
					insertcar.setModele(InsertWindow.this.txt_Modele.getText());
					insertcar.setCouleur(InsertWindow.this.txt_Couleur.getText());
					insertcar.setAnnee(Integer.parseInt(InsertWindow.this.txt_Annee.getText()));
					insertcar.setVitesse(Integer.parseInt(InsertWindow.this.txt_Vitesse.getText()));
					insertcar.setPrix(Integer.parseInt(InsertWindow.this.txt_Prix.getText()));
					cDao.create(insertcar);
				}	
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == btnCancel){
					InsertWindow.this.setVisible(false);
				}
			}
		});
		
	}

}


