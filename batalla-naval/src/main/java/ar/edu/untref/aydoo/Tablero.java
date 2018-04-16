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

    public void ponerBarcoEnCasillero(final Barco unBarco,
                                      final Casillero casilleroInicial) {
        int fila = casilleroInicial.dameTuPosicioHorizontal();
        int columna = casilleroInicial.dameTuPosicioVertical();
        Sentido sentido = unBarco.obtenerSentido();
        int limite = unBarco.obtenerTamanio() - 1;
        if (verificarLimites(fila, columna, sentido, limite)) {
            casilleroInicial.ponerBarco(unBarco);
            llenarCasillero(casilleroInicial);
        }

        for (int i = 0; i < limite; i++) {
            ocuparSiguienteCasillero(unBarco, casilleroInicial, i + 1);
        }
    }

    private void ocuparSiguienteCasillero(final Barco unBarco,
                                          final Casillero casilleroInicial,
                                          final int incremento) {
        int unaColumna = casilleroInicial.dameTuPosicioVertical();
        int unaFila = casilleroInicial.dameTuPosicioHorizontal();
        if (unBarco.obtenerSentido() == Sentido.HORIZONTAL) {
            unaColumna = unaColumna + incremento;
        } else {
            unaFila = unaFila + incremento;
        }
        Casillero casilleroAuxiliar = new Casillero(unaFila, unaColumna);
        casilleroAuxiliar.ponerBarco(unBarco);
        llenarCasillero(casilleroAuxiliar);
    }

    public boolean verificarLimites(final int fila, final int columna,
                                    final Sentido sentido, final int limite) {
        boolean continuar = false;
        continuar = verificarHorizontal(columna, sentido, limite);
        if (!continuar) {
            continuar = verificarVertical(fila, sentido, limite);
        }
        return continuar;

    }

    private boolean verificarVertical(final int fila, final Sentido sentido,
                                      final int limite) {
        if (fila < this.ancho - limite
                && sentido == Sentido.VERTICAL) {
            return true;
        }
        return false;
    }

    private boolean verificarHorizontal(final int columna,
                                        final Sentido sentido,
                                        final int limite) {
        if (columna < this.largo - limite
                && sentido == Sentido.HORIZONTAL) {
            return true;
        }
        return false;
    }


}
