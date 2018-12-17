package Visualizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.BD;
import Datos.Main;
import Datos.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	private static Usuario u;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public static Usuario getUser() {
		return u;
	}
	public VentanaMenu(Usuario user) {
		u = user;
		Properties properties = new Properties();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBounds(5, 5, 440, 35);
		panelNorte.setBorder(null);
		panelNorte.setBackground(Color.WHITE);
		contentPane.add(panelNorte);
		panelNorte.setLayout(null);
		
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setFont(new Font("American Typewriter", Font.ITALIC, 15));
		lblJugador.setBounds(16, 6, 83, 16);
		panelNorte.add(lblJugador);
		
		JLabel lblDinero = new JLabel("Dinero:");
		lblDinero.setFont(new Font("American Typewriter", Font.ITALIC, 15));
		lblDinero.setBounds(249, 6, 71, 16);
		panelNorte.add(lblDinero);
		
		JLabel lbljug = new JLabel(user.getNombre());
		lbljug.setFont(new Font("American Typewriter", Font.PLAIN, 15));
		lbljug.setBounds(91, 6, 106, 16);
		panelNorte.add(lbljug);
		
		float saldo = BD.obtenerSaldo(user.getNombre());
		user.setDinero(saldo);
		JLabel lbldin =  new JLabel(user.getDinero()+ "€");        
		lbldin.setFont(new Font("American Typewriter", Font.PLAIN, 14));
		lbldin.setBounds(318, 6, 99, 16);
		panelNorte.add(lbldin);
		
		JPanel panelOeste_1 = new JPanel();
		panelOeste_1.setBounds(5, 40, 23, 238);
		panelOeste_1.setBorder(null);
		panelOeste_1.setBackground(Color.WHITE);
		contentPane.add(panelOeste_1);
		panelOeste_1.setLayout(null);
		
		JPanel panel_Este = new JPanel();
		panel_Este.setBounds(422, 40, 23, 238);
		panel_Este.setBackground(Color.WHITE);
		panel_Este.setBorder(null);
		panel_Este.setForeground(new Color(0, 100, 0));
		contentPane.add(panel_Este);
		
		JPanel panel_Centro = new JPanel();
		panel_Centro.setBounds(26, 40, 397, 209);
		panel_Centro.setBackground(Color.WHITE);
		contentPane.add(panel_Centro);
		panel_Centro.setLayout(null);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaMenu.this.setVisible(false);
				VentanaJuego a  = new VentanaJuego(VentanaMenu.this, user);
				a.setVisible(true);
				
			}
		});
		btnJugar.setFont(new Font("Monospaced", Font.PLAIN, 16));
		btnJugar.setBounds(89, 6, 227, 29);
		panel_Centro.add(btnJugar);
		
		JButton btnIngresarDinero = new JButton("Ingresar Dinero");
		btnIngresarDinero.setFont(new Font("Monospaced", Font.PLAIN, 16));
		btnIngresarDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				VentanaIngresar a = new VentanaIngresar(VentanaMenu.this, user);
				a.setVisible(true);
			}
		});
		btnIngresarDinero.setBounds(89, 47, 227, 29);
		panel_Centro.add(btnIngresarDinero);
		
	
		
		JButton btnHistorial = new JButton("Historial");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenu.this.setVisible(false);
				VentanaHistorial a = new VentanaHistorial(VentanaMenu.this,user);
				a.setVisible(true);
			}
		});
		btnHistorial.setFont(new Font("Monospaced", Font.PLAIN, 16));
		btnHistorial.setBounds(89, 129, 227, 29);
		panel_Centro.add(btnHistorial);
		
		JButton btnRetirarDinero = new JButton("Retirar Dinero");
		btnRetirarDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRetirar a = new VentanaRetirar(VentanaMenu.this, user);
				a.setVisible(true);
				
			}
		});
		btnRetirarDinero.setFont(new Font("Monospaced", Font.PLAIN, 16));
		btnRetirarDinero.setBounds(89, 88, 227, 29);
		panel_Centro.add(btnRetirarDinero);
		
		JButton btnInstrucciones = new JButton("Instrucciones");
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaInstrucciones v= new VentanaInstrucciones(VentanaMenu.this);
				v.setVisible(true);
				VentanaMenu.this.setVisible(false);
			}
		});
		btnInstrucciones.setFont(new Font("Monospaced", Font.PLAIN, 16));
		btnInstrucciones.setBounds(89, 170, 227, 29);
		panel_Centro.add(btnInstrucciones);
		
		JPanel panelsur = new JPanel();
		panelsur.setBackground(Color.WHITE);
		panelsur.setBounds(26, 249, 397, 29);
		contentPane.add(panelsur);
		panelsur.setLayout(null);
		
		/*
		 * Al cerrar la ventana se guarda el usuario en el archivo properties y se
		 * cierra la conexion con la bd
		 */
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				BD.desconectar();
				Main.guardaProperties(user);

			}

		});
		
		JButton btnNewButton = new JButton("Cerrar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaInicioo a = new VentanaInicioo();
				a.setVisible(true);
				VentanaMenu.this.setVisible(false);
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnNewButton.setBounds(250, 0, 141, 29);
		panelsur.add(btnNewButton);
		
		JButton button = new JButton("?");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaValorCartas a = new VentanaValorCartas(VentanaMenu.this);
				a.setVisible(true);
				VentanaMenu.this.setVisible(false);
				
				
			}
		});
		button.setFont(new Font("Monospaced", Font.PLAIN, 16));
		button.setBounds(6, -1, 86, 29);
		panelsur.add(button);
		
		
		
	}
}
