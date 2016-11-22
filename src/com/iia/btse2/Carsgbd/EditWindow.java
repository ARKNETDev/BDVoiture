package com.iia.btse2.Carsgbd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;

public class EditWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_Marque;
	private JTextField txt_Modele;
	private JTextField txt_Couleur;
	private JTextField txt_Annee;
	private JTextField txt_Vitesse;
	private JTextField txt_Prix;
	private JButton btnEdit;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditWindow frame = new EditWindow();
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
	public EditWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnEdit = new JButton("EDIT");
		panel.add(btnEdit);

		JButton btnCancel = new JButton("CANCEL");
		panel.add(btnCancel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel lblModifierUneVoiture = new JLabel("MODIFIER UNE VOITURE");
		lblModifierUneVoiture.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 30));
		panel_1.add(lblModifierUneVoiture);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblMarque = new JLabel("Marque");
		GridBagConstraints gbc_lblMarque = new GridBagConstraints();
		gbc_lblMarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarque.gridx = 1;
		gbc_lblMarque.gridy = 1;
		panel_2.add(lblMarque, gbc_lblMarque);

		txt_Marque = new JTextField();
		GridBagConstraints gbc_txt_Marque = new GridBagConstraints();
		gbc_txt_Marque.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Marque.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Marque.gridx = 2;
		gbc_txt_Marque.gridy = 1;
		panel_2.add(txt_Marque, gbc_txt_Marque);
		txt_Marque.setColumns(10);

		JLabel lblAnnee = new JLabel("Annee");
		GridBagConstraints gbc_lblAnnee = new GridBagConstraints();
		gbc_lblAnnee.anchor = GridBagConstraints.EAST;
		gbc_lblAnnee.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnee.gridx = 4;
		gbc_lblAnnee.gridy = 1;
		panel_2.add(lblAnnee, gbc_lblAnnee);

		txt_Annee = new JTextField();
		GridBagConstraints gbc_txt_Annee = new GridBagConstraints();
		gbc_txt_Annee.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Annee.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Annee.gridx = 5;
		gbc_txt_Annee.gridy = 1;
		panel_2.add(txt_Annee, gbc_txt_Annee);
		txt_Annee.setColumns(10);

		JLabel lblModele = new JLabel("Modele");
		GridBagConstraints gbc_lblModele = new GridBagConstraints();
		gbc_lblModele.insets = new Insets(0, 0, 5, 5);
		gbc_lblModele.gridx = 1;
		gbc_lblModele.gridy = 3;
		panel_2.add(lblModele, gbc_lblModele);

		txt_Modele = new JTextField();
		GridBagConstraints gbc_txt_Modele = new GridBagConstraints();
		gbc_txt_Modele.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Modele.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Modele.gridx = 2;
		gbc_txt_Modele.gridy = 3;
		panel_2.add(txt_Modele, gbc_txt_Modele);
		txt_Modele.setColumns(10);

		JLabel lblVitesse = new JLabel("Vitesse");
		GridBagConstraints gbc_lblVitesse = new GridBagConstraints();
		gbc_lblVitesse.anchor = GridBagConstraints.EAST;
		gbc_lblVitesse.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitesse.gridx = 4;
		gbc_lblVitesse.gridy = 3;
		panel_2.add(lblVitesse, gbc_lblVitesse);

		txt_Vitesse = new JTextField();
		GridBagConstraints gbc_txt_Vitesse = new GridBagConstraints();
		gbc_txt_Vitesse.insets = new Insets(0, 0, 5, 5);
		gbc_txt_Vitesse.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Vitesse.gridx = 5;
		gbc_txt_Vitesse.gridy = 3;
		panel_2.add(txt_Vitesse, gbc_txt_Vitesse);
		txt_Vitesse.setColumns(10);

		JLabel lblCouleur = new JLabel("Couleur");
		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
		gbc_lblCouleur.insets = new Insets(0, 0, 0, 5);
		gbc_lblCouleur.gridx = 1;
		gbc_lblCouleur.gridy = 5;
		panel_2.add(lblCouleur, gbc_lblCouleur);

		txt_Couleur = new JTextField();
		GridBagConstraints gbc_txt_Couleur = new GridBagConstraints();
		gbc_txt_Couleur.insets = new Insets(0, 0, 0, 5);
		gbc_txt_Couleur.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Couleur.gridx = 2;
		gbc_txt_Couleur.gridy = 5;
		panel_2.add(txt_Couleur, gbc_txt_Couleur);
		txt_Couleur.setColumns(10);

		JLabel lblPrix = new JLabel("Prix");
		GridBagConstraints gbc_lblPrix = new GridBagConstraints();
		gbc_lblPrix.anchor = GridBagConstraints.EAST;
		gbc_lblPrix.insets = new Insets(0, 0, 0, 5);
		gbc_lblPrix.gridx = 4;
		gbc_lblPrix.gridy = 5;
		panel_2.add(lblPrix, gbc_lblPrix);

		txt_Prix = new JTextField();
		GridBagConstraints gbc_txt_Prix = new GridBagConstraints();
		gbc_txt_Prix.insets = new Insets(0, 0, 0, 5);
		gbc_txt_Prix.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_Prix.gridx = 5;
		gbc_txt_Prix.gridy = 5;
		panel_2.add(txt_Prix, gbc_txt_Prix);
		txt_Prix.setColumns(10);

		btnEdit.addActionListener(new ActionListener() {
			Voiture updatetcar = new Voiture();
			VoitureDAO cDao = new VoitureDAO();

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == btnEdit) {

					updatetcar.setMarque(EditWindow.this.txt_Marque.getText());
					updatetcar.setModele(EditWindow.this.txt_Modele.getText());
					updatetcar.setCouleur(EditWindow.this.txt_Couleur.getText());
					updatetcar.setAnnee(EditWindow.this.txt_Annee.getText());
					updatetcar.setVitesse(Integer.parseInt(EditWindow.this.txt_Vitesse.getText()));
					updatetcar.setPrix(Integer.parseInt(EditWindow.this.txt_Prix.getText()));
					cDao.update(updatetcar);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
