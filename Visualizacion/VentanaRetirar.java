package Visualizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.BD;
import Datos.Usuario;
import Ficheros.GestionFicheros;

public class VentanaRetirar extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnum;
	private JTextField textFielddin;
	float daingresar;
	String numCuenta;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaRetirar(VentanaMenu ventanaanterior,Usuario user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(15, 15, 420, 248);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce la Cantidad:");
		lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 118, 263, 16);
		panel.add(lblNewLabel);
		
		JLabel lblIntroduceTuNumero = new JLabel("Introduce tu Numero de Cuenta:");
		lblIntroduceTuNumero.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblIntroduceTuNumero.setBounds(80, 31, 263, 16);
		panel.add(lblIntroduceTuNumero);
		
		textFieldnum = new JTextField();
		textFieldnum.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		textFieldnum.setBounds(80, 59, 233, 26);
		panel.add(textFieldnum);
		textFieldnum.setColumns(10);
		
		textFielddin = new JTextField();
		textFielddin.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		textFielddin.setBounds(90, 147, 230, 26);
		panel.add(textFielddin);
		textFielddin.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaanterior.setVisible(true);
				VentanaRetirar.this.setVisible(false);
			}
		});
		btnVolver.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnVolver.setBounds(238, 213, 117, 29);
		panel.add(btnVolver);
		
		JButton btnIngresar = new JButton("Retirar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int cant = Integer.parseInt(textFielddin.getText());
				if(!textFieldnum.getText().isEmpty()&& textFieldnum.getText().length()==18 && textFieldnum.getText().startsWith("ES")&& cant<=user.getDinero()&& cant<=500 ) {
					
					boolean error = false;
					
					try {
						cant = Integer.parseInt(textFielddin.getText());
					}catch(NumberFormatException e1){
						error = true;
					}
					if(error) {
						JOptionPane.showMessageDialog(null, "El valor insertado no es correcto", "ERROR EN EL FORMATO", JOptionPane.ERROR_MESSAGE);
					}else {
					
				
				BD.retirararsaldo(user.getNombre(), Float.parseFloat(textFielddin.getText())); 
				VentanaRetirar.this.setVisible(false);
				ventanaanterior.setVisible(false);
				VentanaMenu v = new VentanaMenu(user);
				v.setVisible(true);
				
				GestionFicheros.Retirar(user.getNombre(),user.getNombre(), textFieldnum.getText(), Float.parseFloat(textFielddin.getText()));
				}
				
			}else {
				
				JOptionPane.showMessageDialog(null,"DATOS NO VALIDOS" , "Acceso no autorizado", JOptionPane.ERROR_MESSAGE);
				
				
			}}});
		btnIngresar.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnIngresar.setBounds(80, 213, 117, 29);
		panel.add(btnIngresar);
		
		JPanel panel_norte = new JPanel();
		panel_norte.setBounds(5, 5, 440, 10);
		contentPane.add(panel_norte);
		
		JPanel panel_sur = new JPanel();
		panel_sur.setBounds(5, 263, 440, 10);
		contentPane.add(panel_sur);
		
		JPanel panel_oeste = new JPanel();
		panel_oeste.setBounds(5, 15, 10, 248);
		contentPane.add(panel_oeste);
		
		JPanel panel_este = new JPanel();
		panel_este.setBounds(435, 15, 10, 248);
		contentPane.add(panel_este);
	}
}
