package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Datos.Usuario;

public class BD {
	
	private Connection con;
	private static Statement stmt;
	
	/**
	 * Metodo que crea una sentencia para acceder a la base de datos 
	 */
	public void crearSentencia()
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

	public void conectar()
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
	public int existeUsuario(Usuario u){
		int resul = 0;
		String query = "SELECT * FROM usuario WHERE nombre ='"+u.getNombre()+"'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				//El usuario existe
				String contrasenia = rs.getString(1);
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
		
		String query = "SELECT dinero FROM usuario WHERE nombre= "+ nombre;
		
		try {
			 stmt.executeQuery(query);
			query= "UPDATE usuario SET dinero= dinero+"+dinero+"' WHERE nombre= " + nombre;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	
	
	