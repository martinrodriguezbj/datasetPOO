// Contenido del archivo EstrategiaDeMezclaIntercalarTest.java
package ar.edu.unlp.info.escenario04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstrategiaDeMezclaIntercalarTest_GPT {

    private EstrategiaDeMezclaIntercalar estrategia;

    @BeforeEach
    public void setUp() {
        estrategia = new EstrategiaDeMezclaIntercalar();
    }

    @Test
    public void testMezclarColeccionesConTamanoMenorA5() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("4", "5", "6"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("-1"));

        assertEquals(resultadoEsperado, estrategia.mezclar(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColeccionesConTamanoMayorA5() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("7", "8", "9", "10", "11", "12"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("1", "7", "2", "8", "3", "9", "4", "10", "5", "11", "6", "12"));

        assertEquals(resultadoEsperado, estrategia.mezclar(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColeccionesConTamanoDiferente() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("7", "8", "9", "10", "11"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("-1"));

        assertEquals(resultadoEsperado, estrategia.mezclar(coleccion1, coleccion2));
    }
}