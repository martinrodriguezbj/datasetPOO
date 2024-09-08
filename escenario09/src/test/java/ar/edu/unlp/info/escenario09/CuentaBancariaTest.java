package ar.edu.unlp.info.escenario09;

// Contenido del archivo CuentaBancariaTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaBancariaTest {

    private CuentaBancaria cuenta;
    
    // Este método se ejecutará antes de cada test para inicializar la cuenta con valores predeterminados.
    @BeforeEach
    public void setUp() {
        cuenta = new CuentaBancaria(1000.0, 100.0);
    }
    
    // Test de partición equivalente donde el costo de mantenimiento es menor que el saldo.
    @Test
    public void cobrarMantenimiento_CostoMenorQueSaldo() {
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(900.0, cuenta.getSaldo(), 0.01);
    }
    
    // Test de partición equivalente donde el costo de mantenimiento es igual al saldo.
    @Test
    public void cobrarMantenimiento_CostoIgualASaldo() {
        cuenta = new CuentaBancaria(100.0, 100.0);
        assertTrue(cuenta.cobrarMantenimiento());
        assertEquals(0.0, cuenta.getSaldo(), 0.01);
    }
    
    // Test de valor de borde donde el costo de mantenimiento es justo un poco mayor que el saldo.
    @Test
    public void cobrarMantenimiento_CostoJustoMayorQueSaldo() {
        cuenta = new CuentaBancaria(100.0, 100.01);
        assertThrows(IllegalArgumentException.class, () -> cuenta.cobrarMantenimiento());
    }
    
    // Test de valor de borde donde el costo de mantenimiento es mucho mayor que el saldo.
    @Test
    public void cobrarMantenimiento_CostoMuchoMayorQueSaldo() {
        cuenta = new CuentaBancaria(100.0, 1000.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.cobrarMantenimiento());
    }
}