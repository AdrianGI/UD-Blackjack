package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import Datos.Carta;
import Datos.Usuario;

public class BD {
	
	private static Connection con;
	private static Statement stmt;
	
	/**
	 * Metodo que crea una sentencia para acceder a la base de datos 
	 */
	public static void crearSentencia()
	{
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo que permite conectarse a la base de datos
	 */

	public static  void conectar()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			con= DriverManager.getConnection("jdbc:sqlite:proyecto.db");
			crearSentencia();
		}catch(Exception e)
		{
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que cierra una sentencia 
	 */
	public void cerrarSentencia()
	{
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que permite desconectarse de la base de datos
	 */
	public void desconectar()
	{
		try {
			cerrarSentencia();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BD(){
		conectar();
	}
	
	/*A partir de aqu� hacemos las consultas espec�ficas de cada proyecto*/
	
	/**
	 * 
	 * @param nom: Nombre introducido por el usuario
	 * @param con: Contrase�a introducida por el usuario
	 * @return : 
	 * 			0 - Si no existe el usuario
	 * 			1 - Si s� existe el usuario pero la contrase�a no es correcta
	 * 			2 - Si el nombre de usuario es correcto y la contrase�a tambi�n
	 */
	public static int existeUsuario(Usuario u){
		int resul = 0;
		String query = "SELECT * FROM usuario WHERE nombre ='"+u.getNombre()+"'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				//El usuario existe
				String contrasenia = rs.getString(2);
				if(contrasenia.equals(u.getContraseña()))
					resul = 2;
				else 
					resul = 1;
			}else{
				resul = 0;
				//No hay ning�n usuario en la tabla con ese nombre --> El usuario no existe, no est� registrado
			}
			
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resul;
	}
	
	
	public boolean registrarUsuario(Usuario u){
		boolean registrado;
		int resul = existeUsuario(u);
		if(resul==0){
			String s = "INSERT INTO usuario(nombre,contraseña,dinero) VALUES('"+u.getNombre()+"','"+u.getContraseña()+"',"+u.getDinero()+ ")";
			try {
				stmt.executeUpdate(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			registrado = true;
		}else{
			registrado = false;
		}
		
		return registrado;
	}
	
	public static void ingresararsaldo( String nombre, float dinero) {
		
		
		try {
			String query= "UPDATE usuario SET dinero= dinero+"+dinero+" WHERE nombre= '" + nombre+"'";

			stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	



public static void retirararsaldo( String nombre, float dinero) {
	
	
	try {
		String query= "UPDATE usuario SET dinero= dinero-"+dinero+" WHERE nombre= '" + nombre+"'";

		 stmt.executeUpdate(query);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


	public static int obtenerValorCarta(String ruta) {
	
	int valor=0;
	String query= "SELECT valor FROM cartas WHERE imagen='"+ruta+"'";
	ResultSet rs;
	try {
		rs = stmt.executeQuery(query);
		valor = rs.getInt(1);
		rs.close();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return valor;
	
	
	
}

/*public static Carta repartirCarta(){
	Carta aCartas= new Carta("","");
	String query = "SELECT RANDOM carta,palo FROM cartas";
	try {
		ResultSet rs = stmt.executeQuery(query);
			String carta = rs.getString(1);
			String palo= rs.getString(2);
			aCartas =new Carta(carta,palo);
			
		
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return aCartas;
}
*/
	public static float obtenerSaldo(String nombre){
	String query = "SELECT dinero FROM usuario WHERE nombre ='"+nombre+"'";
	ResultSet rs;
	float saldo = 0;
	try {
		rs = stmt.executeQuery(query);
		saldo = rs.getFloat(1);
		rs.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return saldo;
}

	public static ArrayList<String> obtenerRutasDeLaBaseDeDatos(){
	ArrayList<String> aRutas = new ArrayList<String>();
	String query = "SELECT imagen FROM cartas";
	try {
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()){
			String ruta = rs.getString(1);
			aRutas.add(ruta);
		}
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return aRutas;
}


	public static void ganaJugador( int dinero,String nombre) {
		
		
		
		try {
			String query= "UPDATE usuario SET dinero= dinero+"+dinero+" WHERE nombre= '" + nombre+"'";

			 stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public static void ganaDealer( int dinero,String nombre) {
			
			
			
			try {
				String query= "UPDATE usuario SET dinero= dinero-"+dinero+" WHERE nombre= '" + nombre+"'";
	
				 stmt.executeUpdate(query);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}



	public static void actualizarHasalidoCarta( String ruta) {
		
		try {
			String query= "UPDATE cartas SET Hasalido=1 WHERE imagen= '" + ruta+"'";
	
			 stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static String obtenerCartaAleatoria() {
		
		String ruta = "";
		
		try{
	
		
		String query= "SELECT imagen FROM cartas WHERE Hasalido=0 ORDER BY RANDOM() LIMIT 1"; //HASALIDO=0 //////////////////////////////////////////////////////// METODO ACTUALIZAR TODO HASALIDO=0
		
			ResultSet rs = stmt.executeQuery(query);
			ruta = rs.getString(1);
		System.out.println(ruta);
			rs.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return ruta;
		
		
		
	}
	
	
	
public static void resetearHasalido() {
		
	
		int i=1;
		while(i<52) {
		try {
			String query= "UPDATE cartas SET Hasalido=0 WHERE rownum= " +i;
			i++;
	
			 stmt.executeUpdate(query);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
	}
	
		
	
	