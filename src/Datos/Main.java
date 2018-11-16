package Datos;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Visualizacion.VentanaInicioo;
import Visualizacion.VentanaMenu;



public class Main {

	static Usuario u;
	//Si existe archivo properties abre directamente la ventana menu, sino abre ventana inicio.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main m = new Main();
		u = new Usuario();
		
		
		try {
			BD.BD.conectar();
			m.cargaProperties();
			VentanaMenu vp = new VentanaMenu(u);
			vp.setVisible(true);
		} catch (IOException e) {
			VentanaInicioo v = new VentanaInicioo();
			v.setVisible(true);

		}
	}
		
		private static Properties properties;

		/**
		 * Carga del fichero properties el usuario y contrasenya que estaban
		 * registrados cuando se cerro la aplicacion por ultima vez
		 * 
		 * @throws IOException
		 * @throws FileNotFoundException
		 * @throws InvalidPropertiesFormatException
		 * 
		 */
		private void cargaProperties() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
			properties = new Properties();
			String usuario = " ";
			String contrasenya = "";
			properties.load(new FileInputStream("usuarios.ini"));
			usuario = properties.getProperty("usuario");
			contrasenya = properties.getProperty("contraseña");
			 u = new Usuario(usuario,contrasenya,0);
			int a = BD.BD.existeUsuario(u);
			if (a!=0 && a!=1 && a!=2) {
				throw new IOException();
			}
		}

		/**
		 * Guarda en fichero el usuario y la contrasenya
		 */

		public static void guardaProperties(Usuario u) {
			
			
			properties = new Properties();
			
			String usuario = u.getNombre();
			String contrasenya = u.getContraseña();

			properties.setProperty("usuario", usuario);
			properties.setProperty("contraseña", contrasenya);

			try {
				
				properties.store(new FileOutputStream("usuarios.ini"), "");

			} catch (Exception e) {

			}
		
	
	}

}
