// Contenido del archivo ContextoTest.java
package ar.edu.unlp.info.escenario02;

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
    public void testContraseñaMenorDeDiez() {
        // Partición equivalente: longitud de contraseña menor a 10
        // Valor de borde: 9
        assertFalse(this.contexto.EsValida("123456789"));
    }

    @Test
    public void testContraseñaIgualADiez() {
        // Partición equivalente: longitud de contraseña igual a 10
        // Valor de borde: 10
        assertTrue(this.contexto.EsValida("1234567890"));
    }

    @Test
    public void testContraseñaMayorDeDiez() {
        // Partición equivalente: longitud de contraseña mayor a 10
        // Valor de borde: 11
        assertTrue(this.contexto.EsValida("12345678901"));
    }
}