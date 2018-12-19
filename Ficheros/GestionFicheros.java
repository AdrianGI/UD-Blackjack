package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import Datos.Usuario;

public class GestionFicheros {


public static void Ingresar( String nomfich, String nombre,String numCuenta,float dinero) {
	
	try {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date(System.currentTimeMillis()));
		int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = gc.get(GregorianCalendar.MONTH);
		int anio = gc.get(gc.YEAR);
		int horas=gc.get(GregorianCalendar.HOUR_OF_DAY);
		int minutos=gc.get(GregorianCalendar.MINUTE);
		int segundos=gc.get(GregorianCalendar.SECOND
				);
	PrintWriter pw = null;
	File f = new File(nomfich+".txt");
	if(!f.exists())
		pw = new PrintWriter(f);
	else
		pw = new PrintWriter(new FileWriter(f,true));
	pw.println(dia+"/"+mes+"/"+anio+"     "+ horas+":"+ minutos+":"+segundos );
	pw.println(nombre+ " ha ingresado "+ dinero+"€ al numero de cuenta "+ numCuenta ); 
	pw.close();
	

	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	}




	
	
public static void Retirar( String nomfich, String nombre,String numCuenta,float dinero) {
	
	try {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date(System.currentTimeMillis()));
		int dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
		int mes = gc.get(GregorianCalendar.MONTH);
		int anio = gc.get(gc.YEAR);
		
		int horas=gc.get(GregorianCalendar.HOUR_OF_DAY);
		int minutos=gc.get(GregorianCalendar.MINUTE);
		int segundos=gc.get(GregorianCalendar.SECOND
				);
	PrintWriter pw = null;
	File f = new File(nomfich+".txt");
	if(!f.exists())
		pw = new PrintWriter(f);
	else
		pw = new PrintWriter(new FileWriter(f,true));
	pw.println(dia+"/"+mes+"/"+anio+"     "+ horas+":"+ minutos+":"+segundos );
	pw.println(nombre+ " ha retirado "+ dinero+"€ al numero de cuenta "+ numCuenta ); 
	pw.flush();
	pw.close();
	

	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	
	}

		
	
	

	/*Cuando no se van a crear objetos de una clase, todos sus m�todos tienen que ser
	 * public y static*/
	/**
	 * M�todo que buscar en el fichero de registro los datos del usuario que recibe por par�metro
	 * 
	 * @param nom: Nombre del usuario a buscar en el ficheros de registro
	 * @param con: Contrase�a del usuario a buscar
	 * @return : 0 - Si no existe el nombre
	 * 			 1 - Si el nombre es correcto pero la contrase�a no
	 * 			 2 - Si el nombre y la contrase�a son correctos
	 */



/*	public static int existeUsuario(Usuario u){
		int resul = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Registro.txt"));
			String linea = br.readLine(); // linea = nom con
			while(linea!=null && resul==0){
				int pos = linea.indexOf(" ");
				if(pos!=-1){
					String n = linea.substring(0, pos);
					String c = linea.substring(pos+1);
					if(n.equals(u.getNombre())){
						resul=1;
						if(c.equals(u.getContraseña())){
							resul=2;
						}
					}else{
						linea = br.readLine();
					}
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			resul = 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resul;
	}
	
	public static boolean registrarUsuario(Usuario u){
		boolean registrado = false;
		try {
			int resul = existeUsuario(u);
			if(resul==0){
				PrintWriter pw = null;
				File f = new File("Registro.txt");
				if(!f.exists())
					pw = new PrintWriter(f);
				else
					pw = new PrintWriter(new FileWriter(f,true));
				pw.println(u.getNombre()+" "+u.getContraseña()+ " "+ u.getDinero());
				pw.flush();
				pw.close();
				registrado = true;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return registrado;
	}
}
	*/
	
}
	
	
	