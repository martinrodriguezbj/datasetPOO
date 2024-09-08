// Contenido del archivo ContextoDeMezclaTest.java
package ar.edu.unlp.info.escenario03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ContextoDeMezclaTest {

    private ContextoDeMezcla contexto;

    @BeforeEach
    public void setUp() {
        this.contexto = new ContextoDeMezcla();
    }

    @Test
    public void testMezclarColeccionesConTamanosDiferentes() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        assertThrows(IllegalArgumentException.class, () -> {
            contexto.mezclarColecciones(coleccion1, coleccion2);
        });
    }

    @Test
    public void testMezclarColeccionesConTamanoIgualOMenorA5() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        assertThrows(IllegalArgumentException.class, () -> {
            contexto.mezclarColecciones(coleccion1, coleccion2);
        });
    }

    @Test
    public void testMezclarColeccionesConTamanoMayorA5() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("1", "a", "2", "b", "3", "c", "4", "d", "5", "e", "6", "f"));
        ArrayList<String> resultado = contexto.mezclarColecciones(coleccion1, coleccion2);
        assertEquals(resultadoEsperado, resultado);
    }
}