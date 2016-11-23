package com.iia.btse2.Carsgbd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;

import com.iia.btse2.Car.dao.Connexion;
import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;

public class WinMain extends JFrame {
	VoitureDAO cDao = new VoitureDAO();
	private JFrame frame;
	private JTextField Txt_Marque;
	private JTextField Txt_Annee;
	private JTextField Txt_Couleur;
	private JTextField Txt_Modele;
	private JTextField Txt_Vitesse;
	private JTextField Txt_Prix;
	private JList list;
	private JList list_1;
	private JComboBox comboBox;

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
		VoitureDAO cDao = new VoitureDAO();

		frame = new JFrame();
		frame.setBounds(100, 100, 629, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JButton btnInsertcar = new JButton("INSERT CAR");
		btnInsertcar.addActionListener(new ActionListener() {
			Voiture insertcar = new Voiture();
			VoitureDAO cDao = new VoitureDAO();

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnInsertcar) {

					insertcar.setMarque(WinMain.this.Txt_Marque.getText());
					insertcar.setModele(WinMain.this.Txt_Modele.getText());
					insertcar.setCouleur(WinMain.this.Txt_Couleur.getText());
					insertcar.setAnnee(WinMain.this.Txt_Annee.getText());
					insertcar.setVitesse(Integer.parseInt(WinMain.this.Txt_Vitesse.getText()));
					insertcar.setPrix(Integer.parseInt(WinMain.this.Txt_Prix.getText()));
					cDao.create(insertcar);
					cDao.findAll().toArray();
					JOptionPane.showMessageDialog(null, "Element inséré");

				}
			}
		});

		menuBar.add(btnInsertcar);

		JButton btnDeleteCar = new JButton("DELETE CAR");
		btnDeleteCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnDeleteCar) {
					deletecar(comboBox.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, "Element supprimé");
				}
			}

		});
		menuBar.add(btnDeleteCar);
		
		JButton btnUpdateCar = new JButton("UPDATE CAR");
		btnUpdateCar.addActionListener(new ActionListener() {
			Voiture updatecar = new Voiture();
			public void actionPerformed(ActionEvent e) {
				updatecar.getID();
				updatecar.setMarque((WinMain.this.Txt_Marque.getText()));
				updatecar.setModele((WinMain.this.Txt_Modele.getText()));
				updatecar.setCouleur((WinMain.this.Txt_Couleur.getText()));
				updatecar.setAnnee((WinMain.this.Txt_Annee.getText()));
				updatecar.setVitesse(Integer.parseInt(WinMain.this.Txt_Vitesse.getText()));
				updatecar.setPrix(Integer.parseInt(WinMain.this.Txt_Prix.getText()));
				cDao.update(updatecar);
			}
		});
		menuBar.add(btnUpdateCar);

		JButton btnExit = new JButton("EXIT");
		menuBar.add(btnExit);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblIdentifiant = new JLabel("Identifiant");
		GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
		gbc_lblIdentifiant.anchor = GridBagConstraints.EAST;
		gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdentifiant.gridx = 0;
		gbc_lblIdentifiant.gridy = 0;
		frame.getContentPane().add(lblIdentifiant, gbc_lblIdentifiant);

		comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = comboBox.getSelectedItem().toString();
				String req = String.format("Select * FROM Car WHERE Identifiant = " + id + ";");
				try {
					PreparedStatement st = Connexion.getConnection().prepareStatement(req);
					st.setString(2, (String) comboBox.getSelectedItem());

					ResultSet rs = st.executeQuery(req);
					while (rs.next()) {
						Txt_Marque.setText("Marque");
					}
				} catch (SQLException ex) {
					System.out.println("erreur lors de la récupération des champs de la voiture");
				}
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		frame.getContentPane().add(comboBox, gbc_comboBox);

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

		list_1 = new JList(cDao.findAll().toArray());
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 11;
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 2;
		frame.getContentPane().add(list_1, gbc_list);

		displayID();
		cDao.findAll().toArray();
	}

	public void displayID() {
		String req = "SELECT Identifiant FROM Car;";
		try {
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);

			while (rs.next()) {
				comboBox.addItem(rs.getString("Identifiant"));
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la récupération de l'ID de la voiture");
		}
		return;
	}

	public void deletecar(String id) {
		String req = String.format("DELETE FROM Car WHERE Identifiant=" + id + ";");

		try {
			Statement st = Connexion.getConnection().createStatement();
			if (st.executeUpdate(req) == 1) {
				return;
			}
		} catch (SQLException e) {
			System.out.println("erreur lors de la suppression de la voiture");
		}
		return;
	}

	public void displayChamps(String id) {
		String req = String.format("Select Marque FROM Car WHERE Identifiant=" + id + ";");
		try {
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			if (st.executeUpdate(req) == 1) {
				while (rs.next()) {
					String Marque = "dedz";
					Marque = Txt_Marque.getText();
				}
				return;
			}

		} catch (SQLException e) {
			System.out.println("erreur lors de la récupération de l'ID de la voiture");
		}
		return;
	}

	public void updatecar(String id){
		String req = String.format("UPDATE Car SET Marque= "+Txt_Marque.getText()+
				",Annee="+Txt_Annee.getText()+
				", Modele="+Txt_Modele.getText()+
				", Couleur="+Txt_Couleur.getText()+
				", Vitesse="+Txt_Vitesse.getText()+
				", Prix="+Txt_Prix.getText()+
				" WHERE Id= "+WinMain.this.comboBox.getSelectedIndex()+ ");");
		try {
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			if (st.executeUpdate(req) == 1) {
				while (rs.next()) {
					String Marque = "dedz";
					Marque = Txt_Marque.getText();
				}
				return;
			}

		} catch (SQLException e) {
			System.out.println("erreur lors de la modification de la voiture");
		}
	}
}
