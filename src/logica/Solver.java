package logica;

import java.util.ArrayList;

public class Solver {
	
	InstanciaJugadores instancia;
	private ArrayList <Jugador> jugadores;
    private Solucion  mejor;
	private Solucion solucion;
	
	public Solver(InstanciaJugadores inst){
		instancia = inst;
		jugadores = inst.getObjetos();
     }
    
	
	public ArrayList<Jugador> getJugadores(){
	  return jugadores;
    }
    
	public Solucion resolver(){
		mejor = new Solucion();
		solucion = new Solucion();
		generarSolucionesDesde(0);
		return mejor;
	}
	
	public boolean existeSolucion(){
		return mejor.equipo.size() != 0;
	}
    private void generarSolucionesDesde(int i) {
		if(i == cantJugadoresInstancia()){
				if(esSolucion())mejor = solucion.clonar();
		}else{
			   if (!solucion.jugadorIncompatible(jugadores.get(i)))
				        solucion.agregarJugador(jugadores.get(i));
				generarSolucionesDesde(i+1);
				solucion.eliminarJugador(jugadores.get(i));
				generarSolucionesDesde(i+1);
			}		
		}
   
    public boolean esSolucion(){
      return esFactible(solucion) && esMejor(solucion, mejor);	
    }
    private int cantJugadoresInstancia(){
    	return instancia.cantidadDeJugadores();
    }
    
    public boolean esMejor(Solucion a , Solucion b){
	 return a.beneficioSolucion() > b.beneficioSolucion();
     }
  	
	public boolean esFactible(Solucion solucion){
	  if(condicionDelanteros(solucion) && condicionDefensores(solucion)
	     && condicionMediocampistas(solucion) && condicionArquero(solucion)) return true;
	return false;
	}
	
	private boolean condicionDelanteros(Solucion solucion){
	  return formacionDelanteros() == solucion.cantDelanteros();
	}
	
	private boolean condicionDefensores(Solucion solucion){
	  return formacionDefensores() == solucion.cantDefensores();
	}
	
	private boolean condicionMediocampistas(Solucion solucion){
	  return formacionMediocampistas() == solucion.cantMediocampistas();
	}
	
	private boolean condicionArquero(Solucion solucion){
	  return solucion.cantArqueros() == 1;
	}
	
	public int formacionDelanteros(){
	  return instancia.formacionDelanteros();
	}
	
	public int formacionDefensores(){
      return instancia.formacionDefensores();
	}
	
	public int formacionMediocampistas(){
		return instancia.formacionMediocampistas();
	}
		

}
