// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaBancariaTest_GPT {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(100.0);
    }

    @Test
    public void testRetirarMontoMenorAlSaldo() {
        // Partición equivalente: monto a retirar es menor al saldo
        // Valor de borde: monto a retirar es 1 unidad menor al saldo
        assertTrue(cuenta.retirar(99.0));
        assertEquals(1.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirarMontoIgualAlSaldo() {
        // Partición equivalente: monto a retirar es igual al saldo
        // Valor de borde: monto a retirar es igual al saldo
        assertTrue(cuenta.retirar(100.0));
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void testRetirarMontoMayorAlSaldo() {
        // Partición equivalente: monto a retirar es mayor al saldo
        // Valor de borde: monto a retirar es 1 unidad mayor al saldo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirar(101.0);
        });

        String expectedMessage = "Fondos insuficientes";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}