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
    public void testRetirarMontoMenorSaldo() {
        // Partición equivalente: Monto a retirar es menor que el saldo
        // Valor de borde: Monto justo un poco menor que el saldo
        assertTrue(cuenta.retirar(99.99));
        assertEquals(0.01, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarMontoIgualSaldo() {
        // Partición equivalente: Monto a retirar es igual que el saldo
        // Valor de borde: Monto justo igual al saldo
        assertTrue(cuenta.retirar(100.0));
        assertEquals(0.0, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarMontoMayorSaldo() {
        // Partición equivalente: Monto a retirar es mayor que el saldo
        // Valor de borde: Monto justo un poco mayor que el saldo
        assertFalse(cuenta.retirar(100.01));
        assertEquals(100.0, cuenta.getSaldo(), 0.01);
    }

    @Test
    public void testRetirarMontoNegativo() {
        // Partición equivalente: Monto a retirar es negativo
        // Valor de borde: Monto justo un poco menor que cero
        assertFalse(cuenta.retirar(-0.01));
        assertEquals(100.0, cuenta.getSaldo(), 0.01);
    }
}