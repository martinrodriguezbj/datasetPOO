// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(100.0);
    }

    @Test
    public void retirarMontoMenorAlSaldo() {
        assertTrue(cuenta.retirar(50.0));
        assertEquals(50.0, cuenta.getSaldo());
    }

    @Test
    public void retirarMontoIgualAlSaldo() {
        assertTrue(cuenta.retirar(100.0));
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    public void retirarMontoMayorAlSaldo() {
        assertFalse(cuenta.retirar(150.0));
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    public void retirarMontoJustoMayorAlSaldo() {
        assertFalse(cuenta.retirar(100.01));
        assertEquals(100.0, cuenta.getSaldo());
    }
}