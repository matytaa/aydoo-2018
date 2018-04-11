package ar.edu.untref.aydoo;

public class Tablero {

    private final int ancho = 5;
    private final int largo = 5;
    private Casillero[][] casilleros;

    public Tablero() {
        this.casilleros = new Casillero[ancho][largo];
        inicializarCasilleros();
    }

    private void inicializarCasilleros() {
        for (int fila = 0; fila < cantidadFilas(); fila++) {
            for (int columna = 0; columna < cantidadColumnas(); columna++) {
                Casillero unCasillero = new Casillero(fila, columna);
                this.casilleros[fila][columna] = unCasillero;
            }
        }
    }

    public int cantidadColumnas() {
        return this.ancho;
    }

    public int cantidadFilas() {
        return this.largo;
    }

    public boolean casilleroEstaVacion(final int fila, final int columna) {
        Casillero unCasillero = this.casilleros[fila][columna];
        try {
            if (unCasillero.estadoCasillero()) {
                return unCasillero.estaVacio();
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return Boolean.parseBoolean(null);
    }


    public int verificarCasilleros() {
        int casillerosCreados = 0;
        for (int fila = 0; fila < this.largo; fila++) {
            for (int columna = 0; columna < this.ancho; columna++) {
                if (this.casilleros[fila][columna] != null) {
                    casillerosCreados++;
                }
            }
        }
        return casillerosCreados;
    }

    public ResultadoDelDisparo disparar(final Casillero casilleroADisparar) {
        boolean resultadoDisparo;
        resultadoDisparo = casilleroEstaVacion(
                casilleroADisparar.dameTuPosicioHorizontal(),
                casilleroADisparar.dameTuPosicioVertical());

        if (resultadoDisparo) {
            return ResultadoDelDisparo.AGUA;
        }

        return tocarBarco(casilleroADisparar.dameElBarco());
    }

    private ResultadoDelDisparo tocarBarco(final Barco barco) {
        Barco unBarco = barco;
        unBarco.tocado();
        if (unBarco.estaHundido()) {
            return ResultadoDelDisparo.HUNDIDO;
        }
        return ResultadoDelDisparo.TOCADO;
    }

    public boolean llenarCasillero(final Casillero casilleroADisparar) {
        if (tableroInicializado()) {
            return false;
        }
        this.casilleros
                [casilleroADisparar.dameTuPosicioHorizontal()]
                [casilleroADisparar.dameTuPosicioVertical()]
                = casilleroADisparar;
        return true;
    }

    private boolean tableroInicializado() {
        return this.casilleros == null;
    }
}
