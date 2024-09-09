// Contenido del archivo EnRangoTest.java
package ar.edu.unlp.info.escenario05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnRangoTest_GPT {

    private EnRango enRango;

    @BeforeEach
    public void setUp() {
        // No se instancia el objeto aquí porque el valor se establece en cada prueba
    }

    // Test para la partición equivalente donde el valor está en el rango [50,100]
    @Test
    public void testEstaEnRango() {
        enRango = new EnRango(75); // Un valor dentro del rango
        assertTrue(enRango.estaEnRango());
    }

    // Test para la partición equivalente donde el valor es menor que 50
    @Test
    public void testValorMenorQueRango() {
        enRango = new EnRango(49); // Un valor justo fuera del rango por debajo
        assertThrows(IllegalArgumentException.class, () -> enRango.estaEnRango());
    }

    // Test para la partición equivalente donde el valor es mayor que 100
    @Test
    public void testValorMayorQueRango() {
        enRango = new EnRango(101); // Un valor justo fuera del rango por encima
        assertThrows(IllegalArgumentException.class, () -> enRango.estaEnRango());
    }

    // Test para los valores de borde
    @Test
    public void testValoresBorde() {
        enRango = new EnRango(50); // Valor de borde inferior
        assertTrue(enRango.estaEnRango());

        enRango = new EnRango(100); // Valor de borde superior
        assertTrue(enRango.estaEnRango());
    }
}