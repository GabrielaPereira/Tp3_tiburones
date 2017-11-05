package logica;

import java.util.ArrayList;
public class InstanciaEquipo {
	
	@SuppressWarnings("unused")
	private int nivelTotal;
	private ArrayList<Jugador> equipo;
	private  ArrayList<Integer> formacion;
	
	public InstanciaEquipo(int def, int med, int del){
		equipo = new ArrayList<Jugador>();
		setFormacion(def,med,del);
		nivelTotal = 0;
	}
	
	private void setFormacion(int def, int med, int del){
		formacion = new ArrayList<Integer>();
		formacion.add(def);
		formacion.add(med);
		formacion.add(del);
	}
	
	public int cantidadDeJugadoresEnEquipo(){
		return equipo.size();
	}
	
	public void agregarAlEquipo(Jugador j){
		equipo.add(j);
		nivelTotal += j.nivel;
	}
	
	
	public boolean existeJugadorEnEquipo(Jugador j){
		return equipo.contains(j);
	}
	
	public Jugador getJugadorEquipo(int j){
		return equipo.get(j);
	}


public static void main(String[] args) {
	System.out.println("hello world");
}	
	
}
