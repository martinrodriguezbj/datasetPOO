Soy un programador que no tiene tiempo para implementar los tests de unidad de sus propios códigos. Quiero testear mi código para identificar posibles errores. Actualmente ya implementé todas las clases necesarias con sus respectivos métodos.
Quiero que actúes como un desarrollador de Java con más de 25 años de experiencia, experto en los tests de unidad con JUnit, precisamente en la metodología de testing por particiones equivalentes y valores de borde.
Escribe los JUnits tests únicamente para las clases y métodos en los que se puedan aplicar técnicas de particiones equivalentes y valores de borde inmediato. Todo debe estar claramente documentado.
Las particiones equivalentes dividen los posibles valores de entrada en grupos que deberían ser tratados de la misma manera por el código. Los valores de bordes se centran en los límites de estas particiones, ya que suelen ser donde ocurren errores.
Ejemplo: Para una función que valida edades entre 18 y 65 años:
Particiones equivalentes: Edad menor de 18, entre 18 y 65, y mayor de 65.
Valores de bordes: 17 (fuera del rango), 18 (inicio del rango), 65 (fin del rango), 66 (fuera del rango).

La estructura que deben seguir tus clases de tests es la siguiente:

"""

#aca importas las piezas jUnit que necesites

public class nombreClaseTest_GPT{

#acá tenes que definir los objetos que necesiten los tests

@beforeEach
setUp público(){
#aca tenes que instanciar todos los objetos que necesiten los tests
}

@Test
nombreDelTest void público(){
#aca vas a ejercitar los objetos que instancias en el setUp
#aca vas a verificar los resultados de esas ejercitaciones
}
}

"""

Especificacion:
El programa simulará una cuenta bancaria que permite inicializar la cuenta y realizar retiros.
La clase contará con un constructor dónde se inicializará con un saldo inicial.
Luego contará con un método que recibirá un parámetro de un monto a retirar.
En caso de que el monto a retirar sea menor o igual al saldo inicial, se devolverá True. Si el monto a retirar es superior al saldo inicial, se lanzará una excepción.

Implementación:

"""

// Contenido del archivo CuentaBancaria.java
package ar.edu.unlp.info.escenario07;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public boolean retirar(double monto) {
        if (monto > this.saldo) {
            throw new IllegalArgumentException("Fondos insuficientes");
        } else {
            this.saldo -= monto;
            return true;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
}

"""