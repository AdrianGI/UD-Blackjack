package Visualizacion;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.BD;
import Datos.Usuario;
import Ficheros.GestionFicheros;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;


import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private  static Logger log;
	public static String nomfich;

	/**
	 * Create the frame.
	 */

	public VentanaRegistro(VentanaInicioo ventanaanterior) {
		
		
		log = Logger.getLogger("Log de la ventana principal");
		Handler manejadorArchivo= null;
		try {
			manejadorArchivo = new FileHandler("VentanaPrincipal.log");
			SimpleFormatter simpleFormatter = new SimpleFormatter();

			manejadorArchivo.setFormatter(simpleFormatter);
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.addHandler(manejadorArchivo);
		
		
		
		
		
		
		
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

		JLabel lblContrasenya = new JLabel("Contrase\u00F1a");
		lblContrasenya.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Mid.add(lblContrasenya, "cell 0 1,alignx right,growy");

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

		
		JButton btnHasOlvidadoLa = new JButton("\u00BFHas olviado la contrase\u00F1a?");
		btnHasOlvidadoLa.setBackground(new Color(6, 50, 113));
		btnHasOlvidadoLa.setForeground(Color.BLACK);
		
		btnHasOlvidadoLa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String contra = JOptionPane.showInputDialog("Escribe tu usuario");
				String mail = JOptionPane.showInputDialog("Escribe tu mail");
				
				String pass = BD.olvidarContra(contra);

				
				
				enviarCorreo(pass, mail);
			}
			
			
		});
		panel_Mid.add(btnHasOlvidadoLa, "cell 1 3,alignx center,aligny center");
		
		
		
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
				String contrasenya = String.valueOf(passwordField.getPassword());
				Usuario user = new Usuario(usuario, contrasenya, 0);
				int resul = BD.existeUsuario(user);
				
				if(resul==2){
					if(usuario.equals("adrian")&& contrasenya.equals("adrian")){
						log.info("El administrador ha iniciado sesión");
					}
					log.info(usuario+" ha iniciado sesión");
					JOptionPane.showMessageDialog(null, "BIENVENIDO","Acceso autorizado",JOptionPane.INFORMATION_MESSAGE);
					nomfich=usuario+".txt";
					VentanaMenu a = new VentanaMenu(user);
					a.setVisible(true);
					VentanaRegistro.this.setVisible(false);
					
				}
				else if(resul==1) {
					JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA","Acceso no autorizado",JOptionPane.ERROR_MESSAGE);
				log.severe("La contrase�a insertada por "+usuario+" no ha sido correcta");
			}else{
					int resp = JOptionPane.showConfirmDialog(null, "¿Quieres registrarte?","USUARIO NO REGISTRADO",JOptionPane.ERROR_MESSAGE);
					if(resp == 0){
						log.log(Level.INFO, "Se va a registrar un nuevo usuario");
						
						VentanaCrearUsuario vr = new VentanaCrearUsuario(ventanaanterior);
						vr.setVisible(true);
						VentanaRegistro.this.setVisible(false);
					}
				}
				
			}
		});
		
	}
				
				
				
				
				
	
		
		private void enviarCorreo(String pass, String mail) {

			
			
			// El correo gmail de envÌo
			  String correoEnvia = "udblackjack@gmail.com";
			  String claveCorreo = "deustoblackjack";
			  
			  // La configuraciÛn para enviar correo
			  Properties properties = new Properties();
			 
			  properties.put("mail.smtp.host", "smtp.gmail.com");
			  properties.put("mail.smtp.port", "587");

			  properties.put("mail.smtp.starttls.enable", "true");
			  properties.put("mail.smtp.auth", "true");
			  properties.put("mail.user", correoEnvia);
			  properties.put("mail.password", claveCorreo);
			 
			  // Obtener la sesion
			  Session session = Session.getInstance(properties, null);
			  int aviso = 0;
			  try {
			   // Crear el cuerpo del mensaje
			   MimeMessage mimeMessage = new MimeMessage(session);
			 
			   // Agregar quien envÌa el correo
			   mimeMessage.setFrom(new InternetAddress(correoEnvia, "UD BLACKJACK"));
			    
			   // Los destinatarios
			   InternetAddress[] internetAddresses = {new InternetAddress(mail)};

			 
			   // Agregar los destinatarios al mensaje
			   mimeMessage.setRecipients(Message.RecipientType.TO,
			     internetAddresses);
			 
			   // Agregar el asunto al correo
			   mimeMessage.setSubject("Recuperación de contraseña");
			 
			   // Creo la parte del mensaje
			   MimeBodyPart mimeBodyPart = new MimeBodyPart();
			   mimeBodyPart.setText("Su contraseña es: " + "\n" + "	" + pass + "\n" + "\n" + "\n"
						+ "El Equipo de UD BLACKJACK");
			 
			  
				// Crear el multipart para agregar la parte del mensaje anterior
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(mimeBodyPart);
				//multipart.addBodyPart(mimeBodyPartAdjunto);
			   
			   // Agregar el multipart al cuerpo del mensaje
			   mimeMessage.setContent(multipart);
			 
			   // Enviar el mensaje
			   Transport transport = session.getTransport("smtp");
			   transport.connect(correoEnvia, claveCorreo);
			   transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			   
			   transport.close();
			 
			  } catch (Exception ex) {
			   ex.printStackTrace();
			   JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
			   aviso = 1;
			  }
			  if (aviso==0) {
				  JOptionPane.showMessageDialog(null, "Correo electronico enviado exitosamente");
				  log.log(Level.INFO, "Correo de recuperación de contraseña enviado");
			  }
			 }


			
			
}
	
	
	
	


	
