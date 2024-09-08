package ar.edu.unlp.info.escenario01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//El programa recibe un número positivo e indica si es par o impar. En caso que el número sea negativo, se lanza una excepción.

public class ValidadorTest_humano {

	private ParidadStrategy validador;

	 // Configuración inicial: crea una instancia de ValidadorDeNumero antes de cada test.
	@BeforeEach
	public void setUp() {
		validador = new ValidadorDeNumero();
	}

	// Verifica si el método esPar retorna true para el número par 0.
	@Test
	public void testEsParConNumeroPar() {
		assertTrue(validador.esPar(0));
	}

	// Verifica si el método esPar retorna false para el número impar 1.
	@Test
	public void testEsParConNumeroImpar() {
		assertFalse(validador.esPar(1));
	}

	// Verifica que se lanza una excepción cuando se pasa un número negativo.
	@Test
	public void testEsParConNumeroNegativo() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			validador.esPar(-1);
		});
		assertEquals("Número negativo no permitido", exception.getMessage());
	}
}