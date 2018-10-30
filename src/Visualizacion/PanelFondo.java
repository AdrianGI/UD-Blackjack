package Visualizacion;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

	public PanelFondo(){
		this.setSize(450, 300);
		
	}
	
	public void paintComponent(Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon("fondo.jpg");
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, this);
		setOpaque(false);
		super.paintComponent(g);
	}
}
