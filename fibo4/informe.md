Informe fibo3

    1.- ¿Cumple con la consigna fibo3?
    2.- ¿Tiene suficientes tests?
    3.- ¿Respeta la convenciones Java?
    4.- ¿Respeta los principios SOLID? en caso que no los respete indique que principio viola y porque

Respuesta:
    1.- Cumple con la consigna, y el orden de los parámetros no alteran el funcionamiento
    2.- Faltó testear con números menores a 1
            Caso 0 
                Entrada: java -jar fibo.jar 0
                Salido:  fibo<0>:
            Caso -1 
                Entrada: java -jar fibo.jar -1
                Salido:  fibo<-1>:
            Debería devolver "Opciones no válidas"
    3.- No respeta la convención Camel Case, utiliza algunos métodos y variables con "_"
    4.- Respeta los principios SOLID
            Verificar el string completo del parámetro no es una solución que escale. Si a -m 
            decidimos agregarle un par de valores más (ej: valores x e y -> -m=sx) hay que 
            agregar otro if