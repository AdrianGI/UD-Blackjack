package Datos;

public class Carta {

	
	String carta;
	String color;
	String palo;
	int valor;
	int Hasalido;  // SE GUARDARA UN 0 SI NO HA SALIDO LA CARTA Y UN 1 CUANDO HAYA SALIDO PARA QUE NO SE REPITA
	
	
	public Carta(String carta, String palo) {
		super();
		this.carta = carta;
		this.palo = palo;
		
	}


	public String getCarta() {
		return carta;
	}


	public void setCarta(String carta) {
		this.carta = carta;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getPalo() {
		return palo;
	}


	public void setPalo(String palo) {
		this.palo = palo;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getHasalido() {
		return Hasalido;
	}


	public void setHasalido(int hasalido) {
		Hasalido = hasalido;
	}
	
	
}
