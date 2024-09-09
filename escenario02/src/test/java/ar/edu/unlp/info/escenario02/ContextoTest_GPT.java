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
    public void testContraseñaMenorADiez() {
        // Partición equivalente: longitud de contraseña < 10
        // Valor de borde: longitud de contraseña = 9
        String contraseña = "123456789";
        assertFalse(this.contexto.EsValida(contraseña));
    }

    @Test
    public void testContraseñaIgualADiez() {
        // Partición equivalente: longitud de contraseña >= 10
        // Valor de borde: longitud de contraseña = 10
        String contraseña = "1234567890";
        assertTrue(this.contexto.EsValida(contraseña));
    }

    @Test
    public void testContraseñaMayorADiez() {
        // Partición equivalente: longitud de contraseña >= 10
        // Valor de borde: longitud de contraseña = 11
        String contraseña = "12345678901";
        assertTrue(this.contexto.EsValida(contraseña));
    }
}