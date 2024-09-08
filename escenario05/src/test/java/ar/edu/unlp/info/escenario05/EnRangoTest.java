// Contenido del archivo EnRangoTest.java
package ar.edu.unlp.info.escenario05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnRangoTest {

    private EnRango enRango;

    @BeforeEach
    public void setUp() {
        // Instanciamos el objeto a testear en el setUp para que sea fresco en cada test
        enRango = new EnRango(0);
    }

    @Test
    public void testEstaEnRango_ValorMenor(){ 
        enRango = new EnRango(49);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enRango.estaEnRango();
        });
        assertEquals("El valor no está en el rango", exception.getMessage());
    } 

    @Test
    public void testEstaEnRango_ValorInicioRango(){ 
        enRango = new EnRango(50);
        assertTrue(enRango.estaEnRango());
    } 

    @Test
    public void testEstaEnRango_ValorFinRango(){ 
        enRango = new EnRango(100);
        assertTrue(enRango.estaEnRango());
    } 

    @Test
    public void testEstaEnRango_ValorMayor(){ 
        enRango = new EnRango(101);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            enRango.estaEnRango();
        });
        assertEquals("El valor no está en el rango", exception.getMessage());
    } 
}