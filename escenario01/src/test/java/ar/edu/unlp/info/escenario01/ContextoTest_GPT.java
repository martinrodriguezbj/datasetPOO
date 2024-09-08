package ar.edu.unlp.info.escenario01;

// Importar las piezas jUnit necesarias
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Clase de prueba para Contexto
public class ContextoTest_GPT {

    private Contexto contexto;

    // Método que se ejecuta antes de cada prueba
    @BeforeEach
    public void setUp() {
        contexto = new Contexto();
    }

    // Prueba para verificar si un número par es identificado correctamente
    @Test
    public void testEsPar() {
        assertTrue(contexto.EsPar(2)); // 2 es un valor de borde, el número par más pequeño
        assertTrue(contexto.EsPar(4)); // 4 es un número par dentro de la partición de números pares
        assertFalse(contexto.EsPar(1)); // 1 es un número impar dentro de la partición de números impares
    }

    // Prueba para verificar si se lanza una excepción cuando se pasa un número negativo
    @Test
    public void testEsParConNumeroNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contexto.EsPar(-1); // -1 es un valor de borde, el número negativo más cercano a 0
        });

        String expectedMessage = "Número negativo no permitido";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Prueba para verificar si un número impar es identificado correctamente
    @Test
    public void testEsImpar() {
        assertFalse(contexto.EsPar(3)); // 3 es un número impar dentro de la partición de números impares
    }

    // Prueba para verificar si 0 es identificado correctamente como par
    @Test
    public void testCeroEsPar() {
        assertTrue(contexto.EsPar(0)); // 0 es un valor de borde, el número más pequeño posible
    }
}