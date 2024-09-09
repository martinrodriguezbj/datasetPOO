// Contenido del archivo EnRangoTest.java
package ar.edu.unlp.info.escenario06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnRangoTest_GPT {

    private EnRango enRango;

    @BeforeEach
    public void setUp() {
        // Instanciamos la clase EnRango con un valor inicial arbitrario
        enRango = new EnRango(0);
    }

    @Test
    public void testEstaEnRangoMenor() {
        enRango.setValor(49); // Valor de borde inmediato inferior
        assertFalse(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoInicio() {
        enRango.setValor(50); // Valor de borde inicio de rango
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoMedio() {
        enRango.setValor(75); // Valor en el medio del rango
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoFin() {
        enRango.setValor(100); // Valor de borde fin de rango
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRangoMayor() {
        enRango.setValor(101); // Valor de borde inmediato superior
        assertFalse(enRango.estaEnRango());
    }
}