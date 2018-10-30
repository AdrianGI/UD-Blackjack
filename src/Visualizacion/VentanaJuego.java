package Visualizacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Datos.Usuario;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;

	
	public VentanaJuego(VentanaMenu ventanaanterior,Usuario user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		//contentPane = new PanelFondo();
		contentPane = new PanelFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
	
		
		
		
		JButton jugar= new JButton("Jugar");
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		//constraints.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
		this.getContentPane().add(jugar,constraints);
		//constraints.weighty = 0.0; // La fila 0 debe estirarse, le ponemos un 1.0
		
		
		
		
		
	

	}
	

}