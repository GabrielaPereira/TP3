package logica;

public class Test {
	
	

public static void main(String[] args) {
	InstanciaJugadores instanciaJugadores = new InstanciaJugadores(4,3,3);
   for(int i = 0; i < 23; i++){
	   Jugador aux = new Jugador();
	   instanciaJugadores.agregarJugador(aux);
   }

	   

	   instanciaJugadores.getJugador(0).setJugador("Otamendi", "Defensor", 1.0);
	   instanciaJugadores.getJugador(1).setJugador("Funes Mori", "Defensor", 8.0);
	   instanciaJugadores.getJugador(2).setJugador("Mercado", "Defensor", 8.0);
	   instanciaJugadores.getJugador(3).setJugador("Pazzela", "Defensor", 3.0);
	   instanciaJugadores.getJugador(4).setJugador("Mascherano", "Defensor", 8.0);
	   instanciaJugadores.getJugador(5).setJugador("Fazzio", "Defensor", 6.0);

	   
	   instanciaJugadores.getJugador(6).setJugador("Romero", "Arquero", 8.0);
	   instanciaJugadores.getJugador(7).setJugador("Guzman", "Arquero", 9.0);
	   instanciaJugadores.getJugador(8).setJugador("Marchesin", "Arquero", 1.0);
	   
	    instanciaJugadores.getJugador(9).setJugador("Acuña", "Mediocampista", 4.0);
	   instanciaJugadores.getJugador(10).setJugador("Biglia", "Mediocampista", 3.0);
	   instanciaJugadores.getJugador(11).setJugador("Rigone", "Mediocampista", 80.0);
	   instanciaJugadores.getJugador(12).setJugador("Paredes", "Mediocampista", 5.0);
	   instanciaJugadores.getJugador(13).setJugador("Kranevitter", "Mediocampista", 1.0);
	   instanciaJugadores.getJugador(14).setJugador("Banega", "Mediocampista", 3.0);
	   instanciaJugadores.getJugador(15).setJugador("Papu Gomez", "Mediocampista", 9.0);
	   instanciaJugadores.getJugador(16).setJugador("Salvio", "Mediocampista", 6.0);
	   instanciaJugadores.getJugador(17).setJugador("Peroti", "Mediocampista", 5.0);
	   
	   instanciaJugadores.getJugador(18).setJugador("Messi", "Delantero", 8.0);
	   instanciaJugadores.getJugador(19).setJugador("Agüero", "Delantero", 8.0);
	   instanciaJugadores.getJugador(20).setJugador("Icardi", "Delantero", 5.0);
	   instanciaJugadores.getJugador(21).setJugador("Dybala", "Delantero", 8.0);
	   instanciaJugadores.getJugador(22).setJugador("Di Maria", "Delantero", 1.0);
	   instanciaJugadores.getJugador(6).setIncompatibles("Caro");
	   
	  Solucion s = new Solucion();
	  
	  for (int i= 0; i < 11 ; i++){
		  s.agregarJugador(instanciaJugadores.getJugador(i));
	  }
	 
	  Jugador j = new Jugador("Caro", "Delantero", 8.0);
	  //j.setIncompatibles("Romer");
	  boolean es = s.jugadorIncompatible(j);
	  System.out.println(es);

	  
	  

   }


}
