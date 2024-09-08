package ar.edu.unlp.info.escenario09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//El programa simulará una cuenta bancaria que permite inicializarla y establecer un costo de mantenimiento. 
//La clase contará con un constructor dónde se inicializará con un saldo inicial, y el costo de mantenimiento mensual. 
//Luego contará con un método cobrarMantenimiento. 
//En caso de que el costo de mantenimiento sea mayor que el saldo inicial, entonces se produce una excepción.

class CuentaBancariaTest_Humano {
	
	private CuentaBancaria cuenta;

	// Configuración inicial: se inicializa la cuenta bancaria con un saldo inicial y un costo de mantenimiento antes de cada prueba.
	@BeforeEach
    public void setUp() {
    
    }
	
	// Verifica que se puede cobrar el mantenimiento cuando el costo es igual al saldo.
    @Test
    public void cobrarMantenimientoConSaldoSuficiente() {
        cuenta = new CuentaBancaria(100,100);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0, cuenta.getSaldo());
    }
    
    // Verifica que se lanza una excepción cuando el costo de mantenimiento es mayor que el saldo.
    @Test
    public void cobrarMantenimientoConSaldoInsuficiente() {
    	cuenta = new CuentaBancaria(100,100.01);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> cuenta.cobrarMantenimiento());
        assertEquals("Fondos insuficientes", exception.getMessage());
        assertEquals(100, cuenta.getSaldo());
    }
    
}