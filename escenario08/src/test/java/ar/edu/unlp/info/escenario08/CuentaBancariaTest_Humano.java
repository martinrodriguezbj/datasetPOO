package ar.edu.unlp.info.escenario08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//El programa simulará una cuenta bancaria que permite inicializar la cuenta y realizar retiros. 
//La clase contará con un constructor dónde se inicializará con un saldo inicial. 
//Luego contará con un método que recibirá un parámetro de un monto a retirar. 
//En caso de que el monto a retirar sea menor o igual al saldo inicial, se devolverá True. 
//Si el monto a retirar es superior al saldo inicial, se devuelve False.

class CuentaBancariaTest_Humano {
	
	private CuentaBancaria cuenta;

	// Configuración inicial: crea una instancia de CuentaBancaria con un saldo inicial de 100 antes de cada test.
	@BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(100);
    }

	// Verifica que se puede retirar el saldo total cuando el monto a retirar es igual al saldo.
    @Test
    public void retirarConSaldoSuficiente() {
        assertTrue(cuenta.retirar(100));
        assertEquals(0, cuenta.getSaldo());
    }

    // Verifica que se devuelve false cuando se intenta retirar más de lo disponible en la cuenta.
    @Test
    public void retirarSinSaldoSuficiente() {
        assertFalse(cuenta.retirar(100.01));
        assertEquals(100, cuenta.getSaldo());
    }
}