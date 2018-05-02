package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.util.LinkedList;
import java.util.List;

public class EscrutadorTest {

    Escrutador miEscrutinio;
    Candidato candidato1;
    Candidato candidato2;
    Candidato candidato3;
    Candidato candidato4;
    Candidato candidato5;
    Candidato candidato6;


    Voto votoCandidato1;
    Voto votoCandidato2;
    Voto votoCandidato3;
    Voto votoCandidato4;
    Voto votoCandidato5;
    Voto votoCandidato6;
    Voto votoCandidato7;
    Voto votoCandidato8;

    Voto votoCandidato9;
    Voto votoCandidato10;
    Voto votoCandidato11;
    Voto votoCandidato12;
    Voto votoCandidato13;
    Voto votoCandidato14;
    Voto votoCandidato15;

    Partido estiloTortuga;
    Partido pikoroAcademi;
    List<Partido> listaDePartidos;
    List<Provincia> listaDeProvincias;
    List<Voto> listaDeVotos = new LinkedList<Voto>();
    Provincia buenosAires = new Provincia("Buenos Aires");
    Provincia misiones = new Provincia("Misiones");
    Provincia corrientes = new Provincia("Corrientes");
    Provincia entreRios = new Provincia("Entre Rios");
    Provincia chaco = new Provincia("Chaco");
    Provincia cordoba = new Provincia("Cordoba");
    Provincia santaFe = new Provincia("Santa Fe");
    Provincia laPampa = new Provincia("La Pampa");
    Provincia chubut = new Provincia("Chubut");
    Provincia rioNegro = new Provincia("Rio Negro");
    Provincia santaCruz = new Provincia("Santa Cruz");
    Provincia neuquen = new Provincia("Neuquen");
    Provincia mendoza = new Provincia("Mendoza");
    Provincia tucuman = new Provincia("Tucuman");
    Provincia santiagoDelEstero = new Provincia("Santiago del Estero");
    Provincia jujuy = new Provincia("Jujuy");
    Provincia salta = new Provincia("Salta");
    Provincia formosa = new Provincia("Formosa");
    Provincia tierraDelFuego = new Provincia("Tierra del Fuego");
    Provincia laRioja = new Provincia("La Rioja");
    Provincia sanLuis = new Provincia("San Luis");
    Provincia catamarca = new Provincia("Catamarca");
    Provincia sanJuan = new Provincia("San Juan");

    @Before
    public void setUp() {

        estiloTortuga = new Partido("Estilo tortuga");
        pikoroAcademi = new Partido("Pikoro Academi");

        listaDePartidos = new LinkedList<Partido>();
        listaDePartidos.add(estiloTortuga);
        listaDePartidos.add(pikoroAcademi);


        listaDeProvincias = new LinkedList<Provincia>();
        listaDeProvincias.add(buenosAires);
        listaDeProvincias.add(misiones);
        listaDeProvincias.add(corrientes);
        listaDeProvincias.add(entreRios);
        listaDeProvincias.add(chaco);
        listaDeProvincias.add(cordoba);
        listaDeProvincias.add(santaFe);
        listaDeProvincias.add(laPampa);
        listaDeProvincias.add(chubut);
        listaDeProvincias.add(rioNegro);
        listaDeProvincias.add(santaCruz);
        listaDeProvincias.add(neuquen);
        listaDeProvincias.add(mendoza);
        listaDeProvincias.add(tucuman);
        listaDeProvincias.add(santiagoDelEstero);
        listaDeProvincias.add(jujuy);
        listaDeProvincias.add(salta);
        listaDeProvincias.add(formosa);
        listaDeProvincias.add(tierraDelFuego);
        listaDeProvincias.add(sanJuan);
        listaDeProvincias.add(laRioja);
        listaDeProvincias.add(sanLuis);
        listaDeProvincias.add(catamarca);


        candidato1 = new Candidato("Goku", estiloTortuga);
        candidato2 = new Candidato("Milk", estiloTortuga);
        candidato3 = new Candidato("Goten", estiloTortuga);
        candidato4 = new Candidato("Trunks", pikoroAcademi);
        candidato5 = new Candidato("Gohan", pikoroAcademi);
        candidato6 = new Candidato("Krilin", estiloTortuga);

        votoCandidato1 = new Voto(candidato1, mendoza);
        votoCandidato2 = new Voto(candidato2, chubut);
        votoCandidato3 = new Voto(candidato3, cordoba);
        votoCandidato4 = new Voto(candidato4, corrientes);
        votoCandidato5 = new Voto(candidato5, misiones);
        votoCandidato6 = new Voto(candidato6, santaCruz);
        votoCandidato7 = new Voto(candidato1, santaCruz);
        votoCandidato8 = new Voto(candidato1, santaCruz);

        votoCandidato9 = new Voto(candidato1, corrientes);
        votoCandidato12 = new Voto(candidato1, corrientes);
        votoCandidato13 = new Voto(candidato1, corrientes);
        votoCandidato15 = new Voto(candidato1, corrientes);
        votoCandidato10 = new Voto(candidato5, corrientes);
        votoCandidato11 = new Voto(candidato5, corrientes);
        votoCandidato14 = new Voto(candidato5, corrientes);

        listaDeVotos.add(votoCandidato1);
        listaDeVotos.add(votoCandidato2);
        listaDeVotos.add(votoCandidato3);
        listaDeVotos.add(votoCandidato4);
        listaDeVotos.add(votoCandidato5);
        listaDeVotos.add(votoCandidato6);
        listaDeVotos.add(votoCandidato7);
        listaDeVotos.add(votoCandidato8);

        listaDeVotos.add(votoCandidato9);
        listaDeVotos.add(votoCandidato10);
        listaDeVotos.add(votoCandidato11);
        listaDeVotos.add(votoCandidato12);
        listaDeVotos.add(votoCandidato13);
        listaDeVotos.add(votoCandidato14);
        listaDeVotos.add(votoCandidato15);

        miEscrutinio = new Escrutador(listaDeVotos);
        miEscrutinio.agregarListaDePartidos(listaDePartidos);
        miEscrutinio.agregarListaDeProvincias(listaDeProvincias);
    }

    @Test
    public void deberiaObtenerLaCantidadDeVotosDeUnCandidatoPorProvincia() {
        int resultado = miEscrutinio.cantidadDeVotosEnProvinciaPorCantidato(candidato1, mendoza);
        Assert.assertEquals(1, resultado);
        resultado = miEscrutinio.cantidadDeVotosEnProvinciaPorCantidato(candidato1, santaCruz);
        Assert.assertEquals(2, resultado);
    }

    @Test
    public void deberiaDarUnaCantidadDe3Votos() {
        LinkedList<Voto> listaDeVotos = new LinkedList<Voto>();
        listaDeVotos.add(votoCandidato1);
        listaDeVotos.add(votoCandidato2);
        listaDeVotos.add(votoCandidato3);
        miEscrutinio = new Escrutador(listaDeVotos);
        Assert.assertEquals(3, miEscrutinio.darCantidadDeVotos());
    }

    @Test
    public void deberiaComputar6VotosParaEstiloTortuga() {
        Assert.assertEquals(10, miEscrutinio.cantidadDeVotosPorPartido("Estilo tortuga"));
    }

    @Test
    public void deberiaSerEstiloTortugaElPartidoDeMayorVotos() {
        Assert.assertEquals(estiloTortuga, miEscrutinio.partidoConMasVotos());
    }

    @Test
    public void deberiaOptenerElCandidatoConMasVotosEnSantaCruz() {
        Assert.assertEquals(candidato1, miEscrutinio.candidatoConMasVotosEnUnaProvincia(santaCruz));
        Assert.assertEquals(candidato2, miEscrutinio.candidatoConMasVotosEnUnaProvincia(chubut));
        Assert.assertEquals(candidato5, miEscrutinio.candidatoConMasVotosEnUnaProvincia(misiones));
        Assert.assertEquals(candidato1, miEscrutinio.candidatoConMasVotosEnUnaProvincia(corrientes));
    }
}
