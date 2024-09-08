Desarrollo de código y especificación de requerimientos

Lo hacemos para intentar entender cómo tienen que ser los datasets, para esto escribimos la especificación de requerimientos y desarrollamos el código, para luego ver si el LLM puede lograr escribir los tests interpretando lo anterior mencionado. Los programas contemplan las siguientes variaciones:

--

i. Un programa dónde se pruebe un sólo parámetro, ver si anda bien o levanta excepciones.

El programa recibe un número positivo e indica si es par o impar. En caso que el número sea negativo, se lanza una excepción.

--

ii. Un programa dónde se pruebe un sólo parámetro, ver si hace X o si hace Y.

El programa recibe una contraseña. Si la longitud de la misma es mayor o igual a 10 devuelve True, sinó False.

--

iii. Un programa dónde se pruebe la combinación de dos parámetros, ver si anda bien o levanta excepción.

El programa recibe dos colecciones, si ambas colecciones tienen el mismo tamano y es mayor a 5 entonces se realiza el merge. Caso contrario se produce una excepción.

--

iv. Un programa dónde se pruebe la combinación de dos parámetros, ver si hace X o hace Y.

El programa recibe dos colecciones, si ambas colecciones tienen el mismo tamano y es mayor a 5 entonces se realiza el merge.
caso contrario se retorna una colección ún único valor -1

--

v. Un programa dónde se pruebe una variable de instancia, ver si anda bien o levanta excepción.

El programa devuelve True si su variable de instancia “valor” está en el rango [50,100], en caso contrario lanza una excepción.

--

vi. Un programa dónde se pruebe una variable de instancia, ver si hace x o hace y.

El programa indica si su variable de instancia “valor” está en el rango [50,100]

--

vii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si anda bien o levanta excepción.

El programa simulará una cuenta bancaria que permite inicializar la cuenta y realizar retiros. 
La clase contará con un constructor dónde se inicializará con un saldo inicial. 
Luego contará con un método que recibirá un parámetro de un monto a retirar. 
En caso de que el monto a retirar sea menor o igual al saldo inicial, se devolverá True. Si el monto a retirar es superior al saldo inicial, se lanzará una excepción.

--

viii. Un programa dónde se pruebe un parámetro y una variable de instancia, ver si hace X o hace Y.

El programa simulará una cuenta bancaria que permite inicializar la cuenta y realizar retiros. 
La clase contará con un constructor dónde se inicializará con un saldo inicial. 
Luego contará con un método que recibirá un parámetro de un monto a retirar. 
En caso de que el monto a retirar sea menor o igual al saldo inicial, se devolverá True. 
Si el monto a retirar es superior al saldo inicial, se devuelve False.

--

ix. Un programa donde se pruebe dos variables de instancia, ver si anda bien o levanta excepción.

El programa simulará una cuenta bancaria que permite inicializarla y establecer un costo de mantenimiento. 
La clase contará con un constructor dónde se inicializará con un saldo inicial, y el costo de mantenimiento mensual. 
Luego contará con un método cobrarMantenimiento. En caso de que el costo de mantenimiento sea mayor que el saldo inicial, entonces se produce una excepción.

--

x. Un programa donde se pruebe dos variables de instancia, ver si hace X o hace Y

El programa simulará una cuenta bancaria que permite inicializar la cuenta y establecer un costo de mantenimiento. 
La clase contará con un constructor dónde se inicializará con un saldo inicial, y el costo de mantenimiento mensual. 
Luego contará con un método cobrarMantenimiento, que en caso de que el monto del mantenimiento sea menor o igual al saldo inicial, se devolverá True. 
Si el monto del mantenimiento es superior al saldo inicial, se devuelve False.

--