// Contenido del archivo EnRangoTest.java
package ar.edu.unlp.info.escenario06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnRangoTest {

    private EnRango enRango;

    @BeforeEach
    public void setUp(){
        // Inicialización de la instancia de EnRango con un valor por defecto.
        // Este valor se reemplazará en cada test.
        enRango = new EnRango(0);
    }

    @Test
    public void testEstaEnRango_InicioRango(){ 
        // Prueba con valor de borde: inicio del rango (50)
        enRango = new EnRango(50);
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRango_FinRango(){ 
        // Prueba con valor de borde: fin del rango (100)
        enRango = new EnRango(100);
        assertTrue(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRango_FueraRangoInferior(){ 
        // Prueba con valor de borde: fuera del rango inferior (49)
        enRango = new EnRango(49);
        assertFalse(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRango_FueraRangoSuperior(){ 
        // Prueba con valor de borde: fuera del rango superior (101)
        enRango = new EnRango(101);
        assertFalse(enRango.estaEnRango());
    }

    @Test
    public void testEstaEnRango_DentroRango(){ 
        // Prueba con valor dentro del rango (75)
        enRango = new EnRango(75);
        assertTrue(enRango.estaEnRango());
    }
}