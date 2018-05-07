Ejercicio: Libreria - parte 2
===========
Repositorio personal de Matias Nievas Soto


    Una librería vende productos que se dividen en las siguientes
    categorías: libros, artículos de librería, revistas y periódicos. Las revistas
    y periódicos tienen una periodicidad que mediremos en cantidad de veces al mes
    que se publican. Todos los productos tienen un precio asociado. Los artículos
    de librería tienen además del precio de venta, llevan IVA en la venta. Además
    el kiosco tiene clientes, de los cuales almacena los datos esenciales
    incluyendo la dirección, y que productos han comprado en un determinado mes y
    que suscripciones (a revistas o periódicos) ha adquirido el cliente, los
    productos que compran los clientes se anotan en su cuenta corriente y se les
    cobra a fin de mes. El kiosco necesita como funcionalidad saber para un
    determinado mes cuánto debe cobrarle a cada cliente, y lo mismo para un año
    entero. Para los clientes registrados en el sistema hay un 5% de descuento
    sobre todas sus compras y además quienes realizan una suscripción anual existe
    un 20% de descuento sobre el precio del producto (revista o periódico) al cual
    se suscriben (este descuento es sobre el precio del producto y no se acumula a
    otros descuentos).

    Realizar el diagrama de clases correspondiente, detallando los métodos y
    atributos más importantes.

    Realizar un diagrama de secuencia sobre la obtención de la suma de los importes
    a cobrarles a los clientes registrados, para un mes determinado.

Forma de entrega: hacer los diagramas con Astah, luego exportar los diagramas a imágenes y poner esas imágenes en un GoogleDoc. Finalmente, entregar un link al GoogleDoc.

Consigna:
* Desarrollar un modelo de objetos que contemple la totalidad de la consigna
* Utilizar la técnica TDD
* Generar un diagrama de clase y secuencia (ubicar los diagramas en formato imagen en un subcarpeta doc junto a la carpeta src)


Comandos:

* Para compilar y correr los tests: _mvn clean test_
* Para generar un paquete jar ejecutable: _mvn clean package_. El package resultante se encontrará en el directorio target con el nombre que haya sido especificado en el finalName del pom.xml.
* Para correr los tests y medir la cobertura: _mvn clean cobertura:cobertura_. El reporte resultante se encontrará en target/site/cobertura/index.html.
* Para verificar el estilo con CheckStyle: _mvn clean checkstyle:checkstyle_. El reporte resultante se encontrará en target/site/checkstyle.html
