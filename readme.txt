Este repositorio cuenta con:
-Un conjunto de artefactos de software (especificaciones e implementaciones) de referencia, representativo de situaciones variadas en las que proveer tests.
-Un conjunto de tests de referencia diseñados y programados por desarrolladores con formación adecuada, teniendo en cuenta criterios específicos de valores de borde y particiones de equivalencia, para el conjunto de artefactos de referencia.
-La selección de un prompt para la generación automática de tests, para el conjunto de artefactos de referencia.

Todas las ramas del repositorio comparten lo siguiente:

En la carpeta raíz se encuentran dos archivos clave: el promptTemplate, que es la plantilla predefinida que se utiliza para generar las solicitudes a GPT, y el runTest.py, que es el script encargado de automatizar dichas solicitudes.

Dentro de cada escenario se encuentra la especificación propia del escenario, junto con el prompt ya instanciado con la especificación e implementación correspondientes.

Existen dos tipos de ramas en el repositorio: la rama "main" y las ramas branch[numero].

En la rama "main" se incluye el conjunto completo de especificaciones e implementaciones, junto con los tests diseñados y programados manualmente por desarrolladores.

Mientras que cada branch[numero], además de contener lo que está presente en la rama main, incluye una ejecución del script runTest.py. Este script, para cada uno de los escenarios, instancia el promptTemplate con la especificación e implementación correspondientes. El prompt generado es enviado a la API de GPT-4, que devuelve los tests generados. Estos tests se guardan en la carpeta de tests del escenario bajo el nombre nombreDeClaseTest_GPT.java.

Docuentación de cada barrida:

Primer barrida | brach01

Escenario01

Descripción: En este escenario se realizan pruebas unitarias para el método EsPar() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintos tipos de números: pares, impares, negativos y el caso especial del cero.

Estrategia de testing:
-Se utilizan particiones equivalentes para clasificar los números en pares, impares y negativos.
-Además, se aplican valores de borde inmediatos, como el uso del 2 (número par más pequeño), el 1 (número impar más pequeño), y el 0 (borde entre positivos y negativos).

Pruebas realizadas:
-Verificación de que el número 2 (valor de borde) es par.
-Verificación de que el número 1 (valor de borde) es impar.
-Verificacion de que el número 4 (numero dentro de la partición par) es par
-Lanzamiento de excepción para el número negativo -1 (valor de borde inmediato).
-Verificación de que el 0 es par (borde entre positivos y negativos).

Si bien se detectaron correctamente las particiones equivalentes, existe una incosistencia con los valores de borde. Dentro del caso de prueba TestEsPar() dice que el 2 es el numero par más pequeño, sin embargo ese número debería ser el 0, el cual posteriormente lo termina probando en el caso de prueba "testCeroEsPar".

Escenario02

Descripción: En este escenario se realizan pruebas unitarias para el método esValida() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas longitudes de contraseñas: 9, 10 y 11.

-Se utilizan particiones equivalentes para clasificar las contraseñas como menores, iguales o mayores a 10 caracteres.
-Las cadenas se pasan directamente como literales en las pruebas.

Pruebas: Se evalúan tres casos:
-Contraseñas menores a 10 caracteres (9 caracteres como valor de borde).
-Contraseñas exactamente de 10 caracteres (valor de borde).
-Contraseñas mayores a 10 caracteres (11 caracteres como valor de borde).

Escenario03

Descripción: En este escenario se realizan pruebas unitarias para el método mezclarColecciones() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas combinaciones de colecciones: de diferente tamaño, tamaño menor/igual a 5, tamaño mayor a 5.

Se utilizan particiones equivalentes para clasificar las colecciones como menores o mayores a 5 elementos, y para colecciones de diferentes tamaños.

Prueba de colecciones con tamaños diferentes:
-Se espera una excepción (IllegalArgumentException) cuando las colecciones tienen tamaños diferentes, lo cual está alineado con las reglas de la lógica del código.

Prueba de colecciones con tamaño menor o igual a 5:
-Aquí también se espera una excepción cuando ambas colecciones tienen un tamaño de 5 o menos.

Prueba de colecciones con tamaño mayor a 5:
-Se verifica que, cuando ambas colecciones tienen un tamaño mayor a 5 y son iguales, la mezcla se realiza correctamente.

Escenario04

Descripción: En este escenario se realizan pruebas unitarias para el método mezclar() de la clase EstrategiaDeMezclaIntercalar. Las pruebas verifican el comportamiento del método para distintas combinaciones de colecciones: de diferente tamaño, tamaño menor/igual a 5, tamaño mayor a 5.

Se utilizan particiones equivalentes para clasificar las colecciones como menores o mayores a 5 elementos, y para colecciones de diferentes tamaños.

testMezclarColeccionesMenorOIgualA5: Verifica que, cuando ambas colecciones tienen exactamente 5 elementos, el resultado es ["-1"], lo cual indica que la condición de tamaño mayor a 5 no se cumple.

testMezclarColeccionesMayorA5DiferenteTamano: Verifica que, cuando las colecciones tienen tamaños diferentes pero una de ellas tiene más de 5 elementos, el resultado es ["-1"].

testMezclarColeccionesMayorA5MismoTamano: Verifica que, cuando ambas colecciones tienen más de 5 elementos y tienen el mismo tamaño, la mezcla intercala los elementos de ambas colecciones correctamente.

Escenario05

Descripción: En este escenario se realizan pruebas unitarias para el método estaEnRango() de la clase enRango. Las pruebas verifican el comportamiento del método para distintos valores.

Se utilizan particiones equivalentes para clasificar los rangos: menor a 50, entre 50 y 100, y mayor 100.

testValorMenor50: Se prueba con el valor de borde inmediatamente inferior, se espera una excepción por estar fuera de rango.

testValorEntre50y100: Se prueba con el valor 75, el cual es representativo de la partición equivalente por encontrarse a mitad de rango.

testValorMayor100: Se prueba con el valor de borde inmediatamente superior, se espera una excepción por estar fuera de rango.

testValoresBorde: Se prueba con todos los valores de borde (49,50,100,101) agrupados en un mismo método. Existe cierta redundancia ya que dos de estos fueron probados anteriormente en otros tests.

Escenario06

Descripción: En este escenario se realizan pruebas unitarias para el método estaEnRango() de la clase enRango. Las pruebas verifican el comportamiento del método para distintos valores.

Se utilizan particiones equivalentes para clasificar los rangos: menor a 50, entre 50 y 100, y mayor 100.

testEstaEnRangoMenor: Se prueba con el valor de borde inmediatamente inferior (49), se espera que esté fuera de rango.

testEstaEnRangoInicio: Se prueba con el valor de borde inmediato inferior que está dentro del rango.

testEstaEnRangoMedio: Se prueba con el valor 75, el cual es representativo de la partición equivalente por encontrarse a mitad de rango.

testEstaEnRangoFin: Se prueba con el valor 100, el cual es el último valor dentro del rango.

testEstaEnRangoMayor: Se prueba con el valor de borde inmediato superior (101), se espera que este fuera de rango.

Si bien las particiones equivalentes y los valores de borde fueron correctamente detectados, se hizo uso de un método "setValor" el cuál no existe, por lo tanto todos los test se rompen.

Escenario07

Descripción: los tests están diseñados para evaluar el comportamiento del método retirar en diferentes situaciones usando particiones equivalentes y valores de borde inmediatos. Se inicializa una cuenta bancaria con un saldo de 1000 y se prueban tres casos principales

Retirar monto igual al saldo (1000): Esto representa un valor de borde y una partición equivalente donde el monto es igual al saldo. Se espera que la operación sea exitosa, y el saldo resultante sea 0.

Retirar monto menor al saldo (999): Se prueba un caso donde el monto retirado es menor al saldo disponible (saldo - 1), lo que también es un valor de borde. La cuenta debe aceptar la operación, dejando un saldo restante de 1.

Retirar monto mayor al saldo (1001): Este test cubre el caso donde el monto solicitado excede el saldo (saldo + 1). Se espera que se lance una excepción, con el mensaje "Fondos insuficientes".

Escenario08

Descripción: los tests están diseñados para evaluar el comportamiento del método retirar en diferentes situaciones usando particiones equivalentes y valores de borde inmediatos. Se inicializa una cuenta bancaria con un saldo de 100 y se prueban cuatro casos principales

retirarMontoMenorAlSaldo: Esto representa un valor representativo de la partición equivalente que está dentro del rango de lo que se puede retirar.

retirarMontoIgualAlSaldo: Esto representa un valor de borde y una partición equivalente donde el monto es igual al saldo. Se espera que la operación sea exitosa, y el saldo resultante sea 0.

retirarMontoMayorAlSaldo: Esto representa un valor representativo de la partición equivalente que está fuera del rango de lo que se puede retirar.

retirarMontoJustoMayorAlSaldo: Este test cubre el caso donde el monto solicitado excede el saldo (saldo + 0.01). Se espera que no se realice la extracción, y el saldo se mantenga igual.

Escenario09

Descripción: En el primer escenario de tests, se utiliza una clase CuentaBancaria inicializada con un saldo de 100 y un costo de mantenimiento de 50, que solo se utilizará en el primer caso de prueba, el resto tendrán instanciadas sus propias configuraciones en sus métodos. Se aplicaron diferentes casos de prueba para verificar el comportamiento de la clase al intentar cobrar el mantenimiento. Los tests se centraron en cubrir particiones equivalentes y valores de borde relacionados con el saldo y el costo de mantenimiento.

Test de partición equivalente: Se verifica cuando el costo de mantenimiento es menor que el saldo, comprobando que la operación de cobro se ejecute correctamente y el saldo se actualice en consecuencia. Como costo de mantenimiento se utiliza un valor a mitad del rango de la particion equivalente correspondiente al saldo, por lo tanto no se testean valores de borde.

Test de valor de borde: Se analiza cuando el costo de mantenimiento es igual al saldo, asegurándose de que la cuenta quede con un saldo cero.

Test de excepción: Cuando el costo de mantenimiento es mayor que el saldo, se valida que se lance una excepción con el mensaje "Fondos insuficientes". Como costo de mantenimiento no se utiliza un valor de borde dentro de la partición fuera del saldo disponible.

Escenario10

Descripcion: Se crea una cuenta bancaria con un saldo de 100.0 y un costo de mantenimiento de 50.0, la cuál se utilizará para el primer caso de prueba. El resto de configuraciones se instanciará propiamente en cada caso.

Costo menor que el saldo: El costo de mantenimiento es menor que el saldo, lo cual permite cobrar el mantenimiento y deja un saldo de 50.0.

Costo igual que el saldo: El saldo es exactamente igual al costo de mantenimiento, permitiendo cobrar el mantenimiento y dejando el saldo en 0.

Costo mayor que el saldo: El costo de mantenimiento es mayor que el saldo, por lo que no se puede cobrar el mantenimiento, y el saldo permanece igual.

Costo justo un poco menor que el saldo: El costo de mantenimiento es ligeramente menor que el saldo, lo que permite cobrar el mantenimiento y deja un saldo positivo muy pequeño. El assertEquals fallará ya que no se utiliza un delta para fijar una tolerancia en la imprecision de decimales.

Costo justo un poco mayor que el saldo: El costo de mantenimiento es ligeramente mayor que el saldo, por lo que no se puede cobrar el mantenimiento.
--------------------------------------------------------------------------------

Segunda barrida | branch02

Escenario01

Descripción: En este escenario se emplea un enfoque similar al de la barrida 1, pero se enfatiza más la clasificación de los números según sus particiones equivalentes. Los valores de borde son casi los mismos, pero el código es más conciso y está centrado en validar un solo valor por prueba.

Estrategia de testing:
Se aplican particiones equivalentes (números pares, impares, y negativos) y valores de borde como el 2, 1, 0, y -1. Cada prueba se enfoca en un solo aspecto o caso específico.

Pruebas realizadas:
-Verificación del número 2 como par.
-Verificación del número 1 como impar.
-Excepción para el número negativo -1.
-Verificación de que el 0 es par.

Escenario02

Descripción: En este escenario se realizan pruebas unitarias para el método esValida() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas longitudes de contraseñas: 9, 10 y 11.

-Se utilizan particiones equivalentes para clasificar las contraseñas como menores, iguales o mayores a 10 caracteres.
-Las contraseñas se almacenan en variables antes de ser evaluadas, lo que añade claridad a la prueba.

Pruebas: Se evalúan tres casos:
-Contraseñas menores a 10 caracteres (9 caracteres como valor de borde).
-Contraseñas exactamente de 10 caracteres (valor de borde).
-Contraseñas mayores a 10 caracteres (11 caracteres como valor de borde).

Escenario03

Descripción: En este escenario se realizan pruebas unitarias para el método mezclarColecciones() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas combinaciones de colecciones: de diferente tamaño, tamaño menor/igual a 5, tamaño mayor a 5.

Se utilizan particiones equivalentes para clasificar las colecciones como menores o mayores a 5 elementos (el nombre de este caso no es muy intuitivo), y para colecciones de diferentes tamaños. 

Prueba de mezcla de colecciones con el mismo tamaño (mayor a 5):
-Se verifica que la mezcla funciona correctamente cuando las colecciones tienen tamaños iguales y mayor a 5.

Prueba de colecciones con diferentes tamaños:
-Nuevamente, se espera una excepción cuando los tamaños son diferentes.

Prueba de colecciones con tamaño menor a 6:
-Se espera una excepción si ambas colecciones tienen un tamaño menor a 6.

Escenario04

Descripción: En este escenario se realizan pruebas unitarias para el método mezclar() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas combinaciones de colecciones: de diferente tamaño, tamaño menor/igual a 5, tamaño mayor a 5.

Se utilizan particiones equivalentes para clasificar las colecciones como menores o mayores a 5 elementos, y para colecciones de diferentes tamaños.

Esta barrida utiliza un contexto adicional en comparación a barrida01, ContextoDeMezcla, que establece la estrategia antes de mezclar. Las pruebas se centran en los mismos tres casos, pero con un cambio en cómo se llama al método (a través del contexto):

testMezclarColeccionesTamanosDiferentes: Similar al segundo test de la Barrida01, verifica que si las colecciones tienen tamaños diferentes, el resultado es ["-1"].

testMezclarColeccionesTamanosIgualesMenorASeis: Similar al primer test de la Barrida01, verifica que si ambas colecciones tienen menos de 6 elementos, el resultado es ["-1"].

testMezclarColeccionesTamanosIgualesMayorASeis: Similar al tercer test de la Barrida01, verifica que cuando ambas colecciones tienen más de 5 elementos y el mismo tamaño, los elementos se mezclan correctamente.

Escenario05

Descripción: En este escenario se realizan pruebas unitarias para el método estaEnRango() de la clase enRango. Las pruebas verifican el comportamiento del método para distintos valores.

Se utilizan particiones equivalentes para clasificar los rangos: menor a 50, entre 50 y 100, y mayor 100.

testEstaEnRango_ValorMenor: Se prueba con el valor de borde inferior (49) fuera de rango, se espera una excepción por estar fuera de rango.

testEstaEnRango_ValorInicioRango: Se prueba con el valor de borde inferir(50) dentro del rango.

testEstaEnRango_ValorFinRango: Se prueba con el valor de borde superior(100) dentro del rango.

testEstaEnRango_ValorMayor: Se prueba con el valor de borde superior(101) fuera de rango, se espera una excepción por estar fuera de rango.

Escenario06

Descripción: En este escenario se realizan pruebas unitarias para el método estaEnRango() de la clase enRango. Las pruebas verifican el comportamiento del método para distintos valores.

Se utilizan particiones equivalentes para clasificar los rangos: menor a 50, entre 50 y 100, y mayor 100.

testEstaEnRango_FueraRangoInferior: Se prueba con el valor de borde inmediatamente inferior (49), se espera que esté fuera de rango.

testEstaEnRango_InicioRango: Se prueba con el valor de borde inmediato inferior (50) que está dentro del rango.

testEstaEnRango_DentroRango: Se prueba con el valor 75, el cual es representativo de la partición equivalente por encontrarse a mitad de rango.

testEstaEnRango_FinRango: Se prueba con el valor 100, el cual es el último valor dentro del rango.

testEstaEnRango_FueraRangoSuperior: Se prueba con el valor de borde inmediato superior (101), se espera que este fuera de rango.

Cada caso se prueba de manera aislada en métodos diferentes, y están claramente comentados.

Escenario07

Descripción: los tests evalúan el comportamiento del método retirar pero con un saldo inicial de 100 en la cuenta. Los casos de prueba siguen un patrón similar al de Barrida01, pero con un monto más bajo

Retirar monto menor al saldo (99): El monto retirado es menor en una unidad al saldo disponible, lo que prueba el límite inferior del saldo. La operación es exitosa, y el saldo restante es 1.

Retirar monto igual al saldo (100): Al retirar exactamente el saldo disponible, se prueba el valor de borde. Se espera que la operación tenga éxito, y el saldo sea 0.

Retirar monto mayor al saldo (101): Este caso cubre un monto mayor que el saldo, probando el valor de borde superior. Se espera que se lance una excepción con el mensaje "Fondos insuficientes".

Escenario08

Descripción: los tests están diseñados para evaluar el comportamiento del método retirar en diferentes situaciones usando particiones equivalentes y valores de borde inmediatos. Se inicializa una cuenta bancaria con un saldo de 100 y se prueban cuatro casos principales

testRetirarMontoMenorSaldo: Este test cubre el caso donde el monto solicitado es ligeramente inferior al saldo de la cuenta (saldo - 0.01). Se espera que la extracción se realice correctamente y el saldo restante de la cuenta quede en 0.01 (utiliza un delta de 0.01 por variaciones en calculo de double)

testRetirarMontoIgualSaldo: Esto representa un valor de borde y una partición equivalente donde el monto es igual al saldo. Se espera que la operación sea exitosa, y el saldo resultante sea 0.

testRetirarMontoMayorSaldo: Este test cubre el caso donde el monto solicitado excede el saldo (saldo + 0.01). Se espera que no se realice la extracción, y el saldo se mantenga igual.

testRetirarMontoNegativo: Este test cubre el caso en el que se intenta retirar (-0,01), lo cual no debería afectar el saldo y debería devolver false.

Escenario09

Descripción: En esta barrida se sigue una estructura similar a la anterior pero se usan valores diferentes para inicializar la cuenta bancaria, empezando con un saldo mayor (1000) y un costo de mantenimiento menor (100). Aquí, el enfoque se mantiene en particiones equivalentes y valores de borde, pero con casos más extremos.

Partición equivalente: Al igual que en la primer barrida, se prueba con un costo de mantenimiento menor, igual y mayor al saldo. Sin embargo, estos valores se encuentran alejados de los valores de borde inmediato, sólo son valores representativos de la partición equivalente.

Test de borde ligeramente mayor que el saldo: Se incluye un test, donde el costo es ligeramente mayor que el saldo.

Escenario10

Descripcion: Se crea una cuenta bancaria con un saldo de 100.0 y un costo de mantenimiento de 50.0, la cuál se utilizará para el primer caso de prueba. El resto de configuraciones se instanciará propiamente en cada caso.

Saldo suficiente: El costo de mantenimiento es menor o igual al saldo, y el mantenimiento se cobra con éxito.

Saldo insuficiente: El costo de mantenimiento es mayor que el saldo (valor de borde: saldo + 1), y el mantenimiento no se cobra. Es un valor de borde a medias, ya que en el contexto de un banco, se tendrían que considerar los primeros dos decimales

Saldo exacto: El costo de mantenimiento es exactamente igual al saldo, se cobra el mantenimiento, y el saldo queda en 0.
--------------------------------------------------------------------------------
Tercer barrida | branch03

Escenario01

Descripción: En esta barrida, las pruebas se agrupan en varios casos dentro de un solo método de test, en lugar de separarlos como en el Escenario 2.

Estrategia de testing:
-También se usan particiones equivalentes y valores de borde inmediatos, pero los casos no están divididos en métodos individuales como en barridas anteriores.
Se agrupan pruebas relacionadas, lo que facilita la lectura, pero podría ser más complicado aislar fallos específicos.

Pruebas realizadas:
-Verificación del número 2 como par.
-Verificación del número 3 como impar.
-Verificación del número 0 como par.
-Excepción para el número negativo -1.

Escenario02

En este escenario se realizan pruebas unitarias para el método esValida() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas longitudes de contraseñas: 8, 9, 10, 11 y 20.

-Se utilizan particiones equivalentes para clasificar las contraseñas como menores, iguales o mayores a 10 caracteres.
-Se agrega una prueba adicional para cada partición 

Pruebas:
Prueba adicional para una contraseña de 8 caracteres, que es un caso adicional en la partición de contraseñas menores a 10.
Valores de borde con contraseñas de 9, 10, y 11 caracteres.
Contraseña de 20 caracteres para verificar la partición de contraseñas válidas.

Escenario03

Descripción: En este escenario se realizan pruebas unitarias para el método mezclarColecciones() de la clase Contexto. Las pruebas verifican el comportamiento del método para distintas combinaciones de colecciones: de diferente tamaño, tamaño menor/igual a 5, tamaño mayor a 5.

Se utilizan particiones equivalentes para clasificar las colecciones como menores o mayores a 5 elementos, y para colecciones de diferentes tamaños. 

Prueba de colecciones con tamaños iguales y mayor a 5:
-Se mezcla correctamente si ambas colecciones tienen tamaños mayores a 5.

Prueba de colecciones con tamaños iguales y menor o igual a 5:
-Se espera una excepción si ambas colecciones tienen un tamaño de 5 o menor.

Prueba de colecciones con tamaños diferentes:
-Nuevamente, se espera una excepción para colecciones con diferentes tamaños.

Escenario04

Descripción: En este escenario se realizan pruebas unitarias para el método mezclar() de la clase EstrategiaDeMezclaIntercalar. Las pruebas verifican el comportamiento del método para distintas combinaciones de colecciones: de diferente tamaño, tamaño menor/igual a 5, tamaño mayor a 5.

Se utilizan particiones equivalentes para clasificar las colecciones como menores o mayores a 5 elementos, y para colecciones de diferentes tamaños.

testMezclarColeccionesConTamanoMenorA5: Prueba si el método retorna ["-1"] cuando las colecciones tienen menos de 5 elementos, precisamente 3 elementos (ligeramente diferente de Barrida01, que prueba con 5 elementos). El valor de borde en este caso no es de lo más óptimo.

testMezclarColeccionesConTamanoMayorA5: Verifica que el método funciona correctamente para colecciones mayores a 5 elementos y de igual tamaño, devolviendo la mezcla correcta.

testMezclarColeccionesConTamanoDiferente: Similar al segundo test de la Barrida01 y Barrida02, verifica que si las colecciones tienen tamaños diferentes, el resultado es ["-1"].

Escenario05

Descripción: En este escenario se realizan pruebas unitarias para el método estaEnRango() de la clase enRango. Las pruebas verifican el comportamiento del método para distintos valores.

Se utilizan particiones equivalentes para clasificar los rangos: menor a 50, entre 50 y 100, y mayor 100.

testEstaEnRango: Se preuba con un valor representativo de particion equivalente(75).

testValorMenorQueRango: Se prueba con el valor de borde inferior (49) fuera de rango, se espera una excepción por estar fuera de rango.

testValorMayorQueRango: Se prueba con el valor de borde superior(101) fuera de rango, se espera una excepción por estar fuera de rango.

testValoresBorde: Se prueba con los valores inferiores(50) y superiores(100) dentro del rango. Ambos casos están agrupados en un mismo método.

Para este escenario, esta fue la única barrida que contó con comentarios en el código.

Escenario06

Descripción: En este escenario se realizan pruebas unitarias para el método estaEnRango() de la clase enRango. Las pruebas verifican el comportamiento del método para distintos valores.

Se utilizan particiones equivalentes para clasificar los rangos: menor a 50, entre 50 y 100, y mayor 100.

testEstaEnRangoConValorMenor: Se prueba con el valor de borde inmediatamente inferior (49), se espera que esté fuera de rango.

testEstaEnRangoConValorInicio: Se prueba con el valor de borde inmediato inferior (50) que está dentro del rango.

testEstaEnRangoConValorMedio: Se prueba con el valor 75, el cual es representativo de la partición equivalente por encontrarse a mitad de rango.

testEstaEnRangoConValorFin: Se prueba con el valor 100, el cual es el último valor dentro del rango.

testEstaEnRangoConValorMayor: Se prueba con el valor de borde inmediato superior (101), se espera que este fuera de rango.

Cada caso se prueba de manera aislada en métodos diferentes, y tienen un leve comentario, mas acotado que en las anteriores barridas.

Escenario07

Descripción: los tests evalúan el comportamiento del método retirar pero con un saldo inicial de 1000 en la cuenta. Los casos de prueba siguen un patrón similar al de barridas anteriores, pero se prueban 4 casos.

Retirar monto menor que el saldo (500): Se retira la mitad del saldo, cubriendo una partición equivalente. La operación es exitosa, y el saldo resultante es 500.

Retirar monto igual al saldo (1000): Al retirar todo el saldo disponible, se prueba el valor de borde exacto, esperando que el saldo sea 0.

Retirar monto mayor que el saldo (1500): Aquí se prueba un monto considerablemente mayor que el saldo, lo que resulta en una excepción con el mensaje "Fondos insuficientes".

Retirar un monto ligeramente mayor que el saldo (1000.01): Este test agrega un valor de borde más preciso, probando un monto apenas superior al saldo disponible. Se espera que también lance una excepción con el mismo mensaje.

Escenario08

Descripción: los tests están diseñados para evaluar el comportamiento del método retirar en diferentes situaciones usando particiones equivalentes y valores de borde inmediatos. Se inicializa una cuenta bancaria con un saldo de 1000 y se prueban cinco casos principales

retirarMontoMenorQueSaldo: Esto representa un valor representativo de la partición equivalente que está dentro del rango de lo que se puede retirar.

retirarMontoIgualQueSaldo: Esto representa un valor de borde y una partición equivalente donde el monto es igual al saldo. Se espera que la operación sea exitosa, y el saldo resultante sea 0.

retirarMontoMayorQueSaldo: Esto representa un valor representativo de la partición equivalente que está fuera del rango de lo que se puede retirar.

retirarMontoJustoMenorQueSaldo: Este test cubre el caso donde el monto solicitado es ligeramente inferior al saldo de la cuenta (saldo - 0.01). Se espera que la extracción se realice correctamente y el saldo restante de la cuenta quede en 0.01 (no se utiliza un delta de tolerancia, por lo cuál habrá un error en el assertEquals)

testRetirarMontoMayorSaldo: Este test cubre el caso donde el monto solicitado excede el saldo (saldo + 0.01). Se espera que no se realice la extracción, y el saldo se mantenga igual.

Escenario09

Descripción: En la tercer barrida, se usan saldos y costos de mantenimiento más grandes para los tests. Este set de pruebas se enfoca también en particiones equivalentes y valores de borde, pero además incluye un caso adicional: la prueba de un saldo cero.

Test de partición equivalente: Se sigue probando cuando el costo es menor, igual, y mayor que el saldo. Sin embargo, todos los casos utilizan valores representativos de la particion equivalente, pero ninguno es un valor de borde.

Test de borde de saldo cero: Este caso es adicional y permite comprobar cómo se comporta la clase cuando el saldo de la cuenta es exactamente cero. Este caso se puede ver como una redundacia, debido a que ya se había realizado un test dónde se probaba con un costo de mantenimiento superior al saldo.

Escenario10

Descripcion: Se crea una cuenta bancaria con un saldo de 100.0 y un costo de mantenimiento de 50.0, la cuál se utilizará para el primer caso de prueba. El resto de configuraciones se instanciará propiamente en cada caso.

Costo menor que el saldo: El costo de mantenimiento es menor que el saldo, y el mantenimiento se cobra con éxito.

Costo igual que el saldo: El saldo es igual al costo de mantenimiento, y el mantenimiento se cobra con éxito dejando el saldo en 0.

Costo mayor que el saldo: El costo de mantenimiento es mayor que el saldo, y el mantenimiento no se puede cobrar.

En ninguno de los casos se utilizó valores de borde, solo fueron valores representativos de la partición equivalente.
--------------------------------------------------------------------------------

Conclusiones entre barridas

Escenario01

Barrida01 y barrida02 dividen las pruebas en métodos individuales, lo que facilita identificar cuál caso específico falla. barrida03, en cambio, agrupa varias pruebas en un solo método, lo que simplifica la estructura, pero puede dificultar la depuración si se produce un error en una prueba.

En todas las barridas se utilizan particiones equivalentes y valores de borde inmediatos, pero la barrida02 es las mas enfocada en aislar estos casos, con una prueba por cada partición y borde, logrando una cobertura exhaustiva con una optimización de esfuerzo.

barrida01 y barrida03 son las más detalladas en sus verificaciones, ya que incluyen mensajes personalizados en las excepciones y pruebas más explícitas, como la verificación de que el mensaje de la excepción es correcto.
la barrida02 es más simple y directa, con menos detalle en las excepciones.

Observaciones:
-En todas las barridas se testeó sobre la clase contexto, pero en realidad debería haber sido sobre la clase ValidadorDeNumero, que es la dueña del método esPar(). 

Escenario02

Barrida01 y barrida02 tienen una estructura similar, pero el de barrida02 usa variables intermedias para las contraseñas, lo que facilita la lectura y modificación del código en comparación con el uso directo de literales en la barrida01.

La barrida03 es más exhaustiva al incluir valores más alejados del borde en sus particiones (como la contraseña de 8 caracteres y la de 20 caracteres), pero esto hace que sus pruebas sean más redundantes. Si ya se ha cubierto los casos límites de las particiones equivalentes con un valor apropiado, no es necesario incluir más valores dentro de la misma partición a menos que haya un motivo especifico para hacerlo.

En cuánto a los comentarios, todos tienen una documentación muy bien detallada.

Observaciones:
-En todas las barridas se testeó sobre la clase contexto, pero en realidad debería haber sido sobre la clase longitudMinimaStratregy que es la dueña del método esValida(). 

Escenario03

Las 3 barridas presentan cierta redundancia. Los mismos casos (mezcla con tamaños iguales mayores a 5, tamaños iguales menores o iguales a 5, y tamaños diferentes) se repiten. Aunque están organizados de manera ligeramente distinta en cada escenario, no se introducen nuevos casos o variaciones significativas.

Observaciones:
-En todas las barridas se testeó sobre la clase contexto, pero en realidad debería haber sido sobre la clase EstrategiaDeMezclaIntercalar, que es la dueña del método mezclar().
-Ninguna de las barridas incluye comentarios en sus pruebas, por lo tanto tienen una documentación muy pobre.

Escenario04

Estructura similar en las tres barridas: Todas las barridas verifican prácticamente los mismos casos, pero con variaciones en la estructura (uso del contexto en Barrida02) y en algunos detalles de los tamaños de las colecciones (por ejemplo en la barrida03, para el caso de prueba testMezclarColeccionesConTamanoMenorA5 no se utilizó un valor de borde para la partición).

Observaciones:
-barrida01 y barrida03 fueron capaces de detectar que debian testear la clase EstrategiaDeMezclaIntercalar y no la clase contexto, como venía sucediendo en otros escenarios.
-Ninguna de las barridas incluye comentarios en sus pruebas, por lo tanto tienen una documentación muy pobre.

Escenario05

Barrida01 agrupa los valores de borde en un solo método, lo que facilita su revisión, pero introduce redundancia al repetir algunos valores ya probados en otros test, por lo tanto podría ser más dificil de mantener.

Barrida02 separa cada caso de prueba, lo que facilita la identificación de errores y hace que sea más clara en cuanto mantemiento

Barrida 03 combina ambos enfoques: agrupa los valores de borde dentro del rango (50 y 100) pero mantiene separados los valores fuera del rango (49 y 101), lo que reduce la redundancia. También es la única que incluye comentarios en el código, lo que mejora la legibilidad y comprensión de las pruebas.

Escenario06

Las 3 barridas presentan cierta redundancia, los mismos casos de prueba se repiten y no se introducen nuevos casos o variaciones significativas. Aunque los nombres de los métodos difieren en cada barrida, todos indican correctamente que es lo que se está testeando. Sin embargo en la barrida01, para cada tests se utiliza un método existente "setValor", por lo que todos los tests se rompen.

Escenario07

Barrida01 y Barrida03 usan un saldo inicial de 1000, mientras que Barrida02 usa un saldo inicial de 100, este detalle resulta insignificante en la manera que todos detectaran las particiones equivalentes correctamente.

Barrida01 y Barrida02 tienen tres casos de prueba, enfocándose en particiones equivalentes y valores de borde inmediatos (saldo menor, saldo igual, saldo mayor), pero prueban con numeros enteros sin considerar que una extracción bancaria podría contener hasta dos cifras decimales, por lo tanto realmente no se testeó el borde inmediato.
Barrida03 aborda este problema utilizando un caso adicional (retirar un monto ligeramente mayor que el saldo) para probar un valor de borde aún más preciso, el cuál es mayor en 0.01 al saldo, también prueba con extraer un valor exactamente igual al saldo. Además tiene dos pruebas con valores que estan a mitad de rango (500 y 1500), si bien son valores representativos de las particiones equivalentes, podría ser redundante estas pruebas luego de ya haber realizado las prueba con los valores de bordes antes mencionados.

Como observación común, todas las barridas utilizan nombres muy claros para sus métodos que indican que es lo que se está probando, además se encuentra claramente comentado.

Escenario08

Barrida01 se centra en probar situaciones básicas de retiro (menor, igual, y mayor al saldo), además de un caso de borde, donde el monto es ligeramente mayor al saldo.

Barrida02 tambíen se centra en probar situaciones básicas de retiro (menor, igual y mayor), pero para todas utiliza valores de borde. También introduce un caso adicional de retiro con un monto negativo, lo que expande la cobertura a una situación inválida no cubierta en otras barridas.

Barrida03 cubre una gama más amplia de pruebas, probando desde montos que se encuentran a mitad del rango de cada particion, cómo asi también probando con montos justo menores como justo mayores al saldo, proporcionando una mayor precisión en los límites del comportamiento de la función. 

El hecho de realizar tantas pruebas podría ser redundante, para garantizar que el código funcione correctamente alcanzaría con realizar dos pruebas, una retirando un saldo igual al de la cuenta, y otra con un saldo ligeramente superior.

Como observación, todas las barridas utilizan nombres muy claros para sus métodos que indican que es lo que se está probando. Todas las barridas se encuentran claramente docuementadas, excepto la barrida01 la cual no contiene ningún comentario.

Escenario09

Barrida01: Está enfocado en probar casos básicos con montos menores, iguales o superiores a un determinado número, sin usar valores de borde inmediato. 

Barrida02: Además de hacer lo que se hace en la barrida01, agrega una prueba dónde se utiliza un valor de borde para intentar cobrar un monto ligeramente mayor que el saldo de la cuenta.

Barrida03: Es muy similar a la barrida01, dónde se utilizan valores representativos de particiones equivalentes pero no precisamente valores de borde. Además se agrega el caso limite de saldo cero, el cuál se podría ver como una redundancia ya que este caso estaba cubierto.

Observaciones:
En todos los escenarios se verifica que, cuando el costo de mantenimiento es mayor que el saldo, se lance una excepción con el mensaje adecuado. 
Todas las barridas utilizan nombres muy claros para sus métodos que indican que es lo que se está probando. 
Todas las barridas se encuentran claramente documentadas, siendo barrida01 la que tiene un mejor desarrollo de comentarios.

Escenario10

Barrida01 incluye pruebas adicionales para valores justo por encima y por debajo del saldo, lo que introduce mayor precisión en la validación de bordes inmediatos.

Barrida02 se enfoca más en las particiones equivalentes con pruebas básicas que cubren las situaciones donde el saldo es mayor, menor o igual al costo de mantenimiento, con menos énfasis en valores de borde inmediato.

Barrida 03 es similar a la segunda, se centra en casos básicos y no prueba casos de valores ligeramente menores o mayores que el saldo, como en Barrida 01. Es una versión más simplificada.

Observaciones:
Todas las barridas utilizan nombres muy claros para sus métodos que indican que es lo que se está probando. 
Todas las barridas excepto la primera se encuentran claramente documentadas.