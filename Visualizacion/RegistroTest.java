package Visualizacion;


import org.junit.jupiter.api.Test;

import BD.BD;
import Datos.Usuario;
import junit.framework.TestCase;

class RegistroTest extends TestCase{
	
	
	public void setUp() throws Exception {
		/*Como vamos a testear una clase que sÛlo tiene mÈtodos static,
		 * no hace falta inicializar nada*/
		
		
	}


	@Test
	void consultarExisteUsuario()   {

		BD.conectar();
		
		
		
		String nombre1="adrian";
		String contrasenya1="adrian";
		String nombre2="junit";
		String contrasenya2 ="test";
		String nombre3="victor";
		String contrasenya3="martin";
		
		
		
		
		Usuario user1= new Usuario(nombre1,contrasenya1,0);
		Usuario user2= new Usuario(nombre2,contrasenya2,0);
		Usuario user3= new Usuario(nombre3,contrasenya3,0);
		
		
		
		assertTrue("Usuario esta en la BD", BD.existeUsuario(user1)==2);
		assertTrue("Usuario esta en la BD", BD.existeUsuario(user2)==2);
		assertTrue("Usuario no esta en la BD", BD.existeUsuario(user3)==0);
		
	}
	
	
	@Test
	void consultarContrasenyaIncorrecta()   {
		
		BD.conectar();
		
		
		String nombre1="adrian";
		String contrasenya1="contra";   //contrasenya correcta adrian
		String nombre2="junit";
		String contrasenya2 ="junit";	 //contrasenya correcta junit
		String nombre3="aner";
		String contrasenya3="lekue";	 //contrasenya correcta aner
		
		
		
		
		Usuario user1= new Usuario(nombre1,contrasenya1,0);
		Usuario user2= new Usuario(nombre2,contrasenya2,0);
		Usuario user3= new Usuario(nombre3,contrasenya3,0);
		
		
		
		assertTrue("Contrasenya Incorrecta", BD.existeUsuario(user1)==1);
		assertTrue("Contrasenya Incorrecta", BD.existeUsuario(user2)==1);
		assertTrue("Contrasenya Incorrecta", BD.existeUsuario(user3)==1);
		
	}
	
	@Test
	void consultarValorCarta()  {
		
		BD.conectar();
		
		String ruta1="cartas/J pic.JPG"; 	// Carta J cuyo valor es 10
		String ruta2="cartas/A dia.JPG";	//Carta AS cuyo valor es 1
		String ruta3 ="cartas/7 dia.JPG";	// Carta 7 cuyo valor es 7
		
		assertTrue("Contrasenya Incorrecta", BD.obtenerValorCarta(ruta1)==10);
		assertTrue("Contrasenya Incorrecta", BD.obtenerValorCarta(ruta2)==1);
		assertTrue("Contrasenya Incorrecta", BD.obtenerValorCarta(ruta3)==7);
	}
	
}
