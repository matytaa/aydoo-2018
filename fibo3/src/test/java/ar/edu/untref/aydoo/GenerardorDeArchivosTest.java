package ar.edu.untref.aydoo;

import org.junit.Test;

import java.io.IOException;

public class GenerardorDeArchivosTest {
    @Test
    public void generarUnArchivoEnLaRutaDeDestino(){
        GenerardorDeArchivos miGenerador = new GenerardorDeArchivos();
        miGenerador.generarArchivo("salida.txt");
    }
}
