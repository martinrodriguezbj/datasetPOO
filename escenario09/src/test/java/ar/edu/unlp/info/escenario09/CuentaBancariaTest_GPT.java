// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest_GPT {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(1000.0, 200.0);
    }

    // Test de partición equivalente donde el costo de mantenimiento es menor que el saldo.
    @Test
    public void cobrarMantenimiento_CostoMenorQueSaldo() {
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(800.0, cuenta.getSaldo());
    }

    // Test de valor de borde donde el costo de mantenimiento es igual al saldo.
    @Test
    public void cobrarMantenimiento_CostoIgualASaldo() {
        cuenta = new CuentaBancaria(200.0, 200.0);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0.0, cuenta.getSaldo());
    }

    // Test de partición equivalente donde el costo de mantenimiento es mayor que el saldo.
    @Test
    public void cobrarMantenimiento_CostoMayorQueSaldo() {
        cuenta = new CuentaBancaria(100.0, 200.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.cobrarMantenimiento();
        });

        String expectedMessage = "Fondos insuficientes";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test de valor de borde donde el saldo es 0.
    @Test
    public void cobrarMantenimiento_SaldoCero() {
        cuenta = new CuentaBancaria(0.0, 200.0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.cobrarMantenimiento();
        });

        String expectedMessage = "Fondos insuficientes";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}