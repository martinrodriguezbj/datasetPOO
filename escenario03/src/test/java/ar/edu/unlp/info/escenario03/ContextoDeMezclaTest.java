// Contenido del archivo ContextoDeMezclaTest.java
package ar.edu.unlp.info.escenario03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContextoDeMezclaTest {

    private ContextoDeMezcla contexto;

    @BeforeEach
    public void setUp() {
        this.contexto = new ContextoDeMezcla();
    }

    @Test
    public void testMezclarColecciones() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));

        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("1", "a", "2", "b", "3", "c", "4", "d", "5", "e", "6", "f"));

        assertEquals(resultadoEsperado, this.contexto.mezclarColecciones(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColeccionesConDiferenteLongitud() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        assertThrows(IllegalArgumentException.class, () -> this.contexto.mezclarColecciones(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColeccionesConLongitudMenorASeis() {
        ArrayList<String> coleccion1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ArrayList<String> coleccion2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        assertThrows(IllegalArgumentException.class, () -> this.contexto.mezclarColecciones(coleccion1, coleccion2));
    }
}