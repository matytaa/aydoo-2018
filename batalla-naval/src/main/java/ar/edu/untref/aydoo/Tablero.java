package ar.edu.untref.aydoo;

public class Tablero {

	private final int ancho = 5;
	private final int largo = 5;
	private Casillero[][] casilleros;
	
	public Tablero() {
		casilleros = new Casillero[ancho][largo];
		inicializarCasilleros();
	}

	private void inicializarCasilleros() {
		for (int fila = 0; fila < cantidadFilas(); fila++){
			for (int columna = 0; columna < cantidadColumnas(); columna++){
				this.casilleros[fila][columna] = null;
			}
		}
	}

	public int cantidadColumnas() {
		return this.ancho;
	}

	public int cantidadFilas() {
		return this.largo;
	}

	public boolean hayBarcoEnPosicion(int columna, int fila) {
		// TODO Auto-generated method stub
		Casillero unCasillero = this.casilleros[fila][columna];
		if (unCasillero==null){
			return false;
		}

		return unCasillero.estaVacio();
	}
	
	

}
