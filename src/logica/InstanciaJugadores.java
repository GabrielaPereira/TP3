package logica;

import java.util.ArrayList;
public class InstanciaJugadores {
	
	private ArrayList<Jugador> jugadores;
	private  ArrayList<Integer> formacion;
	

	
	public InstanciaJugadores(int def, int med, int del){
		jugadores = new ArrayList<Jugador>();
		setFormacion(def,med,del);
	}
	
	  private void setFormacion(int def, int med, int del){
		formacion = new ArrayList<Integer>();
		formacion.add(def);
		formacion.add(med);
		formacion.add(del);
	}
	
	  public int formacionDefensores(){
		  return formacion.get(0);
	  }
	  
	  public int formacionMediocampistas(){
		  return formacion.get(1);
	  }
	  
	  public int formacionDelanteros(){
		  return formacion.get(2);
	  }
	public int cantidadDeJugadores(){
		return jugadores.size();
	}
	
	
	public int cantArqueros(){
		int ret = 0;
		for(Jugador jugador: jugadores)
			if(jugador.getPosicion() == "Arquero") ret++;
		return ret;
	}
	
	public int cantDefensores(){
		int ret = 0;
		for(Jugador jugador: jugadores)
			if(jugador.getPosicion() == "Defensor") ret++;
		return ret;
	}
	
	public int cantMediocampistas(){
		int ret = 0;
		for(Jugador jugador: jugadores)
			if(jugador.getPosicion() == "Mediocampista") ret++;
		return ret;
	}
	
	public int cantDelanteros(){
		int ret = 0;
		for(Jugador jugador: jugadores)
			if(jugador.getPosicion() == "Delantero") ret++;
		return ret;
	}
	
	public void agregarJugador(Jugador j){
		jugadores.add(j);
	}
	
	
	public boolean existeJugador(Jugador j){
		return jugadores.contains(j);
	}
	
	public Jugador getJugador(int j){
		return jugadores.get(j);
	}


	@SuppressWarnings("unchecked")
	public ArrayList<Jugador> getObjetos(){
		return (ArrayList<Jugador>) jugadores.clone();
	}

	@Override
	public String toString() {
		return "\n" + jugadores +  "\n";
	}
	
}
