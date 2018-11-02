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

import BD.BD;
import Datos.Usuario;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaJuego extends JFrame {

	private JPanel contentPane;
	private JTextField Cantidad;

	
	public VentanaJuego(VentanaMenu ventanaanterior,Usuario user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 700);
		
		contentPane = new PanelFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelS = new JPanel();
		contentPane.add(panelS, BorderLayout.SOUTH);
		panelS.setOpaque(false);
		panelS.setLayout(new MigLayout("", "[84px][130px][][164px][][][][]", "[29px]"));
		
		JLabel lblNewLabel = new JLabel("Introduce la Cantidad de tu Apuesta:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelS.add(lblNewLabel, "cell 0 0,alignx center,aligny center");
		
		Cantidad = new JTextField();
		panelS.add(Cantidad, "cell 1 0 2 1,alignx left,aligny center");
		Cantidad.setColumns(10);
		
				JPanel panelN = new JPanel();
		contentPane.add(panelN, BorderLayout.NORTH);
		panelN.setOpaque(false);
		panelN.setLayout(new MigLayout("", "[90px][130px][][90px][130px][][][170px]", "[50px]"));
		
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setForeground(Color.WHITE);
		lblJugador.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelN.add(lblJugador, "cell 0 0");
		
		JLabel labelJug = new JLabel(user.getNombre());
		labelJug.setForeground(Color.WHITE);
		labelJug.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelN.add(labelJug, "cell 1 0");
		
		JLabel lblDinero = new JLabel("Dinero:");
		lblDinero.setForeground(Color.WHITE);
		lblDinero.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelN.add(lblDinero, "cell 3 0");
		
		float saldo = BD.obtenerSaldo(user.getNombre());
		user.setDinero(saldo);
		JLabel labelDin = new JLabel(user.getDinero()+"€");
		labelDin.setForeground(Color.WHITE);
		labelDin.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelN.add(labelDin, "cell 4 0");
		
		JButton btnTerminarPartida = new JButton("Terminar Partida");
		btnTerminarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaJuego.this.setVisible(false);
				VentanaMenu a = new VentanaMenu(user);
				a.setVisible(true);
			
				
			}
		});
		btnTerminarPartida.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelN.add(btnTerminarPartida, "cell 7 0");
		
		JPanel panelO = new JPanel();
		contentPane.add(panelO, BorderLayout.WEST);
		panelO.setLayout(new MigLayout("", "[50px][30px]", "[50px][][][][][][][][][][][][][][][][][][][][][][][]"));
		panelO.setOpaque(false);
		
		JLabel lblDealer = new JLabel("Dealer");
		lblDealer.setForeground(Color.WHITE);
		lblDealer.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(lblDealer, "cell 0 1");
		
		JLabel lblSuma = new JLabel("Suma:");
		lblSuma.setForeground(Color.WHITE);
		lblSuma.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(lblSuma, "flowx,cell 0 3");
		
		
		
		JLabel lblJugador_1 = new JLabel("Jugador");
		lblJugador_1.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblJugador_1.setForeground(Color.WHITE);
		panelO.add(lblJugador_1, "cell 0 16");
		
		JLabel label_sumj = new JLabel("Suma:");
		label_sumj.setForeground(Color.WHITE);
		label_sumj.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(label_sumj, "flowx,cell 0 18");
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(label_2, "cell 0 18");
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(label, "cell 0 3");
		
		JPanel panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.EAST);
		panelE.setLayout(new MigLayout("", "[40px]", "[50px][][][][][][][][][][][][]"));
		panelE.setOpaque(false);
		
		JButton btnPedirCarta = new JButton("Pedir Carta");
		
		btnPedirCarta.setFont(new Font("Monospaced", Font.PLAIN, 15));
		panelE.add(btnPedirCarta, "cell 0 5,alignx center");
		
		JButton btnPlantarse = new JButton("Plantarse");
		btnPlantarse.setFont(new Font("Monospaced", Font.PLAIN, 15));
		panelE.add(btnPlantarse, "cell 0 7,alignx center");
		
		JLabel lblApuesta = new JLabel("Apuesta:");
		lblApuesta.setForeground(Color.WHITE);
		lblApuesta.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelE.add(lblApuesta, "flowx,cell 0 11");
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelE.add(label_1, "cell 0 11,alignx right");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 70, 70, 90);
		panel.add(panel_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(111, 70, 70, 90);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(193, 70, 70, 90);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(275, 70, 70, 90);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(357, 70, 70, 90);
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(29, 341, 70, 90);
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(111, 341, 70, 90);
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(193, 341, 70, 90);
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(275, 341, 70, 90);
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(357, 341, 70, 90);
		panel.add(panel_10);
		
		
		JButton button = new JButton("Jugar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Cantidad.getText().isEmpty()) {
				label_1.setText(Cantidad.getText()+"€");
				ArrayList<String> aRutas =BD.obtenerRutasDeLaBaseDeDatos();
				//int i= (int)Math.random()*52+1;
				int i = 1;
				
				//Panel_1 DEALER
				String ruta = aRutas.get(i); 
				ImageIcon im = new ImageIcon(ruta);
				im.setDescription(ruta);
				JLabel lblFoto = new JLabel(im);
				panel_1.add(lblFoto);
				System.out.println(ruta);//no sale la foto solo la ruta y preguntar espacios
				//Panel_2
				String ruta2 = aRutas.get(i); 
				ImageIcon im2 = new ImageIcon(ruta2);
				im.setDescription(ruta);
				JLabel lblFoto2 = new JLabel(im2);
				panel_1.add(lblFoto2);
				System.out.println(ruta2);//no sale la foto solo la ruta y preguntar espacios
				
				//JUgador panel_6
				String ruta6 = aRutas.get(i); 
				ImageIcon im6 = new ImageIcon(ruta6);
				im.setDescription(ruta);
				JLabel lblFoto6 = new JLabel(im6);
				panel_1.add(lblFoto6);
				System.out.println(ruta6);//no sale la foto solo la ruta y preguntar espacios
				
				//panel_7
				String ruta7 = aRutas.get(i); 
				ImageIcon im7 = new ImageIcon(ruta7);
				im.setDescription(ruta7);
				JLabel lblFoto7 = new JLabel(im7);
				panel_1.add(lblFoto7);
				System.out.println(ruta7);//no sale la foto solo la ruta y preguntar espacios
				
				label_2.setText(BD.obtenerValorCarta(ruta)+"");
				
			}else {
				JOptionPane.showMessageDialog(null,"DATOS NO VALIDOS" , "Error", JOptionPane.ERROR_MESSAGE);
			}
			}
				
				
			
			
		});
		button.setHorizontalAlignment(SwingConstants.LEADING);
		button.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelS.add(button, "cell 3 0,alignx right");
		


			
		
		
		
		
		
		
		
		
	

	}
	
	
	
}