// Contenido del archivo ContextoDeMezclaTest.java
package ar.edu.unlp.info.escenario03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ContextoDeMezclaTest {

    private ContextoDeMezcla contexto;
    private ArrayList<String> coleccion1;
    private ArrayList<String> coleccion2;

    @BeforeEach
    public void setUp() {
        this.contexto = new ContextoDeMezcla();
    }

    @Test
    public void testMezclarColecciones_TamanosIguales_MayorA5() {
        coleccion1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        coleccion2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayList<String> resultadoEsperado = new ArrayList<>(Arrays.asList("a", "1", "b", "2", "c", "3", "d", "4", "e", "5", "f", "6"));
        assertEquals(resultadoEsperado, contexto.mezclarColecciones(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColecciones_TamanosIguales_MenorOIgualA5() {
        coleccion1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        coleccion2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        assertThrows(IllegalArgumentException.class, () -> contexto.mezclarColecciones(coleccion1, coleccion2));
    }

    @Test
    public void testMezclarColecciones_TamanosDiferentes() {
        coleccion1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));
        coleccion2 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        assertThrows(IllegalArgumentException.class, () -> contexto.mezclarColecciones(coleccion1, coleccion2));
    }
}