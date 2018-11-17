package Visualizacion;


import org.junit.jupiter.api.Test;



import Datos.Usuario;
import junit.framework.TestCase;

class VentanaRegistroTest extends TestCase{

	public void setUp() throws Exception {
		/*Como vamos a testear una clase que sÛlo tiene mÈtodos static,
		 * no hace falta inicializar nada*/
	}


	@Test
	void consultarExisteUsuario()   {
		
		
		
		
		String nombre1="adrian";
		String contraseña1="adrian";
		String nombre2="junit";
		String contraseña2 ="test";
		String nombre3="victor";
		String contraseña3="martin";
		
		
		
		
		Usuario user1= new Usuario(nombre1,contraseña1,0);
		Usuario user2= new Usuario(nombre2,contraseña2,0);
		Usuario user3= new Usuario(nombre3,contraseña3,0);
		
		
		
		assertTrue("Usuario esta en la BD", BD.BD.existeUsuario(user1)==2);
		assertTrue("Usuario esta en la BD", BD.BD.existeUsuario(user2)==2);
		assertTrue("Usuario no esta en la BD", BD.BD.existeUsuario(user3)==0);
		
	}
	
	
	
void consultarContraseñaIncorrecta()   {
		
		
		
		
		String nombre1="adrian";
		String contraseña1="contra";   //contraseña correcta adrian
		String nombre2="junit";
		String contraseña2 ="junit";	 //contraseña correcta junit
		String nombre3="aner";
		String contraseña3="lekue";	 //contraseña correcta aner
		
		
		
		
		Usuario user1= new Usuario(nombre1,contraseña1,0);
		Usuario user2= new Usuario(nombre2,contraseña2,0);
		Usuario user3= new Usuario(nombre3,contraseña3,0);
		
		
		
		assertTrue("Contraseña Incorrecta", BD.BD.existeUsuario(user1)==1);
		assertTrue("Contraseña Incorrecta", BD.BD.existeUsuario(user2)==1);
		assertTrue("Contraseña Incorrecta", BD.BD.existeUsuario(user3)==1);
		
	}
	
	void consultarValorCarta()  {
		
		String ruta1="cartas/J pic.JPG"; 	// Carta J cuyo valor es 10
		String ruta2="cartas/A dia.JPG";	//Carta AS cuyo valor es 1
		String ruta3 ="cartas/7 dia.JPG";	// Carta 7 cuyo valor es 7
		
		assertTrue("Contraseña Incorrecta", BD.BD.obtenerValorCarta(ruta1)==10);
		assertTrue("Contraseña Incorrecta", BD.BD.obtenerValorCarta(ruta2)==1);
		assertTrue("Contraseña Incorrecta", BD.BD.obtenerValorCarta(ruta3)==7);
	}
	
}
