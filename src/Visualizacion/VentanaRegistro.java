package Visualizacion;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Datos.Usuario;
import Ficheros.GestionFicheros;

//import aplicacionusuario.datos.BD;
//import aplicacionusuario.datos.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;


import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */

	public VentanaRegistro(VentanaInicioo ventanaanterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 524, 303);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 25));
		setContentPane(contentPane);
		

		JPanel panel_Mid = new JPanel();
		panel_Mid.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_Mid, BorderLayout.CENTER);
		panel_Mid.setLayout(new MigLayout("", "[125px][344px][100px]", "[30px][30px][30px][23px]"));

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_Mid.add(lblUsuario, "cell 0 0,grow");

		textField = new JTextField();
		panel_Mid.add(textField, "cell 1 0,grow");
		textField.setColumns(10);

		JLabel lblContraseña = new JLabel("Contrase\u00F1a");
		lblContraseña.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Mid.add(lblContraseña, "cell 0 1,alignx right,growy");

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_Mid.add(passwordField, "cell 1 1,growx,aligny center");

		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblIniciarSesion = new JLabel("INICIAR SESION");
		lblIniciarSesion.setFont(new Font("Monospaced", Font.PLAIN, 29));
		panel.add(lblIniciarSesion);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new MigLayout("", "[180px][63px][95px][150]", "[23px]"));

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(6, 50, 113));
		btnVolver.setForeground(Color.BLACK);
		panel_1.add(btnVolver, "cell 1 0,alignx left,aligny top");
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro.this.setVisible(false);
				ventanaanterior.setVisible(true);
			}
		});

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBackground(new Color(6, 50, 113));
		btnIniciarSesion.setForeground(Color.BLACK);
		panel_1.add(btnIniciarSesion, "cell 2 0,alignx left,aligny top");
		btnIniciarSesion.addActionListener(new ActionListener() {

			/*
			 * Boton iniciar sesion Comprueba en la base de datos si existe el usuario, si
			 * existe llama a la ventana principal sino mensaje de error
			 * 
			 */
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String usuario = textField.getText();
				String contraseña = String.valueOf(passwordField.getPassword());
				Usuario user = new Usuario(usuario, contraseña, 0);
				int resul = VentanaInicioo.bd.existeUsuario(user);
				
				if(resul==2){
					JOptionPane.showMessageDialog(null, "BIENVENIDO","Acceso autorizado",JOptionPane.INFORMATION_MESSAGE);
					VentanaMenu a = new VentanaMenu(user);
					a.setVisible(true);
					VentanaRegistro.this.setVisible(false);
					
				}
				else if(resul==1)
					JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA","Acceso no autorizado",JOptionPane.ERROR_MESSAGE);
				else{
					int resp = JOptionPane.showConfirmDialog(null, "¿Quieres registrarte?","USUARIO NO REGISTRADO",JOptionPane.ERROR_MESSAGE);
					if(resp == 0){
						
						VentanaCrearUsuario vr = new VentanaCrearUsuario(ventanaanterior);
						vr.setVisible(true);
					}
				}
				
			}
		});
				
				
				
				
				
	
		


}}

	
