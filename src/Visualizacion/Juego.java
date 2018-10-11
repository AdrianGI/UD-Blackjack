package Visualizacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Juego extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	/**
	 * Create the frame.
	 */
	public Juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBounds(5, 5, 440, 35);
		panelNorte.setBorder(null);
		panelNorte.setBackground(new Color(0, 100, 0));
		contentPane.add(panelNorte);
		
		JLabel lblBlackjack = new JLabel("BLACKJACK");
		lblBlackjack.setBackground(new Color(0, 100, 0));
		lblBlackjack.setFont(new Font("Optima", Font.BOLD | Font.ITALIC, 20));
		panelNorte.add(lblBlackjack);
		
		JPanel panelSur = new JPanel();
		panelSur.setBounds(5, 251, 440, 22);
		panelSur.setBackground(new Color(0, 100, 0));
		contentPane.add(panelSur);
		panelSur.setLayout(null);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(75, 0, 83, 29);
		panelSur.add(btnVolver);
		
		JPanel panelOeste_1 = new JPanel();
		panelOeste_1.setBounds(5, 40, 1, 223);
		panelOeste_1.setBorder(null);
		panelOeste_1.setBackground(new Color(0, 100, 0));
		contentPane.add(panelOeste_1);
		panelOeste_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 5, 61, 16);
		panelOeste_1.add(lblNewLabel);
		
		JPanel panel_Este = new JPanel();
		panel_Este.setBounds(435, 40, 10, 223);
		panel_Este.setBackground(new Color(0, 100, 0));
		panel_Este.setBorder(null);
		panel_Este.setForeground(new Color(0, 100, 0));
		contentPane.add(panel_Este);
		
		JPanel panel_Centro = new JPanel();
		panel_Centro.setBounds(6, 40, 429, 223);
		panel_Centro.setBackground(new Color(0, 100, 0));
		contentPane.add(panel_Centro);
		panel_Centro.setLayout(null);
		
		JLabel lblDealer = new JLabel("DEALER");
		lblDealer.setBounds(6, 33, 61, 16);
		panel_Centro.add(lblDealer);
		
		JLabel lblJugador = new JLabel("JUGADOR");
		lblJugador.setBounds(6, 132, 61, 16);
		panel_Centro.add(lblJugador);
		
		textField = new JTextField();
		textField.setBounds(6, 53, 28, 26);
		panel_Centro.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(6, 156, 28, 26);
		panel_Centro.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel D1 = new JPanel();
		D1.setBounds(95, 23, 41, 56);
		panel_Centro.add(D1);
		
		JPanel D2 = new JPanel();
		D2.setBounds(148, 23, 41, 56);
		panel_Centro.add(D2);
		
		JPanel D3 = new JPanel();
		D3.setBounds(203, 23, 41, 56);
		panel_Centro.add(D3);
		
		JPanel J1 = new JPanel();
		J1.setBounds(95, 126, 41, 56);
		panel_Centro.add(J1);
		
		JPanel J2 = new JPanel();
		J2.setBounds(148, 126, 41, 56);
		panel_Centro.add(J2);
		
		JPanel J3 = new JPanel();
		J3.setBounds(203, 126, 41, 56);
		panel_Centro.add(J3);
		
		JPanel D4 = new JPanel();
		D4.setBounds(256, 23, 41, 56);
		panel_Centro.add(D4);
		
		JPanel J4 = new JPanel();
		J4.setBounds(256, 126, 41, 56);
		panel_Centro.add(J4);
		
		JPanel D5 = new JPanel();
		D5.setBounds(310, 23, 41, 56);
		panel_Centro.add(D5);
		
		JPanel J5 = new JPanel();
		J5.setBounds(309, 126, 41, 56);
		panel_Centro.add(J5);
		
		JPanel BARAJA = new JPanel();
		BARAJA.setBounds(382, 76, 41, 56);
		panel_Centro.add(BARAJA);
		
		JButton btnNewButton = new JButton("Apostar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(319, 194, 76, 16);
		panel_Centro.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(395, 188, 28, 26);
		panel_Centro.add(textField_2);
		textField_2.setColumns(10);
	}
}
