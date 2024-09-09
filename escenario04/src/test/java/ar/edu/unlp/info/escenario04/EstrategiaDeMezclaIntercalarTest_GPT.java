package ar.edu.unlp.info.escenario04;

// Importando las piezas de JUnit que necesitamos
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import ar.edu.unlp.info.escenario04.ContextoDeMezcla;
import ar.edu.unlp.info.escenario04.EstrategiaDeMezclaIntercalar;

public class EstrategiaDeMezclaIntercalarTest_GPT {

    // Definiendo los objetos que necesitamos para los tests
    private ContextoDeMezcla contexto;
    private EstrategiaDeMezclaIntercalar estrategia;

    @BeforeEach
    public void setUp() {
        // Instanciando los objetos que necesitamos para los tests
        this.contexto = new ContextoDeMezcla();
        this.estrategia = new EstrategiaDeMezclaIntercalar();
        this.contexto.establecerEstrategia(this.estrategia);
    }

    @Test
    public void testMezclarColeccionesTamanosDiferentes() {
        // Ejercitando el objeto y verificando el resultado
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("-1"));
        assertEquals(resultadoEsperado, this.contexto.mezclarColecciones(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColeccionesTamanosIgualesMenorASeis() {
        // Ejercitando el objeto y verificando el resultado
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("-1"));
        assertEquals(resultadoEsperado, this.contexto.mezclarColecciones(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColeccionesTamanosIgualesMayorASeis() {
        // Ejercitando el objeto y verificando el resultado
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("1", "a", "2", "b", "3", "c", "4", "d", "5", "e", "6", "f"));
        assertEquals(resultadoEsperado, this.contexto.mezclarColecciones(coleccion1, coleccion2));
    }

}