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
	public ArrayList<String> getIncompatibles(){
		return incompatibles;
	}
	public void setIncompatibles(String i ){
		incompatibles.add(i);
	}
	
    public boolean esIncompatible(Jugador j){
		return getIncompatibles().contains(j);
	}
    
    
    
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
    
    
    
    
	
}
