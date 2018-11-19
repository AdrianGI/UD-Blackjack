package Datos;

public class Usuario {

	private String nombre;
	private String contrasenya;
	private float dinero;
	private String numCuenta;
	
	
	public Usuario() {

	}
	
	public Usuario(String nombre, String contrasenya,long dinero) {
		this.setNombre(nombre);
		this.setContrasenya(contrasenya);
		this.setDinero(dinero);
		
		
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
	
	

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float total) {
		this.dinero = total;
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

