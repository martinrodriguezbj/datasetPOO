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
El programa recibe un número positivo e indica si es par o impar. En caso que el número sea negativo, se lanza una excepción.

Implementación:

"""

// Contenido del archivo Contexto.java
package ar.edu.unlp.info.escenario01;

public class Contexto {
        private ParidadStrategy strategy;

        public Contexto() {
                this.strategy = new ValidadorDeNumero();
        }

        public Boolean EsPar(int numero) {
                return this.strategy.esPar(numero);
        }
}
// Contenido del archivo ParidadStrategy.java
package ar.edu.unlp.info.escenario01;

public interface ParidadStrategy {
        Boolean esPar(int numero);
}
// Contenido del archivo ValidadorDeNumero.java
package ar.edu.unlp.info.escenario01;

public class ValidadorDeNumero implements ParidadStrategy {

        @Override
        public Boolean esPar(int numero) {
                if (numero < 0) {
                        throw new IllegalArgumentException("Número negativo no permitido");
                }
                return numero % 2 == 0;
        }
}

"""