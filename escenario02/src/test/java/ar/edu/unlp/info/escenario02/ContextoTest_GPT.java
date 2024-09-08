package ar.edu.unlp.info.escenario02;

// Importar las clases necesarias para las pruebas
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unlp.info.escenario02.*;

public class ContextoTest_GPT {

    private Contexto contexto;

    @BeforeEach
    public void setUp() {
        // Instanciamos la clase a probar
        this.contexto = new Contexto();
    }

    @Test
    public void testContraseñaMenorADiez() {
        // Ejercitamos el método con un valor de borde
        assertFalse(contexto.EsValida("123456789")); // 9 caracteres, justo antes del límite
        // Ejercitamos el método con una partición equivalente
        assertFalse(contexto.EsValida("12345678")); // 8 caracteres, dentro de la partición
    }

    @Test
    public void testContraseñaExactamenteDiez() {
        // Ejercitamos el método con un valor de borde
        assertTrue(contexto.EsValida("1234567890")); // 10 caracteres, en el límite
    }

    @Test
    public void testContraseñaMayorADiez() {
        // Ejercitamos el método con un valor de borde
        assertTrue(contexto.EsValida("12345678901")); // 11 caracteres, justo después del límite
        // Ejercitamos el método con una partición equivalente
        assertTrue(contexto.EsValida("12345678901234567890")); // 20 caracteres, dentro de la partición
    }
}