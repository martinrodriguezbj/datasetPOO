// Contenido del archivo ContextoTest.java
package ar.edu.unlp.info.escenario01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContextoTest_GPT {

    private Contexto contexto;

    @BeforeEach
    public void setUp() {
        this.contexto = new Contexto();
    }

    @Test
    public void testEsParConNumeroPar() {
        // Partición equivalente: número par
        // Valor de borde: 2 (número par más pequeño)
        assertTrue(contexto.EsPar(2));
    }

    @Test
    public void testEsParConNumeroImpar() {
        // Partición equivalente: número impar
        // Valor de borde: 1 (número impar más pequeño)
        assertFalse(contexto.EsPar(1));
    }

    @Test
    public void testEsParConNumeroNegativo() {
        // Partición equivalente: número negativo
        // Valor de borde: -1 (número negativo más cercano a la partición válida)
        assertThrows(IllegalArgumentException.class, () -> contexto.EsPar(-1));
    }

    @Test
    public void testEsParConCero() {
        // Valor de borde: 0 (límite entre números positivos y negativos)
        assertTrue(contexto.EsPar(0));
    }
}