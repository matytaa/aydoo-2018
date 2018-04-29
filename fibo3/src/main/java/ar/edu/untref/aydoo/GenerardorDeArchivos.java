package ar.edu.untref.aydoo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerardorDeArchivos {

    public boolean generarArchivo(String rutaArchivo){
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(rutaArchivo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
