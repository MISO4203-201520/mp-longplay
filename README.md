#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-musicstore)
  - [Entidad Album](#entidad-album)
  - [Entidad CartItem](#entidad-cartitem)
  - [Entidad Client](#entidad-client)
  - [Entidad LongPlay](#entidad-longplay)
  - [Entidad Provider](#entidad-provider)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /MusicStore.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación MusicStore
###Entidad Album
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Album, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Album
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    cover: '' /*Tipo String*/,
    release: '' /*Tipo Date*/,
    single: '' /*Tipo Boolean*/,
    artist: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/albums|Obtener todos los objetos JSON de Album (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Album y el total de registros en la base de datos en el header X-Total-Count
**GET**|/albums/:id|Obtener los atributos de una instancia de Album en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Album
**POST**|/albums|Crear una nueva instancia de la entidad Album (CREATE)||Objeto JSON de Album a crear|Objeto JSON de Album creado
**PUT**|/albums/:id|Actualiza una instancia de la entidad Album (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Album|Objeto JSON de Album actualizado
**DELETE**|/albums/:id|Borra instancia de Album en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad CartItem
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad CartItem, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto CartItem
```javascript
{
    id: '' /*Tipo Long*/,
    quantity: '' /*Tipo Integer*/,
    longPlay: '' /*Objeto que representa instancia de LongPlay*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/cartItems|Obtener todos los objetos JSON de CartItem (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON CartItem y el total de registros en la base de datos en el header X-Total-Count
**GET**|/cartItems/:id|Obtener los atributos de una instancia de CartItem en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de CartItem
**POST**|/cartItems|Crear una nueva instancia de la entidad CartItem (CREATE)||Objeto JSON de CartItem a crear|Objeto JSON de CartItem creado
**PUT**|/cartItems/:id|Actualiza una instancia de la entidad CartItem (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de CartItem|Objeto JSON de CartItem actualizado
**DELETE**|/cartItems/:id|Borra instancia de CartItem en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Client
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Client, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Client
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    userId: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/clients|Obtener todos los objetos JSON de Client (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Client y el total de registros en la base de datos en el header X-Total-Count
**GET**|/clients/:id|Obtener los atributos de una instancia de Client en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Client
**POST**|/clients|Crear una nueva instancia de la entidad Client (CREATE)||Objeto JSON de Client a crear|Objeto JSON de Client creado
**PUT**|/clients/:id|Actualiza una instancia de la entidad Client (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Client|Objeto JSON de Client actualizado
**DELETE**|/clients/:id|Borra instancia de Client en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Client
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Client son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|clients/:id/cartItems|Obtener Objetos JSON de cartItems(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client||Colección de objetos JSON de cartItems(CartItem)
**POST**|clients/:id/cartItems|Creación de instancias de cartItems(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de cartItems(CartItem) a crear|Colección de objetos JSON de cartItems(CartItem) creados con sus respectivos ID
**PUT**|clients/:id/cartItems|Actualización de instancias de cartItems(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de objetos JSON de cartItems(CartItem) a actualizar|Colección de objetos JSON de cartItems(CartItem) actualizados
**DELETE**|clients/:id/cartItems|Eliminación de instancias de cartItems(CartItem) dependientes de Client|**@PathParam id**: `id` de instancia de Client|Colección de atributo `id` de cartItems(CartItem) a eliminar|

[Volver arriba](#tabla-de-contenidos)

###Entidad LongPlay
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad LongPlay, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto LongPlay
```javascript
{
    id: '' /*Tipo Long*/,
    album: '' /*Objeto que representa instancia de Album*/,
    price: '' /*Tipo Integer*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/longPlays|Obtener todos los objetos JSON de LongPlay (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON LongPlay y el total de registros en la base de datos en el header X-Total-Count
**GET**|/longPlays/:id|Obtener los atributos de una instancia de LongPlay en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de LongPlay
**POST**|/longPlays|Crear una nueva instancia de la entidad LongPlay (CREATE)||Objeto JSON de LongPlay a crear|Objeto JSON de LongPlay creado
**PUT**|/longPlays/:id|Actualiza una instancia de la entidad LongPlay (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de LongPlay|Objeto JSON de LongPlay actualizado
**DELETE**|/longPlays/:id|Borra instancia de LongPlay en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Provider
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Provider, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Provider
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    userId: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/providers|Obtener todos los objetos JSON de Provider (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Provider y el total de registros en la base de datos en el header X-Total-Count
**GET**|/providers/:id|Obtener los atributos de una instancia de Provider en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Provider
**POST**|/providers|Crear una nueva instancia de la entidad Provider (CREATE)||Objeto JSON de Provider a crear|Objeto JSON de Provider creado
**PUT**|/providers/:id|Actualiza una instancia de la entidad Provider (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Provider|Objeto JSON de Provider actualizado
**DELETE**|/providers/:id|Borra instancia de Provider en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Provider
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Provider son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|providers/:id/longPlays|Obtener Objetos JSON de longPlays(LongPlay) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider||Colección de objetos JSON de longPlays(LongPlay)
**POST**|providers/:id/longPlays|Creación de instancias de longPlays(LongPlay) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de objetos JSON de longPlays(LongPlay) a crear|Colección de objetos JSON de longPlays(LongPlay) creados con sus respectivos ID
**PUT**|providers/:id/longPlays|Actualización de instancias de longPlays(LongPlay) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de objetos JSON de longPlays(LongPlay) a actualizar|Colección de objetos JSON de longPlays(LongPlay) actualizados
**DELETE**|providers/:id/longPlays|Eliminación de instancias de longPlays(LongPlay) dependientes de Provider|**@PathParam id**: `id` de instancia de Provider|Colección de atributo `id` de longPlays(LongPlay) a eliminar|

[Volver arriba](#tabla-de-contenidos)

