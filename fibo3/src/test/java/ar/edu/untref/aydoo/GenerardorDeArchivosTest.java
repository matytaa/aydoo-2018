package ar.edu.untref.aydoo;

import org.junit.Test;

public class GenerardorDeArchivosTest {
    @Test
    public void generarUnArchivoEnLaRutaDeDestino(){
        GenerardorDeArchivos miGenerador = new GenerardorDeArchivos("salida.txt");
        miGenerador.generarArchivo();
    }

    @Test
    public void escribirArchivo(){
        GenerardorDeArchivos miGenerador = new GenerardorDeArchivos("salida.txt");
        miGenerador.generarArchivo();
        miGenerador.escribirArchivo("hola soy goku");
    }
}
