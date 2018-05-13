Ejercicio: Fibonacci4
=====================

Aplicación que recibe como parámetro un número y genera por pantalla los numeros para esa cantidad de la serie de Fibonacci. En esta versión tiene el plus que también se pueden pasar parámetros opcionales, para poder imprimirla vertical u horizontalmente, directa o inversamente, realizar una sumatoria y guardarla en un archivo.
Ejemplos de uso:
* java -jar fibo.jar 8
* java -jar fibo.jar -o=vd 5
* java -jar fibo.jar -o=hi 8

# Ejemplo 1 progresiva directa

java -jar fibo.jar -o=pd 8

fibo<8>:
0
0 1
0 1 1
0 1 1 2
0 1 1 2 3
0 1 1 2 3 5
0 1 1 2 3 5 8
0 1 1 2 3 5 8 13

# Ejemplo 2 progresiva inversa

java -jar fibo.jar -o=pi 8

fibo<8>:
13
13 8
13 8 5
13 8 5 3
13 8 5 3 2
13 8 5 3 2 1
13 8 5 3 2 1 1
13 8 5 3 2 1 1 0

No puede invocarse las opciones de vertical u horizontal para la impresión progresiva, en cuyo caso deberá indicarse que la opción es incorrecta.

# Ejemplo 1 opción incorrecta:

java -jar fibo.jar -o=ph 8

Opciones no válidas.

# Ejemplo 2 opción incorrecta:

java -jar fibo.jar -o=pv 8

Opciones no válidas.

# Ejemplo 1 impresión solo de números pares:

java -jar fibo.jar -o=vi -n=p 8
fibo<8>:
8
2

# Ejemplo 2 impresión solo de números pares:

java -jar fibo.jar -n=p 8
fibo<8>: 2 8

# Ejemplo 3 impresión solo de números pares:

java -jar fibo.jar -n=p 16
fibo<16>: 2 8 34 144 610

De no ser indicada la opción -n, deben imprimirse todos los números de la sucesión