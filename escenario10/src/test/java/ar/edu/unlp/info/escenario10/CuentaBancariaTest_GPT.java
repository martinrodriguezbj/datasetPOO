// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaBancariaTest_GPT {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(100.0, 50.0);
    }

    @Test
    public void testCobrarMantenimiento_CostoMenorQueSaldo() {
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(50.0, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_CostoIgualQueSaldo() {
        cuenta = new CuentaBancaria(50.0, 50.0);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_CostoMayorQueSaldo() {
        cuenta = new CuentaBancaria(50.0, 100.0);
        assertFalse(cuenta.cobrarMantenimiento());
        assertEquals(50.0, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_CostoJustoUnPocoMenorQueSaldo() {
        cuenta = new CuentaBancaria(50.0, 49.99);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0.01, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_CostoJustoUnPocoMayorQueSaldo() {
        cuenta = new CuentaBancaria(50.0, 50.01);
        assertFalse(cuenta.cobrarMantenimiento());
        assertEquals(50.0, cuenta.getSaldo());
    }
}