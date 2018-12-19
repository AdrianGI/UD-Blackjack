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
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class VentanaJuego extends JFrame {

 
	private JTextField Cantidad;
	private int jugador,dealer,numCartasJugadas,conteoJugador,ConteoDealer,numCartasDealer;
	private ArrayList<String> aRutas =BD.obtenerRutasDeLaBaseDeDatos();
	private int cant;
	JLabel reloj = new JLabel("");
	JLabel label = new JLabel("");
	JPanel panel = new JPanel();
	JLabel label_2 = new JLabel("");
	JLabel label_1 = new JLabel("");
	JButton btnTerminarPartida = new JButton("Terminar Partida");
	
	JPanel contentPane, cartasJugador[] = new JPanel[5],cartasDealer[]= new JPanel[5];
	JPanel carta1J = new JPanel();
	JPanel Carta2J = new JPanel();
	JPanel Carta3J = new JPanel();
	JPanel Carta4J = new JPanel();
	JPanel Carta5J = new JPanel();
	
	JPanel carta1D = new JPanel();
	JPanel carta2D = new JPanel();
	JPanel carta4D = new JPanel();
	JPanel carta3D = new JPanel();
	JPanel carta5D = new JPanel();
	private int hora,minuto,segundos,dact,din;
	private JButton btnPedirCarta, btnPlantarse;
	
	public VentanaJuego(VentanaMenu ventanaanterior,Usuario user) {
		
		din=(int) (user.getDinero());
		setResizable(false);
		numCartasJugadas = 2;
		conteoJugador = 0;
		ConteoDealer=0;
		numCartasDealer=1;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		
		 btnTerminarPartida = new JButton("Terminar Partida");
		btnTerminarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BD.actualizarsaldo(user.getNombre(), din);
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
		
		JLabel lblDealer = new JLabel("Crupier");
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
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(label_2, "cell 0 18");
		
		 label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Monospaced", Font.PLAIN, 20));
		panelO.add(label, "cell 0 3");
		
		JPanel panelE = new JPanel();
		contentPane.add(panelE, BorderLayout.EAST);
		panelE.setLayout(new MigLayout("", "[40px]", "[50px][][][][][][][][][][][][]"));
		panelE.setOpaque(false);
		
		btnPedirCarta = new JButton("Pedir Carta");
		
		
		btnPedirCarta.setEnabled(false);
		
		btnPedirCarta.setFont(new Font("Monospaced", Font.PLAIN, 15));
		panelE.add(btnPedirCarta, "cell 0 5,alignx center");
		
		
		reloj.setFont(new Font("Monospaced", Font.PLAIN, 18));
		reloj.setForeground(Color.WHITE);
		panelE.add(reloj, "cell 0 1");
		
		btnPlantarse = new JButton("Plantarse");
		
		btnPlantarse.setEnabled(false);
		btnPlantarse.setFont(new Font("Monospaced", Font.PLAIN, 15));
		panelE.add(btnPlantarse, "cell 0 10,alignx center");
		
		JLabel lblApuesta = new JLabel("Apuesta:");
		lblApuesta.setForeground(Color.WHITE);
		lblApuesta.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelE.add(lblApuesta, "flowx,cell 0 11");
		
		 label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelE.add(label_1, "cell 0 11,alignx right");
		
		 panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		
		 carta2D = new JPanel();
		carta2D.setBorder(null);
		carta2D.setBounds(111, 70, 70, 90);
		panel.add(carta2D);
		carta2D.setOpaque(false);
		
		 carta3D = new JPanel();
		carta3D.setBorder(null);
		carta3D.setBounds(193, 70, 70, 90);
		panel.add(carta3D);
		carta3D.setOpaque(false);
		
		 carta4D = new JPanel();
		carta4D.setBorder(null);
		carta4D.setBounds(275, 70, 70, 90);
		panel.add(carta4D);
		carta4D.setOpaque(false);
		
		 carta5D = new JPanel();
		carta5D.setBorder(null);
		carta5D.setBounds(357, 70, 70, 90);
		panel.add(carta5D);
		carta5D.setOpaque(false);
		
		 carta1J = new JPanel();
		carta1J.setBorder(null);
		carta1J.setBounds(29, 341, 70, 90);
		panel.add(carta1J);
		carta1J.setOpaque(false);
		
		Carta2J = new JPanel();
		Carta2J.setBounds(111, 341, 70, 90);
		panel.add(Carta2J);
		Carta2J.setOpaque(false);
		
		 Carta3J = new JPanel();
		Carta3J.setBounds(193, 341, 70, 90);
		panel.add(Carta3J);
		Carta3J.setOpaque(false);
		
		 Carta4J = new JPanel();
		Carta4J.setBounds(275, 341, 70, 90);
		panel.add(Carta4J);
		Carta4J.setOpaque(false);
		
		 Carta5J = new JPanel();
		Carta5J.setBounds(357, 341, 70, 90);
		panel.add(Carta5J);
		Carta5J.setOpaque(false);
		
		 carta1D = new JPanel();
		carta1D.setBorder(null);
		carta1D.setBounds(29, 70, 70, 90);
		panel.add(carta1D);
		carta1D.setOpaque(false);
		
		cartasJugador[0] = carta1J;
		cartasJugador[1] = Carta2J;
		cartasJugador[2] = Carta3J;
		cartasJugador[3] = Carta4J;
		cartasJugador[4] = Carta5J;
		
		cartasDealer[0]= carta1D;
		cartasDealer[1]= carta2D;
		cartasDealer[2]= carta3D;
		cartasDealer[3]= carta4D;
		cartasDealer[4]= carta5D;
		
		btnPedirCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				    numCartasJugadas++;
					
					String ruta8= BD.obtenerCartaAleatoria();
					BD.actualizarHasalidoCarta(ruta8);
					
					aRutas.remove(ruta8);
					ImageIcon im8 = new ImageIcon(ruta8);
					im8.setDescription(ruta8);
					JLabel lblFoto8 = new JLabel(im8);
					cartasJugador[numCartasJugadas-1].add(lblFoto8);
					System.out.println(ruta8);
					conteoJugador = SumarCartas(conteoJugador, BD.obtenerValorCarta(ruta8));
					label_2.setText(conteoJugador+"");
					if(numCartasJugadas == 5)
						btnPedirCarta.setEnabled(false);
				if(conteoJugador>21) {	
				
						JOptionPane.showMessageDialog(null, "Te has Pasado:", "Ganador: Dealer", JOptionPane.INFORMATION_MESSAGE);
						finjuego();
						
				}
					
				
				
				}});
		
		
		
		btnPlantarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				JLabel lblFoto2 = new JLabel();
				btnPedirCarta.setEnabled(false);
				System.out.println("HAS DECICIDO PLANTARTE A LAS"+ System.currentTimeMillis());
				
				while(ConteoDealer<17) {
					System.out.println("ENTRA AL WHILE");
				
					String ruta2= BD.obtenerCartaAleatoria();
					BD.actualizarHasalidoCarta(ruta2);
					aRutas.remove(ruta2);
					ImageIcon im2 = new ImageIcon(ruta2);
					im2.setDescription(ruta2);
					lblFoto2 = new JLabel(im2);
					if(numCartasDealer+i<5) {
						cartasDealer[numCartasDealer+i].add(lblFoto2);
						cartasDealer[numCartasDealer+i].updateUI();
						i++;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					System.out.println(ruta2);
					ConteoDealer=SumarCartas(ConteoDealer,BD.obtenerValorCarta(ruta2));
					
				
				}
				
				if ( ConteoDealer>21) {
					System.out.println("Entra a ConteoDealer>21");
					btnPlantarse.setEnabled(false);
					label.setText(ConteoDealer+"");
					//cartasDealer[numCartasDealer+i].add(lblFoto2);
					JOptionPane.showMessageDialog(null,"Ganador: Jugador", "El Crupier se  ha pasado", JOptionPane.INFORMATION_MESSAGE);
					finjuego();
					din=din+(2*cant);
					 labelDin.setText(din+"€");
					System.out.println("Esta en el if del conteo dealer");
					
				}else {
				
				
					btnPlantarse.setEnabled(false);
					label.setText(ConteoDealer+"");
					
					if(determinarGanador(conteoJugador,ConteoDealer)==3) {
						din=din+(2*cant);
						 labelDin.setText(din +"€");
						 JOptionPane.showMessageDialog(null, "JUGADOR", "GANADOR", JOptionPane.INFORMATION_MESSAGE);
						 
					}else if(determinarGanador(conteoJugador,ConteoDealer)==1){
						JOptionPane.showMessageDialog(null, "EMPATE", "EMPATE", JOptionPane.INFORMATION_MESSAGE);
						din=din+cant;
						 labelDin.setText(din +"€");
						
					}else if(determinarGanador(conteoJugador,ConteoDealer)==2) {
						JOptionPane.showMessageDialog(null, "CRUPIER", "GANADOR", JOptionPane.INFORMATION_MESSAGE);
						
					}
					}
					finjuego();
					
				 }});
		

		
		
		JButton button = new JButton("Jugar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//finjuego();
				cartasJugador[0] = carta1J;
				cartasJugador[1] = Carta2J;
				cartasJugador[2] = Carta3J;
				cartasJugador[3] = Carta4J;
				cartasJugador[4] = Carta5J;
				
				cartasDealer[0]= carta1D;
				cartasDealer[1]= carta2D;
				cartasDealer[2]= carta3D;
				cartasDealer[3]= carta4D;
				cartasDealer[4]= carta5D;
				boolean error = false;
				btnTerminarPartida.setEnabled(false);
				cant = Integer.parseInt(Cantidad.getText());
				
				// Comprueba que no este vacio y haya int 
				if(!Cantidad.getText().isEmpty() && cant<=user.getDinero()&& cant!=0) {
					
					try {
						 cant = Integer.parseInt(Cantidad.getText());
					}catch(NumberFormatException e1){
						error = true;
					}
					if(error) {
						JOptionPane.showMessageDialog(null, "El valor insertado no es correcto", "ERROR EN EL FORMATO", JOptionPane.ERROR_MESSAGE);
					}else {
						
						
						label_1.setText(Cantidad.getText()+"€");
						Cantidad.setText("");
						 aRutas =BD.obtenerRutasDeLaBaseDeDatos();
						 
						  din=din-cant;
						 labelDin.setText(din+"€");
						
						//Panel_1 DEALER
						String ruta1 = BD.obtenerCartaAleatoria();
						BD.actualizarHasalidoCarta(ruta1);
						
						ImageIcon im = new ImageIcon(ruta1);
						aRutas.remove(ruta1);
						im.setDescription(ruta1);
						JLabel lblFoto = new JLabel(im);
						carta1D.add(lblFoto);
						carta1D.setOpaque(false);
						System.out.println(ruta1);
						ConteoDealer=BD.obtenerValorCarta(ruta1);
						
						
						
						
						
						//JUgador panel_6
						
						String ruta6= BD.obtenerCartaAleatoria();
						BD.actualizarHasalidoCarta(ruta6);
						
						
						aRutas.remove(ruta6);
						ImageIcon im6 = new ImageIcon(ruta6);
						im.setDescription(ruta6);
						JLabel lblFoto6 = new JLabel(im6);
						carta1J.add(lblFoto6);
						System.out.println(ruta6);
						conteoJugador += BD.obtenerValorCarta(ruta6);
						
						//panel_7
						
						String ruta7= BD.obtenerCartaAleatoria();
						BD.actualizarHasalidoCarta(ruta7);
						
						aRutas.remove(ruta7);
						ImageIcon im7 = new ImageIcon(ruta7);
						im7.setDescription(ruta7);
						JLabel lblFoto7 = new JLabel(im7);
						Carta2J.add(lblFoto7);
						conteoJugador += BD.obtenerValorCarta(ruta7);
						System.out.println(ruta7);
						
						label.setText(BD.obtenerValorCarta(ruta1)+"");
						label_2.setText(SumarCartas(BD.obtenerValorCarta(ruta6),BD.obtenerValorCarta(ruta7) )+"");
						System.out.println("Entra a las 2 primeras cartas");
						
						if(SumarCartas(BD.obtenerValorCarta(ruta6),BD.obtenerValorCarta(ruta7))==21) {
							
							JOptionPane.showMessageDialog(null, "JUGADOR", "BLACKJACK GANADOR", JOptionPane.INFORMATION_MESSAGE);
							din=din+cant+(2/3*cant);
							 labelDin.setText(din +"€");
							finjuego();
							
						}
						
					}
					
					
					
						
					
						
						
						
						btnPlantarse.setEnabled(true);
						btnPedirCarta.setEnabled(true);
						
						
				
				}else {
						JOptionPane.showMessageDialog(null,"DATOS NO VALIDOS" , "Error", JOptionPane.ERROR_MESSAGE);
				}
					
			panel.updateUI();
			}

			
				
			
			
			
		});
		
		button.setHorizontalAlignment(SwingConstants.LEADING);
		button.setFont(new Font("Monospaced", Font.PLAIN, 18));
		panelS.add(button, "cell 3 0,alignx right");
		Thread t =  new Thread(r);
		t.start();

		
	}
	
	Runnable r =  new Runnable() {
		

		@Override
		public void run() {
			boolean condicion=true;
			while(condicion) {
				reloj.setText(calcula());	
	
			
			}
			
			
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			

				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}

		private String calcula() {
			// TODO Auto-generated method stub
			Calendar calendario= new GregorianCalendar();
			Date fechaactual= new Date();
			calendario.setTime(fechaactual);
			String ampm = calendario.get(Calendar.AM_PM)==	Calendar.AM?"AM":"PM";
			String hora="";
			String f;
			
			
			if(ampm.equals("PM")){
				
				int h = calendario.get((Calendar.HOUR_OF_DAY))-12;
				 hora= h>9? ""+ h:"0"+h;
				
			}else {
					
					 hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+ calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);
					
			}
				String minutos= calendario.get(Calendar.MINUTE)>9?""+ calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
				String segundos= calendario.get(Calendar.SECOND)>9?""+ calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
				f= hora+":"+minutos+":"+segundos+" "+ ampm;
				return f;
				
				
			}
			
		
		
		
	};
	
	private int  determinarGanador(int jugador, int dealer) {
		
		int resultado=0;
		
		if ( dealer<=21  && jugador<=21 && dealer==jugador) {
			
			
			resultado=1;
			
		}else if( dealer==21 && dealer>jugador ||  dealer<21 && dealer>jugador) {
			
			resultado=2;
			
		}else if (jugador<=21 && jugador>dealer) {
				
				resultado=3;
				
			}
		return resultado;
		
		
	}
	
	
			private void finjuego() {
				
				System.out.println("SE HA LLAMADO AL FIN DEL JUEGO");
				
				for(int i=0;i<cartasJugador.length;i++)
					cartasJugador[i]=null;
				for(int i=0;i<cartasDealer.length;i++)
					cartasDealer[i]=null;
		
				
				numCartasJugadas = 2;
				conteoJugador = 0;
				ConteoDealer=0;
				numCartasDealer=1;
				carta1J.removeAll();
				Carta2J.removeAll();
				Carta3J.removeAll();
				Carta4J.removeAll();
				Carta5J.removeAll();
			
				carta1D.removeAll();
				carta2D.removeAll();
				carta3D.removeAll();
				carta4D.removeAll();
				carta5D.removeAll();
			
				label.setText("");
				label_2.setText("");
				label_1.setText("");
				btnTerminarPartida.setEnabled(true);
				btnPedirCarta.setEnabled(false);
				btnPlantarse.setEnabled(false);
				BD.resetearHasalido();
				panel.updateUI();
			}
			
			private int SumarCartas(int a, int b) {
				
				int suma;
				if (a==1 || b==1) {
					if(a+b+10<=21) {
						
						suma=a+b+10;
						
					}else{
						
						 suma =a+b;
					}
					
					
				}else{
					
					 suma =a+b;
				}
				
				return suma;
			
				
			}
			
		}	
