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
	  if(condicionDelanteros() && condicionDefensores() && condicionMediocampistas() && condicionArquero()) return true;
	return false;
	}
	
	private boolean condicionDelanteros(){
	  return formacionDelanteros() == solucion.cantDelanteros();
	}
	
	private boolean condicionDefensores(){
	  return formacionDefensores() == solucion.cantDefensores();
	}
	
	private boolean condicionMediocampistas(){
	  return formacionMediocampistas() == solucion.cantMediocampistas();
	}
	
	private boolean condicionArquero(){
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
	

	public static void main(String[] args) {
		
		InstanciaJugadores instancia = cargarInstancia();
		
		Solver solver = new Solver(instancia);
		System.out.println(solver.resolver());

	}

	public static InstanciaJugadores  cargarInstancia(){
		InstanciaJugadores instancia = new InstanciaJugadores(4,3,3);
		
		    instancia.agregarJugador(new Jugador("Otamendi", "Defensor", 8.0));    // 0
		    instancia.agregarJugador(new Jugador("Funes Mori", "Defensor", 7.0));  //1
		    instancia.agregarJugador(new Jugador("Mercado", "Defensor", 6.0));     //2
		    instancia.agregarJugador(new Jugador("Pazzela", "Defensor", 7.0));		//3
		    instancia.agregarJugador(new Jugador("Mascherano", "Defensor", 10.0)); //4
		    instancia.agregarJugador(new Jugador("Fazzio", "Defensor", 8.0));				//5

		   
		    instancia.agregarJugador(new Jugador("Romero", "Arquero", 9.0));          //6
		    instancia.agregarJugador(new Jugador("Guzman", "Arquero", 8.0));			//7
		    instancia.agregarJugador(new Jugador("Marchesin", "Arquero", 8.0));		//8
		    	
		    instancia.agregarJugador(new Jugador("Acuña", "Mediocampista", 7.0));   //9
		    instancia.agregarJugador(new Jugador("Biglia", "Mediocampista", 5.0));	//10
		    instancia.agregarJugador(new Jugador("Rigone", "Mediocampista", 6.0)); //11
		    instancia.agregarJugador(new Jugador("Paredes", "Mediocampista", 7.0));	//12
		    instancia.agregarJugador(new Jugador("Kranevitter", "Mediocampista", 8.0)); //13
		    instancia.agregarJugador(new Jugador("Banega", "Mediocampista", 8.0));		//14
		    instancia.agregarJugador(new Jugador("Papu Gomez", "Mediocampista", 8.0));	//15
		    instancia.agregarJugador(new Jugador("Salvio", "Mediocampista", 7.0));		//16
		    instancia.agregarJugador(new Jugador("Peroti", "Mediocampista", 6.0));		//17
		    instancia.agregarJugador(new Jugador("Messi", "Delantero", 10.0));				//18
		    instancia.agregarJugador(new Jugador("Agüero", "Delantero", 8.0));			//19
		    instancia.agregarJugador(new Jugador("Icardi", "Delantero", 8.0));				//20
		    instancia.agregarJugador(new Jugador("Dybala", "Delantero", 8.0));			//21
		    instancia.agregarJugador(new Jugador("Di Maria", "Delantero", 9.0));			//22
		   
		    instancia.getJugador(5).setIncompatibles("Guzman");
		    instancia.getJugador(7).setIncompatibles("Romero");
		    instancia.getJugador(10).setIncompatibles("Di Maria");
		    instancia.getJugador(13).setIncompatibles("Papu Gomez");
		    instancia.getJugador(15).setIncompatibles("Kranevitter");
		    instancia.getJugador(18).setIncompatibles("Icardi");
		    instancia.getJugador(18).setIncompatibles("Dibala");
		    instancia.getJugador(19).setIncompatibles("Dibala");
		    instancia.getJugador(20).setIncompatibles("Messi");
		    instancia.getJugador(21).setIncompatibles("Agüero");
		    instancia.getJugador(21).setIncompatibles("Agüero");
		    instancia.getJugador(22).setIncompatibles("Biglia");
		    
		    return instancia;
		
	}
		
	
	
	
	
	

}
