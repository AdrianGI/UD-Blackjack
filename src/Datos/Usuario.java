package Datos;

public class Usuario {

	private String nombre;
	private String contraseña;
	
	private long dinero;
	private String numCuenta;
	
	
	public Usuario() {

	}
	
	public Usuario(String nombre, String contraseña,long dinero) {
		this.setNombre(nombre);
		this.setContraseña(contraseña);
		this.setDinero(dinero);
		
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	

	public long getDinero() {
		return dinero;
	}

	public void setDinero(long dinero) {
		this.dinero = dinero;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		
		
		while(numCuenta.length()==16) {
			
			this.numCuenta = numCuenta;
		}
		
	}
	
	
		

	}

