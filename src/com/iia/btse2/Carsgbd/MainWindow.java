package com.iia.btse2.Carsgbd;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 172, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton insertWinCar = new JButton("INSERT CAR");
		
		GridBagConstraints gbc_insertWinCar = new GridBagConstraints();
		gbc_insertWinCar.insets = new Insets(0, 0, 5, 0);
		gbc_insertWinCar.anchor = GridBagConstraints.SOUTH;
		gbc_insertWinCar.gridx = 1;
		gbc_insertWinCar.gridy = 1;
		contentPane.add(insertWinCar, gbc_insertWinCar);
		
		JButton btnReadCar = new JButton("READ CAR");
		GridBagConstraints gbc_btnReadCar = new GridBagConstraints();
		gbc_btnReadCar.insets = new Insets(0, 0, 5, 0);
		gbc_btnReadCar.gridx = 1;
		gbc_btnReadCar.gridy = 2;
		contentPane.add(btnReadCar, gbc_btnReadCar);
		
		btnReadCar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {		
				ReadWindow readwindow = new ReadWindow();
				readwindow.setVisible(true);		
			}
		});
		
		JButton btnCancel = new JButton("CANCEL");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridx = 1;
		gbc_btnCancel.gridy = 5;
		contentPane.add(btnCancel, gbc_btnCancel);
		
		insertWinCar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InsertWindow insertwindow = new InsertWindow();
				insertwindow.setVisible(true);
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {		
				
				MainWindow.this.setVisible(false);
				MainWindow.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}

}
