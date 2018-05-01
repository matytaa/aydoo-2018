Ejercicio Votaciones
===========
Repositorio personal de Matias Nievas Soto

En las votaciones Primaria Abiertas Simultáneas Obligatorias (PASO) compiten candidatos de varios partidos. 
Cada candidato representa a un único partido pero cada partido puede tener varios candidatos.

Considerando el escenario de una votación nacional se pide:

* Calcular el candidato que más votos logró en cada provincia

* Calcular el partido que más votos logró a nivel nacional (sumatoria de provincias de los votos del partido)

Comandos:

* Para compilar y correr los tests: _mvn clean test_
* Para generar un paquete jar ejecutable: _mvn clean package_. El package resultante se encontrará en el directorio target con el nombre que haya sido especificado en el finalName del pom.xml.
* Para correr los tests y medir la cobertura: _mvn clean cobertura:cobertura_. El reporte resultante se encontrará en target/site/cobertura/index.html.
* Para verificar el estilo con CheckStyle: _mvn clean checkstyle:checkstyle_. El reporte resultante se encontrará en target/site/checkstyle.html
