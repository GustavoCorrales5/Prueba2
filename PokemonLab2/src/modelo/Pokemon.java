package modelo;

public class Pokemon {

	
	private String nombre;
	private int numero;
	private double posicion;
	private boolean seleccionado;
	private boolean atrapado;
	
	
	public Pokemon(String nombre, int numero,boolean seleccionado, double posicion) {
		this.nombre = nombre;
		this.numero = numero;
		this.seleccionado = seleccionado;
		this.posicion = posicion;
	}
	
	public void pokemonSeleccionado(boolean f) {
		this.seleccionado = f;
	}
	
	public boolean darSeleccionado() {
		return this.seleccionado;
	}
	
	public double darPosicion() {
		return this.posicion;
	}
	public void cambiarPosicion(double a) {
		this.posicion = a;
	}
	
	public int darNumero() {
		return this.numero;
	}
	
	public String nombre() {
		return this.nombre;
	}
	
	public void atrapado(boolean a) {
		this.atrapado = a;
	}
	public boolean darAtrapado() {
		return this.atrapado;
	}
}
