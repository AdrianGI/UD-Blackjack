package Visualizacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import Datos.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaValorCartas extends JFrame {



	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private DefaultTableModel dtm;
	private JTable tabla, tabla2;
	private JButton btnVolver;
	
	/**
	 * Launch the application.
	 */
	

	
	private class MiRender extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
				boolean hasFocus, int row, int col){
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
			
			this.setBackground(Color.LIGHT_GRAY);
			this.setEnabled(true);
			this.setFont(new Font(Font.SERIF, Font.BOLD, 12));
			
			
			if(col==0){
				this.setEnabled(false);
			}
			if(col==1){
				this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
			}
			if(isSelected){
				this.setBackground(Color.BLUE);
				
				}
			
			return this;
			
			}
	}
	
	/**
	 * Create the frame.
	 */
	public VentanaValorCartas(VentanaMenu ventanaanterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new PanelFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new PanelFondo();
		panel.setBounds(53, 6, 340, 234);
		contentPane.add(panel);
		Object [] columnNames = {"CARTA","VALOR"};
		Object [][] data = {{"AS","1/11"},{"DOS","2"},{"TRES","3"},{"CUATRO","4"},{"CINCO","5"},{"SEIS","6"},{"SIETE","7"},{"OCHO","8"},{"NUEVE","9"},
				{"DIEZ","10"},{"J","10"},{"Q","10"},{"K","10"},{"K","10"}};
		
		dtm = new DefaultTableModel(data, columnNames){
			public boolean isCellEditable(int row, int col){
				if(col == 0)
					return false;
				return super.isCellEditable(row, col);
			}
			
		};
		tabla =  new JTable(dtm);
		tabla.setBackground(new Color(255, 255, 255));
		tabla.setBorder(new LineBorder(new Color(0, 0, 0)));
		TableColumn tc = tabla.getColumn("CARTA");
		tc.setPreferredWidth(100);
		tc = tabla.getColumn("VALOR");
		tc.setPreferredWidth(100);
		tc.setMinWidth(100);
		tc.setMaxWidth(100);		
		tabla.setDefaultRenderer(Object.class, new MiRender());
		JTableHeader th = tabla.getTableHeader();
		panel.add(th);
		panel.add(tabla);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(358, 243, 86, 29);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ventanaanterior.setVisible(true);
				VentanaValorCartas.this.setVisible(false);
				
			}
		});
		btnVolver.setFont(new Font("Monospaced", Font.PLAIN, 12));
		contentPane.add(btnVolver);
		
		
		
		
		
	}

}

