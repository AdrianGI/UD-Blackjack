package Datos;

public class Carta {

	
	String carta;
	String color;
	String palo;
	int valor;
	int Hasalido;  // SE GUARDARA UN 0 SI NO HA SALIDO LA CARTA Y UN 1 CUANDO HAYA SALIDO PARA QUE NO SE REPITA
	
	
	public Carta(String carta, String color, String palo, int valor, int hasalido) {
		super();
		this.carta = carta;
		this.color = color;
		this.palo = palo;
		this.valor = valor;
		Hasalido = hasalido;
	}
	
	
}
