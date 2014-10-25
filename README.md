emtmadridcli
============

Librería java para acceder a algunas funcionalidades de la API REST de la Empresa Municipal de Transportes de Madrid. Puede ser utilizada incluyendo el JAR en un proyecto Java o invocando el JAR a través de la linea de comando.

## Requisitos

Para poder atacar la API de la EMT es necesario solicitar credenciales a través del formulario http://opendata.emtmadrid.es/Formulario . Las claves llegan automáticamente, no hacen validación manual de las peticiones. 

Además, el certificado SSL del servidor de la API es auto firmado, así que hay que exportarlo e importarlo en la KeyStore del JRE de la máquina que va a utilizar el JAR.

## Funcionalidades en Java

La clase "Api" tiene dos métodos principales. getTimesFromStop(int stopCode) devuelve un IncomingBusList con la información de todos los autobuses que se acercan a una parada. getTimesFromStopSpecificLine(int stopCode, int lineNumber) devuelve la misma información pero filtrando por un número de linea de autobús.

## Funcionalidades a través de la terminal

Al invocar el JAR desde la terminal se puede obtener la información en segundos o un poco más procesada.

### Información procesada

Todos los autobuses de la parada 2127:

```java
java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop pretty-console 2127
```

Autobuses de la línea 32 en la parada 2127:

```java
java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop pretty-console 2127 32
```

### Información cruda

Segundos que faltan para que llegue el primer autobus de la linea 32 en la parada 2127

```java
 java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop bare-seconds 2127 32 0
 ```
 
 Segundos que faltan para que llegue el segundo autobus de la linea 32 en la parada 2127
 
 ```java
 java -jar emtmadridcli.jar API_CLIENT_ID API_PASSKEY incomingBusToStop bare-seconds 2127 32 1
 ```

## Pendiente

* Pruebas
* Salida en JSON
* Control de errores
* (Mejor) Documentación
* Pruebas de rendimiento y posible reemplazo de unirest