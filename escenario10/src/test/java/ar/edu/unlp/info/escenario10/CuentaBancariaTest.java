// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        // Se inicializa la cuenta con un saldo de 100 y un costo de mantenimiento de 50
        cuenta = new CuentaBancaria(100, 50);
    }

    @Test
    public void testCobrarMantenimiento_CostoMenorQueSaldo() {
        // Se prueba con un costo de mantenimiento menor que el saldo
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(50, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_CostoIgualQueSaldo() {
        // Se prueba con un costo de mantenimiento igual al saldo
        cuenta = new CuentaBancaria(50, 50);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_CostoMayorQueSaldo() {
        // Se prueba con un costo de mantenimiento mayor que el saldo
        cuenta = new CuentaBancaria(50, 100);
        assertFalse(cuenta.cobrarMantenimiento());
        assertEquals(50, cuenta.getSaldo());
    }
}