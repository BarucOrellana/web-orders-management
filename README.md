# Sobre la aplicación

Esta API REST fue creada para una aplicación que ayudara dentro del proceso de gestión de pedidos para una empresa de transporte de carga terrestre, fue diseñada en base a los procesos y requerimientos específicos de esta empresa, se tomaron en cuenta factores como la seguridad al autenticar a los usuarios, roles dentro de la organización y los procesos con los que trabajan en la actualidad. 
Utiliza doble factor de autenticación, creando un código que después es enviado a través de correo electrónico para que el usuario pueda ingresarlo y así ser autenticado de forma exitosa.
La API se conecta a una base de datos que ayudara a la organización a llevar un registro eficiente de pedidos, controlando fechas, chofer, destinos, unidad en la que se realizara el pedido, incluso el precio de los pedidos, de esta manera será más sencillo controlar la información y operación logística dentro de la organización, además, incluye datos como los costos de cada pedido, para poder realizar un monitoreo de utilidades por pedido, atendiendo la principal necesidad presentada por el cliente que era poder monitorear las utilidades de cada pedido en el menor tiempo posible.

## Características técnicas

<li>Java: 17</li>
<li>Spring Boot: 3.3.0</li>
<li>Lombok: 1.18.34</li>
<li>Mysql-connector-j: 9.0.0</li>
<li>Mockito: 5.11.0</li>
<li>H2database:h2: 2.2.224</li>
<li>Junit</li>

## Introducción
La API se conecta a una base de datos del tipo relación (MySQL) y logra ejecutar consultas de lectura, creación, actualización y eliminación de los datos de forma exitosa.
A través de los métodos HTTP que ofrece la API podemos generar nuevos pedidos en la base de datos, editar sus costos, asignar un operador y la unidad que le corresponde, entre otras funcionalidades que ayudan a la gestión exitosa de pedidos, todo ajustado a los procesos que se indicaron al iniciar el desarrollo de la aplicación.

## Modelo entidad-relación
![image](https://github.com/user-attachments/assets/77184b39-30e1-40f5-aeb7-3bb9efe038fa)

## Uso de la API REST
La aplicación cuenta con un sistema de autenticación en dos pasos, a grandes rasgos funciona de la siguiente manera.
1- El usuario ingresa usuario y contraseña.
2- La aplicación genera un código aleatorio y lo envía por correo electrónico.
3- El código es enviado con ayuda de un servidor de correo electrónico al correo del usuario.
4- El código generado es almacenado en un servidor de cache con ayuda de Redis.

*endpoint para inicio de sesión*
![image](https://github.com/user-attachments/assets/445a5b66-0e66-4af5-b26a-a138e0042a16)

5- El usuario recibe el código y lo envía para su validación.
6- La aplicación compara el código almacenado con el que envío el usuario.
7- Autentica al usuario, genera un Json Web Token firmado y lo envía a través del header de la respuesta.

*endpoint de autenticación*
![image](https://github.com/user-attachments/assets/0037b0ea-002a-4a21-afe5-954bb9aefb59)

Una vez autenticado, gracias JWT, el usuario podrá autorizar los endpoints que le correspondan a su role, por ejemplo:
![image](https://github.com/user-attachments/assets/42582ab5-1bd9-4f77-a5d2-f7972d6329d9)
El endpoint anterior devuelve todos los pedidos que existen en la base de datos, con paginación al momento de realizar la consulta. La aplicación únicamente autorizara la respuesta solo si el rol del usuario es el correcto, esta validación ocurre en la configuración de seguridad.

*Configuración de seguridad*
![image](https://github.com/user-attachments/assets/c8b75ff1-3b40-4998-bf47-229d3cadd859)

Gracias a esta configuración, los endpoints solo son ejecutados por aquellos usuarios que cuenten con el role señalado en los requestMatchers.

En general, la API proporciona los endpoints necesarios de un CRUD, utilizando medidas de seguridad al momento de realizar cada consulta a la base de datos e incluso antes de poder hacer cualquier petición al servidor, de esta manera puede ser consumida de forma correcta para la creación de una aplicación web que garantice la recolección de datos, la gestión correcta de pedidos y la ejecución del proceso de venta en una empresa de transporte.



