// Contenido del archivo CuentaBancariaTest.java
package ar.edu.unlp.info.escenario09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest_GPT {

    private CuentaBancaria cuenta;

    @BeforeEach
    public void setUp(){
        cuenta = new CuentaBancaria(100, 50); // Inicializamos la cuenta con un saldo de 100 y un costo de mantenimiento de 50
    }

    @Test
    public void cobrarMantenimiento_CostoMenorQueSaldo_CobraMantenimiento(){
        // Partición equivalente: cuando el costo de mantenimiento es menor que el saldo
        // Valor de borde: justo un valor menor que el saldo
        assertTrue(cuenta.cobrarMantenimiento()); // Debería ser capaz de cobrar el mantenimiento
        assertEquals(50, cuenta.getSaldo()); // El saldo debería ser 50 después de cobrar el mantenimiento
    }

    @Test
    public void cobrarMantenimiento_CostoIgualQueSaldo_CobraMantenimiento(){
        // Partición equivalente: cuando el costo de mantenimiento es igual al saldo
        // Valor de borde: justo el mismo valor que el saldo
        cuenta = new CuentaBancaria(50, 50); // Inicializamos la cuenta con un saldo de 50 y un costo de mantenimiento de 50
        assertTrue(cuenta.cobrarMantenimiento()); // Debería ser capaz de cobrar el mantenimiento
        assertEquals(0, cuenta.getSaldo()); // El saldo debería ser 0 después de cobrar el mantenimiento
    }

    @Test
    public void cobrarMantenimiento_CostoMayorQueSaldo_LanzaExcepcion(){
        // Partición equivalente: cuando el costo de mantenimiento es mayor que el saldo
        // Valor de borde: justo un valor mayor que el saldo
        cuenta = new CuentaBancaria(50, 100); // Inicializamos la cuenta con un saldo de 50 y un costo de mantenimiento de 100
        Exception exception = assertThrows(IllegalArgumentException.class, () -> cuenta.cobrarMantenimiento()); // Debería lanzar una excepción
        assertEquals("Fondos insuficientes", exception.getMessage()); // El mensaje de la excepción debería ser "Fondos insuficientes"
    }
}