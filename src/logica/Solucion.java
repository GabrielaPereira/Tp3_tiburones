package logica;

import java.util.ArrayList;



public class Solucion {
private ArrayList<Jugador> equipo;

	
	public Solucion(){
	   equipo = new ArrayList<Jugador>();
	  }

	public void agregarJugador(Jugador j){
		equipo.add(j);
	}

	public void eliminarJugador(Jugador j){
		equipo.remove(j);
	}
	
	public Jugador getJugador(int i){
		return equipo.get(i);
	}

	public int cantJugadores(){
		return equipo.size();
	}

	public boolean jugadorIncompatible(Jugador jugador){
		for(Jugador j: equipo)  
			if( sonIncompatibles(jugador, j) )return true;
	return false;		
	}
	
	private boolean sonIncompatibles(Jugador a, Jugador b){
	return( a.incompatibles.contains(b.getNombre()) || b.incompatibles.contains(a.getNombre())) ? true: false;
}
	public double beneficioSolucion(){
		double ret = 0.0;
		for(Jugador j : equipo)
			ret += j.getNivel();
		System.out.println("benef acum" + ret);
		return ret;
	}
	 

	public ArrayList<Jugador> getEquipo() {
		return equipo;
	}

	public ArrayList<Jugador> getObjetos(){
		return equipo;
	}
	
	public int cantDefensores(){
		int ret = 0;
		for(Jugador jugador: equipo)
			if(jugador.getPosicion() == "Defensor") ret++;
//			if(jugador.getPosicion() == "Defensor") ret++;
		return ret;
	}
	public int cantMediocampistas(){
		int ret = 0;
		for(Jugador jugador: equipo)
//			if(jugador.getPosicion() == "Mediocampista") ret++;
			if(jugador.getPosicion().equals("Mediocampista")) ret++;
		return ret;
	}
	
	public int cantDelanteros(){
		int ret = 0;
		for(Jugador jugador: equipo)
			if(jugador.getPosicion().equals("Delantero")) ret++;
//			if(jugador.getPosicion() == "Delantero") ret++;
		return ret;
	}
	
	public int cantArqueros(){
		int ret = 0;
		for(Jugador jugador: equipo)
			if(jugador.getPosicion().equals("Arquero")) ret++;
//			if(jugador.getPosicion() == "Arquero") ret++;
		return ret;
	}
	public Solucion clonar(){
		// Deep copy
		Solucion ret = new Solucion();
		for(Jugador obj: equipo)
			ret.agregarJugador(obj);
		
		return ret;
	}

	@Override
	public String toString() {
		return "Solucion [equipo=" + equipo + "]";
	}



	
}

