// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest_GPT {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp() {
        // Inicializamos la cuenta con un saldo de 1000
        cuenta = new CuentaBancaria(1000);
    }

    @Test
    public void testRetirarMontoMenorOIgualAlSaldo() {
        // Partición equivalente: monto a retirar es menor o igual al saldo
        // Valor de borde: monto a retirar es igual al saldo
        assertTrue(cuenta.retirar(1000));
        assertEquals(0, cuenta.getSaldo());
    }

    @Test
    public void testRetirarMontoMenorAlSaldo() {
        // Partición equivalente: monto a retirar es menor al saldo
        // Valor de borde: monto a retirar es el saldo - 1
        assertTrue(cuenta.retirar(999));
        assertEquals(1, cuenta.getSaldo());
    }

    @Test
    public void testRetirarMontoMayorAlSaldo() {
        // Partición equivalente: monto a retirar es mayor al saldo
        // Valor de borde: monto a retirar es el saldo + 1
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cuenta.retirar(1001);
        });

        String expectedMessage = "Fondos insuficientes";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}