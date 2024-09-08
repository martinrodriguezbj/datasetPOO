// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        // Se inicializa la cuenta con un saldo de 100.0 y un costo de mantenimiento de 50.0
        cuenta = new CuentaBancaria(100.0, 50.0);
    }

    @Test
    public void testCobrarMantenimiento_SaldoSuficiente() {
        // Partición equivalente: costo de mantenimiento <= saldo
        // Valor de borde: costo de mantenimiento = saldo
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(50.0, cuenta.getSaldo());
    }
    
    @Test
    public void testCobrarMantenimiento_SaldoInsuficiente() {
        // Partición equivalente: costo de mantenimiento > saldo
        // Valor de borde: costo de mantenimiento = saldo + 1
        cuenta = new CuentaBancaria(100.0, 101.0);
        assertFalse(cuenta.cobrarMantenimiento());
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void testCobrarMantenimiento_SaldoExacto() {
        // Valor de borde: costo de mantenimiento = saldo
        cuenta = new CuentaBancaria(50.0, 50.0);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0.0, cuenta.getSaldo());
    }
}