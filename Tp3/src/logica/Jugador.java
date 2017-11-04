package logica;

import java.util.ArrayList;

public class Jugador {

	String nombre;
	Double nivel;
	String posicion;
	ArrayList<String> incompatibles;
	
	public Jugador(){
		incompatibles = new ArrayList<String>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getNivel() {
		return nivel;
	}
	public void setNivel(Double nivel ) {
		this.nivel = nivel;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	
	
	
}
