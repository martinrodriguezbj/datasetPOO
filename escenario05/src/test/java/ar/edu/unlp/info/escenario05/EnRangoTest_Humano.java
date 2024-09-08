package ar.edu.unlp.info.escenario05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//El programa devuelve True si su variable de instancia “valor” está en el rango [50,100], en caso contrario lanza una excepción.

class EnRangoTest_Humano {
	
	private EnRango enRango;

	// Configuración inicial: No es necesario en este caso, ya que el objeto EnRango se inicializa en cada prueba.
	@BeforeEach
    public void setUp() {
	
    }
    
	// Verifica que se lanza una excepción si el valor está por debajo del rango inferior.
	@Test
	public void noEstaEnRangoInferior() {
		enRango = new EnRango(49);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			enRango.estaEnRango();
		});
		assertEquals("El valor no está en el rango", exception.getMessage());
	}

	// Verifica que se retorna true si el valor está justo en el límite inferior del rango.
	@Test
	public void estaEnRangoInferior(){
		enRango = new EnRango(50);
		assertTrue(enRango.estaEnRango());
	}

	// Verifica que se retorna true si el valor está justo en el límite superior del rango.
	@Test
	public void estaEnRangoSuperior(){
		enRango = new EnRango(100);
		assertTrue(enRango.estaEnRango());
	}

	// Verifica que se lanza una excepción si el valor está por encima del rango superior.
	@Test
	public void noEstaEnRangoSuperior(){
		enRango = new EnRango(101);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			enRango.estaEnRango();
		});
		assertEquals("El valor no está en el rango", exception.getMessage());
	}
}