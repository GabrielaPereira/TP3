package Test;
import static org.junit.Assert.*;

import org.junit.Test;

import logica.Jugador;
import logica.Solucion;

public class SolucionTest {
	

	
	@Test
    public void todosIncompatibles(){
	
   	Solucion solucion = cargarDatos();
   	Solucion solucion2= solucion.clonar();
	
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(5)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(7)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(10)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(13)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(15)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(18)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(19)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(20)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(21)));
	assertTrue(solucion.jugadorIncompatible(solucion2.getJugador(22)));
	
	
	}
	   
	@Test public void todosCompatibles(){
		Solucion solucion = cargarDatos();
		assertFalse(solucion.jugadorIncompatible(new Jugador ("Gabyta", "Mediocampista",10.0)));
		assertFalse(solucion.jugadorIncompatible(new Jugador ("Benito", "Mediocampista",10.0)));
		assertFalse(solucion.jugadorIncompatible(new Jugador ("Cecilia", "Mediocampista",10.0)));
	}


	@Test public void beneficioTotal(){
		Solucion solucion = cargarDatos();
		Object s = (Object) solucion.beneficioSolucion();
		assertEquals(176.0, s);
		
	}
	   
	@Test public void formacion(){
		Solucion solucion = cargarDatos();
		assertEquals(6, solucion.cantDefensores());
		assertEquals(3, solucion.cantArqueros());
		assertEquals(9, solucion.cantMediocampistas());
		assertEquals(5, solucion.cantDelanteros());
	} 

	public Solucion cargarDatos(){
		Solucion solucion = new Solucion();
		
	    solucion.agregarJugador(new Jugador("Otamendi", "Defensor", 8.0));    // 0
	    solucion.agregarJugador(new Jugador("Funes Mori", "Defensor", 7.0));  //1
	    solucion.agregarJugador(new Jugador("Mercado", "Defensor", 6.0));     //2
	    solucion.agregarJugador(new Jugador("Pazzela", "Defensor", 7.0));		//3
	    solucion.agregarJugador(new Jugador("Mascherano", "Defensor", 10.0)); //4
	    solucion.agregarJugador(new Jugador("Fazzio", "Defensor", 8.0));				//5

	   
	    solucion.agregarJugador(new Jugador("Romero", "Arquero", 9.0));          //6
	    solucion.agregarJugador(new Jugador("Guzman", "Arquero", 8.0));			//7
	    solucion.agregarJugador(new Jugador("Marchesin", "Arquero", 8.0));		//8
	    	
	    solucion.agregarJugador(new Jugador("Acuña", "Mediocampista", 7.0));   //9
	    solucion.agregarJugador(new Jugador("Biglia", "Mediocampista", 5.0));	//10
	    solucion.agregarJugador(new Jugador("Rigone", "Mediocampista", 6.0)); //11
	    solucion.agregarJugador(new Jugador("Paredes", "Mediocampista", 7.0));	//12
	    solucion.agregarJugador(new Jugador("Kranevitter", "Mediocampista", 8.0)); //13
	    solucion.agregarJugador(new Jugador("Banega", "Mediocampista", 8.0));		//14
	    solucion.agregarJugador(new Jugador("Papu Gomez", "Mediocampista", 8.0));	//15
	    solucion.agregarJugador(new Jugador("Salvio", "Mediocampista", 7.0));		//16
	    solucion.agregarJugador(new Jugador("Peroti", "Mediocampista", 6.0));		//17
	    solucion.agregarJugador(new Jugador("Messi", "Delantero", 10.0));				//18
	    solucion.agregarJugador(new Jugador("Agüero", "Delantero", 8.0));			//19
	    solucion.agregarJugador(new Jugador("Icardi", "Delantero", 8.0));				//20
	    solucion.agregarJugador(new Jugador("Dybala", "Delantero", 8.0));			//21
	    solucion.agregarJugador(new Jugador("Di Maria", "Delantero", 9.0));			//22
	   
	    solucion.getJugador(5).setIncompatibles("Guzman");
	    solucion.getJugador(7).setIncompatibles("Romero");
	    solucion.getJugador(10).setIncompatibles("Di Maria");
	    solucion.getJugador(13).setIncompatibles("Papu Gomez");
	    solucion.getJugador(15).setIncompatibles("Kranevitter");
	    solucion.getJugador(18).setIncompatibles("Icardi");
	    solucion.getJugador(18).setIncompatibles("Dibala");
	    solucion.getJugador(19).setIncompatibles("Dibala");
	    solucion.getJugador(20).setIncompatibles("Messi");
	    solucion.getJugador(21).setIncompatibles("Agüero");
	    solucion.getJugador(21).setIncompatibles("Agüero");
	    solucion.getJugador(22).setIncompatibles("Biglia");
	    
		return solucion;
	}		
		
	}



