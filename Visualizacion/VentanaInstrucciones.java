package Visualizacion;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.awt.Color;

public class VentanaInstrucciones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	/**
	 * Create the frame.
	 */
	public VentanaInstrucciones( VentanaMenu vm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblComoFunciona = new JLabel("COMO FUNCIONA");
		lblComoFunciona.setFont(new Font("Franklin Gothic Medium", Font.BOLD | Font.ITALIC, 17));
		panel.add(lblComoFunciona);
		
		JButton btnVolverAyuda = new JButton("Volver");
		btnVolverAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vm.setVisible(true);
				VentanaInstrucciones.this.setVisible(false);
			}
		});
		contentPane.add(btnVolverAyuda, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.EAST);
		
		JTextPane txtpnAlInicioDe = new JTextPane();
		txtpnAlInicioDe.setBackground(Color.WHITE);
		txtpnAlInicioDe.setFont(new Font("Sitka Display", Font.PLAIN, 11));
		txtpnAlInicioDe.setToolTipText("");
		txtpnAlInicioDe.setText("Al inicio de la partida deberas realizar tu apuesta, para cuando la apuesta est\u00E9 hecha el crupier te repartir\u00E1 dos cartas descubiertas y una a s\u00ED mismo, tambi\u00E9n descubierta. Seguidamente el crupier te dar\u00E1 paso a que juegues tu mano. Despu\u00E9s de que jueges tu mano, finalmente el crupier jugar\u00E1 su mano dando a descubrir quien es el ganador de la ronda. \r\n\r\nSi te quedas m\u00E1s lejos (entre el crupier y tu) o te has pasado de 21, pierdes tu apuesta. Si se da el caso de que empatas con el crupier no ganas ni pierdes, recuperas tu apuesta. Las apuestas ganadoras con la jugada BlackJack se pagan 3 x 2 (que es lo mismo que decir 1,5 x 1), el resto de apuestas ganadoras,se pagaran 1 x 1.\r\n\r\nSolo dispondr\u00E1s de un turno para jugar tu mano, en el cual decidir\u00E1s si plantarte o pedir carta. Puedes pedir carta siempre que estes por debajo de los 21 puntos.");
		contentPane.add(txtpnAlInicioDe, BorderLayout.CENTER);
	}

}

