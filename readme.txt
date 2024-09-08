Primer barrida | branch01

i. Un programa dónde se pruebe un sólo parámetro, ver si anda bien o levanta excepciones.

GPT realiza pruebas con diferentes numeros para determinar si son pares o no. También verifica que se lance una excepción al ingresar un numero negativo. 

--

ii. Un programa dónde se pruebe un sólo parámetro, ver si hace X o si hace Y.

GPT raliza pruebas con contraseñas de longitud menor, igual y superior a la necesaria. 

--

iii. Un programa dónde se pruebe la combinación de dos parámetros, ver si anda bien o levanta excepción.

GPT es capaz de realizar pruebas con colecciones de diferentes tamaños, colecciones iguales de tamaño 5, y colecciones iguales de tamaño 6, logrando así probar todas las particiones de equivalencia.

--

iv. Un programa dónde se pruebe la combinación de dos parámetros, ver si hace X o hace Y.

GPT realiza pruebas con colecciones de igual tamaño menores a 5, colecciones mayor a 5 diferente tamaño, y colecciones mayor a 5 mismo tamaño, logrando así probar todas las particiones de equivalencia.

--

v. Un programa dónde se pruebe una variable de instancia, ver si anda bien o levanta excepción.


GPT realiza pruebas con valores en los bordes de la particion, tanto internos como externos (para estos últimos prueba que se lance excepción). 
Algunos métodos fueron repetidos innecesariamente.

--

vi. Un programa dónde se pruebe una variable de instancia, ver si hace x o hace y.

GPT realiza pruebas con valores en los bordes de la particion, tanto internos como externos. Sin embargo, no inicializa el objeto con su constructor sino que utiliza un método inexistente, por lo cuál la clase no compila.

--

vii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si anda bien o levanta excepción.

GPT realiza pruebas en los valores de borde, sin embargo estamos trando valores double, pero realiza pruebas con valores enteros, por lo tanto no se estan testeando correctamente los bordes inmediatos.

--

viii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si hace X o hace Y.

GPT realiza pruebas distinguiendo bien las particiones equivalentes y utiliza valores de bordes adecuados. También prueba con algunos valores representativos de la partición, pero que no se encuentran en el borde.

--

ix. Un programa donde se pruebe dos variables de instancia, ver si anda bien o levanta excepción.

GPT distingue las particiones equivalentes pero no utiliza los valores de borde adecuados.

--

x. Un programa donde se pruebe dos variables de instancia, ver si hace X o hace Y

GPT distinque las particiones equivalentes y utiliza valores de borde.

--------------

Segunda barrida | branch02

i. Un programa dónde se pruebe un sólo parámetro, ver si anda bien o levanta excepciones.

GPT realiza pruebas con numeros representativos para cada partición. 

--

ii. Un programa dónde se pruebe un sólo parámetro, ver si hace X o si hace Y.

GPT raliza pruebas con contraseñas de longitud menor, igual y superior a la necesaria. 

--

iii. Un programa dónde se pruebe la combinación de dos parámetros, ver si anda bien o levanta excepción.

GPT es capaz de realizar pruebas con colecciones de diferentes tamaños, colecciones iguales de tamaño 5, y colecciones iguales de tamaño 6, logrando así probar todas las particiones de equivalencia.

--

iv. Un programa dónde se pruebe la combinación de dos parámetros, ver si hace X o hace Y.

GPT realiza pruebas con colecciones de igual tamaño menores a 5, colecciones mayor a 5 diferente tamaño, y colecciones mayor a 5 mismo tamaño, logrando así probar todas las particiones de equivalencia. GPT se olvidó importar el package del escenario, por lo que no se podía ejecutar la clase.

--

v. Un programa dónde se pruebe una variable de instancia, ver si anda bien o levanta excepción.


GPT realiza pruebas con valores en los bordes de la particion, tanto internos como externos (para estos últimos prueba que se lance excepción).

--

vi. Un programa dónde se pruebe una variable de instancia, ver si hace x o hace y.

GPT realiza pruebas con valores en los bordes de la particion, tanto internos como externos. También utiliza otro valor representativo de la partición que no representa un valor de borde.

--

vii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si anda bien o levanta excepción.

GPT realiza pruebas en los valores de borde, sin embargo estamos trando valores double, pero realiza pruebas con valores enteros, por lo tanto no se estan testeando correctamente los bordes inmediatos.

--

viii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si hace X o hace Y.

GPT realiza pruebas distinguiendo bien las particiones equivalentes y utiliza valores de bordes adecuados. También realiza una prueba extrayendo monto negativo, encontrando un error en la implementación.

--

ix. Un programa donde se pruebe dos variables de instancia, ver si anda bien o levanta excepción.

GPT distingue las particiones equivalentes y utiliza los valores de borde adecuados, también realiza prueba con otros valores que podrían llegar a ser redundantes. GPT se olvidó importar el package del escenario, por lo que no se podía ejecutar la clase.


--

x. Un programa donde se pruebe dos variables de instancia, ver si hace X o hace Y

GPT distinque las particiones equivalentes y utiliza valores de borde, pero no utiliza decimales por lo tanto el valor de borde no es inmediato.

----------------

Tercera barrida | branch03

i. Un programa dónde se pruebe un sólo parámetro, ver si anda bien o levanta excepciones.

GPT realiza pruebas con numeros representativos para cada partición. GPT no importó el package, por lo tanto no se podían ejecutar los casos de tests.

--

ii. Un programa dónde se pruebe un sólo parámetro, ver si hace X o si hace Y.

GPT raliza pruebas con contraseñas de longitud menor, igual y superior a la necesaria.  GPT no importó el package, por lo tanto no se podían ejecutar los casos de tests.

--

iii. Un programa dónde se pruebe la combinación de dos parámetros, ver si anda bien o levanta excepción.

GPT es capaz de realizar pruebas con colecciones de diferentes tamaños, colecciones iguales de tamaño 5, y colecciones iguales de tamaño 6, logrando así probar todas las particiones de equivalencia.

--

iv. Un programa dónde se pruebe la combinación de dos parámetros, ver si hace X o hace Y.

GPT realiza pruebas con colecciones de igual tamaño menores a 5, colecciones mayor a 5 diferente tamaño, y colecciones mayor a 5 mismo tamaño, logrando así probar todas las particiones de equivalencia.

--

v. Un programa dónde se pruebe una variable de instancia, ver si anda bien o levanta excepción.


GPT realiza pruebas con valores en los bordes de la particion, tanto internos como externos (para estos últimos prueba que se lance excepción).

--

vi. Un programa dónde se pruebe una variable de instancia, ver si hace x o hace y.

GPT realiza pruebas con valores en los bordes de la particion, tanto internos como externos. También utiliza otro valor representativo de la partición que no representa un valor de borde.

--

vii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si anda bien o levanta excepción.

GPT realiza pruebas en los valores de borde inmediatos. También prueba con valores representativos de la partición, que se encuentran a mitad de rango.

--

viii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si hace X o hace Y.

GPT realiza pruebas distinguiendo bien las particiones equivalentes y utiliza valores de bordes adecuados. Uno de los casos falla debido a que se comparan dos valores double, los cuales no son exactamentes iguales, faltó haber usado un delta como tolerancia de error.

--

ix. Un programa donde se pruebe dos variables de instancia, ver si anda bien o levanta excepción.

GPT distingue las particiones equivalentes, pero no utiliza los valores de borde adecuados. 


--

x. Un programa donde se pruebe dos variables de instancia, ver si hace X o hace Y

GPT distinque las particiones equivalentes pero no utiliza los valores de borde adecuados.