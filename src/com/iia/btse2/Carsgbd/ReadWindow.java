package com.iia.btse2.Carsgbd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import com.iia.btse2.Car.dao.VoitureDAO;
import com.iia.btse2.Car.entity.Voiture;
import javax.swing.JTextField;

public class ReadWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadWindow frame = new ReadWindow();
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
	public ReadWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblTableauDesVoitures = new JLabel("TABLEAU DES VOITURES");
		lblTableauDesVoitures.setBackground(Color.WHITE);
		lblTableauDesVoitures.setFont(new Font("Segoe WP SemiLight", Font.PLAIN, 30));
		contentPane.add(lblTableauDesVoitures, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnEditCar = new JButton("UPDATE CAR");
		btnEditCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditWindow editwindow = new EditWindow();
				editwindow.setVisible(true);
			}
		});
		panel.add(btnEditCar);

		JButton btnCancel = new JButton("CANCEL");
		panel.add(btnCancel);
		
		JButton DeleteCar = new JButton("DELETE CAR");
		DeleteCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voiture deletecar = new Voiture();
				VoitureDAO cDao = new VoitureDAO();
				
				cDao.delete(deletecar);
				JOptionPane.showMessageDialog(null, "Element supprimé");
			}
		});
		panel.add(DeleteCar);

		VoitureDAO cDao = new VoitureDAO();

		JList list = new JList(cDao.findAll().toArray());
		contentPane.add(list, BorderLayout.CENTER);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ReadWindow.this.setVisible(false);

			}
		});
	}
}
