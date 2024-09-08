package ar.edu.unlp.info.escenario02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

//El programa recibe una contraseña. Si la longitud de la misma es mayor o igual a 10 devuelve True, sinó False.

public class ContraseñaStrategyTest_Humano {

    private ContraseñaStrategy validadorContraseña;

    // Configuración inicial: crea una instancia de LongitudMinimaStrategy antes de cada test.
    @BeforeEach
    public void setUp() {
    	validadorContraseña = new LongitudMinimaStrategy();
    }
    
    // Verifica si una contraseña con longitud exactamente igual a 10 es válida.
    @Test
    public void testEsValidaConLongitud10() {
    	assertTrue(validadorContraseña.esValida("0123456789"));
    }

    // Verifica si una contraseña con longitud menor a 10 es inválida.
    @Test
    public void testEsValidaConLongitudMenorA10() {
        assertFalse(validadorContraseña.esValida("123456789"));
    }
}
