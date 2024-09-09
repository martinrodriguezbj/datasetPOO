// Contenido del archivo EnRangoTest.java
package ar.edu.unlp.info.escenario05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnRangoTest_GPT {

    private EnRango enRango;

    @BeforeEach
    public void setUp() {
        // No es necesario instanciar el objeto aquí, ya que se instanciará en cada test
    }

    // Test para la partición equivalente de valores menores a 50
    @Test
    public void testValorMenor50() {
        enRango = new EnRango(49);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enRango.estaEnRango();
        });

        String expectedMessage = "El valor no está en el rango";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test para la partición equivalente de valores entre 50 y 100
    @Test
    public void testValorEntre50y100() {
        enRango = new EnRango(75);
        assertTrue(enRango.estaEnRango());
    }

    // Test para la partición equivalente de valores mayores a 100
    @Test
    public void testValorMayor100() {
        enRango = new EnRango(101);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enRango.estaEnRango();
        });

        String expectedMessage = "El valor no está en el rango";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test para los valores de borde
    @Test
    public void testValoresBorde() {
        enRango = new EnRango(50);
        assertTrue(enRango.estaEnRango());

        enRango = new EnRango(100);
        assertTrue(enRango.estaEnRango());

        enRango = new EnRango(49);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enRango.estaEnRango();
        });
        String expectedMessage = "El valor no está en el rango";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

        enRango = new EnRango(101);
        exception = assertThrows(IllegalArgumentException.class, () -> {
            enRango.estaEnRango();
        });
        actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}