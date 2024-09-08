// Contenido del archivo EnRangoTest.java
package ar.edu.unlp.info.escenario06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnRangoTest {

    private EnRango enRango;

    @BeforeEach
    public void setUp() {
        // No necesitamos instanciar nada aquí porque lo haremos en cada test
    }

    @Test
    public void testEstaEnRangoConValorMenor() {
        enRango = new EnRango(49); // valor de borde
        assertFalse(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoConValorInicio() {
        enRango = new EnRango(50); // valor de borde
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoConValorMedio() {
        enRango = new EnRango(75); // valor dentro del rango
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoConValorFin() {
        enRango = new EnRango(100); // valor de borde
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoConValorMayor() {
        enRango = new EnRango(101); // valor de borde
        assertFalse(enRango.estaEnRango());
    }
}