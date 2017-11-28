package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolverFBTest {
	 @Test
	public void solucionFactible() {
		InstanciaJugadores instancia = new InstanciaJugadores(4,3,3);
		Solucion solucion = cargarSolucion();
		
		Solver solverFB = new Solver(instancia);
		assertTrue(solverFB.esFactible(solucion));
	}

	@Test
	public void solucionNoFactible() {
		InstanciaJugadores instancia = new InstanciaJugadores(3,3,3);
		Solucion solucion = cargarSolucion();
		
		Solver solverFB = new Solver(instancia);
		assertFalse(solverFB.esFactible(solucion));
	}
	
	@Test
	public void mejorSolucion(){
		Solucion solucion = cargarSolucion();
		Solucion mejor = cargarSolucionMejor();
		
		InstanciaJugadores instancia = new InstanciaJugadores(4,3,3);
		Solver solver = new Solver(instancia);
		
		assertTrue(solver.esMejor(mejor, solucion));
		assertFalse(solver.esMejor(solucion, mejor));
	}
	
	@Test
	public void resolver(){
		InstanciaJugadores instancia = new InstanciaJugadores(4,3,3);		
		Solver solverFB = new Solver(instancia);
		System.out.println(solverFB.resolver());
	}
	
	
	
	public Solucion cargarSolucion(){
		Solucion solucion = new Solucion();
		
		    solucion.agregarJugador(new Jugador("Romero", "Arquero", 9.0)); 
		 
		    solucion.agregarJugador(new Jugador("Otamendi", "Defensor", 8.0));    
		    solucion.agregarJugador(new Jugador("Funes Mori", "Defensor", 7.0));  
		    solucion.agregarJugador(new Jugador("Mercado", "Defensor", 6.0));     
		    solucion.agregarJugador(new Jugador("Pazzela", "Defensor", 7.0));		
		    solucion.agregarJugador(new Jugador("Acuña", "Mediocampista", 7.0));   
		    solucion.agregarJugador(new Jugador("Biglia", "Mediocampista", 5.0));	
		    solucion.agregarJugador(new Jugador("Rigone", "Mediocampista", 6.0)); 
		    solucion.agregarJugador(new Jugador("Icardi", "Delantero", 8.0));				
		    solucion.agregarJugador(new Jugador("Dybala", "Delantero", 8.0));			
		    solucion.agregarJugador(new Jugador("Di Maria", "Delantero", 9.0));			
		    
		    return solucion;
	}
	
	public Solucion cargarSolucionMejor(){
		Solucion solucion = new Solucion();
		
		    solucion.agregarJugador(new Jugador("Romero", "Arquero", 10.0)); 
		 
		    solucion.agregarJugador(new Jugador("Otamendi", "Defensor", 10.0));    
		    solucion.agregarJugador(new Jugador("Funes Mori", "Defensor", 10.0));  
		    solucion.agregarJugador(new Jugador("Mercado", "Defensor", 10.0));     
		    solucion.agregarJugador(new Jugador("Pazzela", "Defensor", 10.0));		
		    solucion.agregarJugador(new Jugador("Acuña", "Mediocampista", 10.0));   
		    solucion.agregarJugador(new Jugador("Biglia", "Mediocampista", 10.0));	
		    solucion.agregarJugador(new Jugador("Rigone", "Mediocampista", 10.0)); 
		    solucion.agregarJugador(new Jugador("Icardi", "Delantero", 10.0));				
		    solucion.agregarJugador(new Jugador("Dybala", "Delantero", 10.0));			
		    solucion.agregarJugador(new Jugador("Di Maria", "Delantero", 10.0));			
		    
		    return solucion;
	}


	public InstanciaJugadores cargarInstancia(){
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
