// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest_GPT {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(1000.0);
    }

    // Test para partición equivalente donde el monto a retirar es menor que el saldo
    @Test
    public void retirarMontoMenorQueSaldo() {
        assertTrue(cuenta.retirar(500.0));
        assertEquals(500.0, cuenta.getSaldo());
    }

    // Test para partición equivalente donde el monto a retirar es igual al saldo
    @Test
    public void retirarMontoIgualQueSaldo() {
        assertTrue(cuenta.retirar(1000.0));
        assertEquals(0.0, cuenta.getSaldo());
    }

    // Test para partición equivalente donde el monto a retirar es mayor que el saldo
    @Test
    public void retirarMontoMayorQueSaldo() {
        assertFalse(cuenta.retirar(1500.0));
        assertEquals(1000.0, cuenta.getSaldo());
    }

    // Test para valor de borde donde el monto a retirar es ligeramente menor que el saldo
    @Test
    public void retirarMontoJustoMenorQueSaldo() {
        assertTrue(cuenta.retirar(999.99));
        assertEquals(0.01, cuenta.getSaldo());
    }

    // Test para valor de borde donde el monto a retirar es ligeramente mayor que el saldo
    @Test
    public void retirarMontoJustoMayorQueSaldo() {
        assertFalse(cuenta.retirar(1000.01));
        assertEquals(1000.0, cuenta.getSaldo());
    }
}