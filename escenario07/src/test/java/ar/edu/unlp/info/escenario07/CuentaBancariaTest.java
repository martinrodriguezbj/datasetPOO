// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    private CuentaBancaria cuentaBancaria;

    @BeforeEach
    public void setUp() {
        cuentaBancaria = new CuentaBancaria(1000.0);
    }

    // Test para partición equivalente donde el monto a retirar es menor que el saldo
    @Test
    public void retirarMontoMenorQueSaldo() {
        assertTrue(cuentaBancaria.retirar(500.0));
        assertEquals(500.0, cuentaBancaria.getSaldo());
    }

    // Test para valor de borde donde el monto a retirar es igual al saldo
    @Test
    public void retirarMontoIgualASaldo() {
        assertTrue(cuentaBancaria.retirar(1000.0));
        assertEquals(0.0, cuentaBancaria.getSaldo());
    }

    // Test para partición equivalente donde el monto a retirar es mayor que el saldo
    @Test
    public void retirarMontoMayorQueSaldo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> cuentaBancaria.retirar(1500.0));
        assertEquals("Fondos insuficientes", exception.getMessage());
    }

    // Test para valor de borde donde el monto a retirar es ligeramente mayor que el saldo
    @Test
    public void retirarMontoLigeramenteMayorQueSaldo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> cuentaBancaria.retirar(1000.01));
        assertEquals("Fondos insuficientes", exception.getMessage());
    }
}