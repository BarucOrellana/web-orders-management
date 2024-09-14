# Sobre la aplicación

Esta API REST fue creada para una aplicación que ayudara dentro del proceso de gestión de pedidos para una empresa de transporte de carga terrestre, fue diseñada en base a los procesos y requerimientos específicos de esta empresa, se tomaron en cuenta factores como la seguridad al autenticar a los usuarios, roles dentro de la organización y los procesos con los que trabajan en la actualidad. 
Utiliza doble factor de autenticación, creando un código que después es enviado a través de correo electrónico para que el usuario pueda ingresarlo y así ser autenticado de forma exitosa.
La API se conecta a una base de datos que ayudara a la organización a llevar un registro eficiente de pedidos, controlando fechas, chofer, destinos, unidad en la que se realizara el pedido, incluso el precio de los pedidos, de esta manera será más sencillo controlar la información y operación logística dentro de la organización, además, incluye datos como los costos de cada pedido, para poder realizar un monitoreo de utilidades por pedido, atendiendo la principal necesidad presentada por el cliente que era poder monitorear las utilidades de cada pedido en el menor tiempo posible.

# Detalles técnicos

La API fue creada utilizando el lenguaje Java, con ayuda del framework Spring, conectada a una base de datos de tipo relacional "MySQL".
Para la autorización se utilizaron roles y JWT que la aplicación válida para otorgarle permisos a los usuarios según su responsabilidades, además, utiliza un sistema de autenticación por usuario y contraseña acompañado de un modelo de doble factor de autenticación, utilizando JavaMailSender se envía un código creado de forma aleatoria por la aplicación vía correo electrónico para que el usuario pueda ingresarlo y autenticarse de forma correcta, para este proceso de autenticación se utilizó Redis para almacenar el código de manera temporal 
