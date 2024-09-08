package ar.edu.unlp.info.escenario10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//El programa simulará una cuenta bancaria que permite inicializar la cuenta y establecer un costo de mantenimiento. 
//La clase contará con un constructor dónde se inicializará con un saldo inicial, y el costo de mantenimiento mensual. 
//Luego contará con un método cobrarMantenimiento, que en caso de que el monto del mantenimiento sea menor o igual al saldo inicial, se devolverá True. 
//Si el monto del mantenimiento es superior al saldo inicial, se devuelve False.

class CuentaBancariaTest_Humano {
	
	private CuentaBancaria cuenta;

	// Configuración inicial: se crea una nueva instancia de CuentaBancaria antes de cada prueba.
	@BeforeEach
    public void setUp() {
    
    }
    
	// Verifica que el método cobrarMantenimiento devuelve true cuando el costo de mantenimiento es igual al saldo.
    @Test
    public void cobrarMantenimientoConSaldoSuficiente() {
        cuenta = new CuentaBancaria(100,100);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0, cuenta.getSaldo());
    }
    
    // Verifica que el método cobrarMantenimiento devuelve false cuando el costo de mantenimiento es mayor que el saldo.
    @Test
    public void cobrarMantenimientoConSaldoInsuficiente() {
    	cuenta = new CuentaBancaria(100,100.01);
        assertFalse(cuenta.cobrarMantenimiento());
        assertEquals(100, cuenta.getSaldo());
    }
}