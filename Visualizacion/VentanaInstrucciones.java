package Visualizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javafx.event.ActionEvent;

public class VentanaInstrucciones extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	
	/**
	 * Create the frame.
	 * @param venatananterior 
	 */
	public VentanaInstrucciones(VentanaMenu venatananterior) {
		setBackground(Color.WHITE);
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);

		textArea = new JTextArea();
		textArea.setEditable(false);
		SacarInstrucciones();
		textArea.setOpaque(true);
		
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(null);
		scrollPane.setBounds(18, 0, 404, 198);
		panelCentro.add(scrollPane);
		scrollPane.setOpaque(true);

		
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.WHITE);
		contentPane.add(panelNorte,BorderLayout.NORTH);
		panelNorte.setLayout(new BorderLayout(0, 0));
		panelNorte.setOpaque(true);
		
		JLabel lblNewLabel = new JLabel("INSTRUCCIONES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 21));
		panelNorte.add(lblNewLabel);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.WHITE);
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setOpaque(true);
		
		JButton btnVolver = new JButton("Volver");
		
		
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnVolver.setFont(new Font("Monospaced", Font.PLAIN, 16));
		panelSur.add(btnVolver);
		
	
		
		
		
		
		
	}
	
private void SacarInstrucciones() {
		
		try {
			BufferedReader leer= new BufferedReader(new FileReader("Instrucciones.txt"));
			String linea=leer.readLine();
			while(linea!=null) {
			textArea.append(linea+"\n");
			linea=leer.readLine();
			}
			
			leer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}}
