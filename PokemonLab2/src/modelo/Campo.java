package modelo;

public class Campo {
	

	private static final double longitudX = 2000;
	private static final double longitudY = 900;
	private static final double posicionXPokemon = 200;
	private static final double posicionXBandera = 1600;
	private Pokemon[] pokemon = new Pokemon[3];
	private Pokemon pokemonSeleccionado;
	private double desplazamientoX;
	private int numeroPokemon;
	private int numeroPokemonSeleccionado;
	
	
	
	
	public Campo() {
		
		
		Pokemon pika = new Pokemon("pikachu",0,false,Campo.posicionXPokemon);
		pokemon[0] = pika;
		Pokemon chari = new Pokemon("charizard",1,false,Campo.posicionXPokemon);
		pokemon[1] = chari;
		Pokemon umbreon= new Pokemon("umbreon",2,false,Campo.posicionXPokemon);
		pokemon[2] = umbreon;
		
		this.numeroPokemon = 3;
	}
	
	
	public Pokemon seleccionarPokemon(int a) {
		
		boolean parar = false;
		for(int i = 0; i<3&& parar==false; i++) {
			if(pokemon[i].darNumero() == a) {
				parar = true;
				pokemon[i].pokemonSeleccionado(true);
				pokemonSeleccionado = pokemon[i];
				
				numeroPokemonSeleccionado = i;
				
			}
			
		}
		return pokemonSeleccionado;
	
	}
	
	public void desplazamiento(long time) {
			this.desplazamientoX = posicionXPokemon;
			boolean parar = false;
		for( double i =posicionXPokemon; desplazamientoX<= posicionXBandera&&parar == false; i += 5 ) {
			this.desplazamientoX += 100;
			this.esperarSegundos(1);
			if(desplazamientoX >= (posicionXBandera-200)) {
				parar = true;
			}
			
			pokemonSeleccionado.cambiarPosicion(this.desplazamientoX);
		}
	}
	
	public void desplazamiento2(long time) {
		this.desplazamientoX = posicionXPokemon;
		boolean parar = false;
	for( double i =posicionXPokemon; desplazamientoX<= posicionXBandera&&parar == false; i += 5 ) {
		this.desplazamientoX += 100;
		this.esperarSegundos(1);
		if(desplazamientoX ==longitudX || pokemonAtrapado()) {
			parar = true;
		}
		
		pokemonSeleccionado.cambiarPosicion(this.desplazamientoX);
	}
}
	


	
	public void esperarSegundos(int segundos) {
		try {
			Thread.sleep(segundos*150);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}
	
	public int darNumeroPokemon() {
		
		
		return this.numeroPokemon;
	}
	

public Pokemon darPokemonSeleccionado() {
	return this.pokemonSeleccionado;
}



public double darDesplazamiento() {
	return this.desplazamientoX;
}

public boolean darDiferenciaDistancia() {
	return (desplazamientoX > posicionXBandera);
}

public double distanciaRecorrida() {
	return ((posicionXBandera-200)-(posicionXPokemon));
}

public boolean pokemonAtrapado() {
	return pokemonSeleccionado.darAtrapado();
}

public void cambiarPokemonAtrapado(boolean a) {
	this.pokemonSeleccionado.atrapado(a);
}
public int numeroPokemonSeleccionado() {
	return this.numeroPokemonSeleccionado;
}
public void cambiarNumeroPokemonSeleccionado(int a) {
	this.numeroPokemonSeleccionado = a;
}
	
	
}
