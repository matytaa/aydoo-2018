Informe fibo3

    1.- ¿Cumple con la consigna fibo3?
    2.- ¿Tiene suficientes tests?
    3.- ¿Respeta la convenciones Java?
    4.- ¿Respeta los principios SOLID? en caso que no los respete indique que principio 
    viola y porque

Respuesta:

    1.- Cumple con la consigna, y el orden de los parámetros no alteran el funcionamiento
    
    2.- Tiene suficientes test. Pero, según correciones recibidas en tareas prevías faltó 
        testear con números menores a 1
            Caso 0 
                Entrada: java -jar fibo.jar 0
                Salida:  fibo<0>:
            Caso -1 
                Entrada: java -jar fibo.jar -1
                Salida:  fibo<-1>:
            Debería devolver "Opciones no válidas"
            
    3.- No respeta la convención Camel Case, utiliza algunos métodos y variables con "_"
    
    4.- Respeta los principios SOLID
            Aplica la resposabilidad simple
            Aplica abierto/cerrado, las nuevas funcionalidades resultaron a nivel código 
                simples de implementar. Aunque algunas cosas las hubiera resuelto muy 
                diferente, para evitar el uso inusitado de IF
            Aplica Liskov
            Printer prodía ser candidato a interfaz
            La clase Fibonacci conoce a todas las impresoras