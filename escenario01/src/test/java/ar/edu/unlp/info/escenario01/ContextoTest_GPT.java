// Importando las clases necesarias para los tests
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Clase de test para Contexto
public class ContextoTest_GPT {

    private Contexto contexto;

    @BeforeEach
    public void setUp() {
        contexto = new Contexto();
    }

    @Test
    public void testEsPar() {
        // Testeando con un número par (partición equivalente: números pares)
        assertTrue(contexto.EsPar(2));

        // Testeando con un número impar (partición equivalente: números impares)
        assertFalse(contexto.EsPar(3));

        // Testeando con el valor de borde 0 (considerado par)
        assertTrue(contexto.EsPar(0));
    }

    @Test
    public void testEsParConNumeroNegativo() {
        // Testeando con un número negativo (partición equivalente: números negativos)
        // Se espera una excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            contexto.EsPar(-1);
        });

        String expectedMessage = "Número negativo no permitido";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}