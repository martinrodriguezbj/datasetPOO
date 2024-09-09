// Contenido del archivo EstrategiaDeMezclaIntercalarTest.java
package ar.edu.unlp.info.escenario04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class EstrategiaDeMezclaIntercalarTest_GPT {

    private EstrategiaDeMezclaIntercalar estrategia;

    @BeforeEach
    public void setUp() {
        this.estrategia = new EstrategiaDeMezclaIntercalar();
    }

    @Test
    public void testMezclarColeccionesMenorOIgualA5() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("6", "7", "8", "9", "10"));
        ArrayList<String> resultado = this.estrategia.mezclar(coleccion1, coleccion2);
        assertEquals(Arrays.asList("-1"), resultado);
    }

    @Test
    public void testMezclarColeccionesMayorA5DiferenteTamano() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("7", "8", "9", "10", "11"));
        ArrayList<String> resultado = this.estrategia.mezclar(coleccion1, coleccion2);
        assertEquals(Arrays.asList("-1"), resultado);
    }

    @Test
    public void testMezclarColeccionesMayorA5MismoTamano() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("7", "8", "9", "10", "11", "12"));
        ArrayList<String> resultado = this.estrategia.mezclar(coleccion1, coleccion2);
        assertEquals(Arrays.asList("1", "7", "2", "8", "3", "9", "4", "10", "5", "11", "6", "12"), resultado);
    }
}