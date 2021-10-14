# Qué Me Pongo V7

## Nuevos Requerimientos

- Ver todas las prendas que tengo en mi guardarropas desde el navegador para poder administrarlas

- Crear una prenda desde el navegador

- Ver una prenda en particular que tengo en mi guardarropas para poder editarla

- Eliminar una prenda de mi guardarropas

- Ver mis eventos para administrarlos

- Abrir las sugerencias de prendas para un evento en mi navegador

> Se pide para cada requerimiento específico:
>
> - Armar rutas REST (URI + Método)
> - Esbozar qué información se enviaría en el body (por ej, en un JSON)
> - Pensar códigos de respuesta posibles para cada operación
> - Esbozar bodies de respuesta posibles

## Resolución por Requerimientos

### Ver todas las prendas que tengo en mi guardarropas

> Ruta _REST_

`GET /users/:user/guardarropas/:guardarropa/prendas/`

Recordando qué era una prenda...

```JAVA
public class Prenda {

    /**
     * El tipo de prenda.
     *
     * @since 1.0
     */
    private TipoPrenda tipo;

    /**
     * El color primario.
     *
     * @since 1.0
     */
    private Color color1;

    /**
     * El color secundario.
     *
     * @since 1.1
     */
    private Color color2;

    /**
     * El material con que está hecho la prenda.
     *
     * @since 1.0
     */
    private Material material;
}
```

```JSON
{
  "prenda": {
      "_id": "",
      "tipo": "",
      "color1": "",
      "color2": "",
      "material": "",
      "trama": ""
    }
}
```

> JSON REQUEST

Se deberia enviar, el usuario y el guardarropas mínimamente

```JSON
{
  "user": "admin",
  "guardarropa": "dummy"
}
```

> JSON RESPONSE

Se debería obtener un _array_, con los datos de una `Prenda`.

```JSON
{
  "result": [
    {
      "_id": "B003425032",
      "tipo": "SUPERIOR",
      "color1": "#db644a",
      "color2": "",
      "material": "ALGODON",
      "trama": "LISA"
    },
    {
      "_id": "J063208741",
      "tipo": "INFERIOR",
      "color1": "#28535b",
      "color2": "",
      "material": "JEAN",
      "trama": "LISA"
    },
  ]
}
```

> HTTP Status Codes

- `200`: Si logra obtener un array de prendas, por mas que este vacío.
- `400`: Si falla la validacion del request
- `401` / `403`: Si no tiene permisos para ver el guardarropas
- `404`: Si no existe el usuario o guardarropas
- `500`: Para cualquier error del server
- `503`: Servicio no disponible

### Crear una prenda desde el navegador

> Ruta _REST_

`POST /users/:user/guardarropas/:guardarropa/prendas/`

> REQUEST JSON

Deberia enviarse los datos de la prenda, junto al guardarropas donde se agrega y el usuario que le crea.

```JSON
{
  "user": "admin",
  "guardarropa": "dummy",
  "data": {
    "tipo": "SUPERIOR",
    "color1": "#db644a",
    "color2": "",
    "material": "ALGODON",
    "trama": "LISA"
  }
}
```

> JSON RESPONSE

Se podría obtener un la prenda creada con el ID asignado.

```JSON
{
  "prenda":  {
      "_id": "B003425032",
      "tipo": "SUPERIOR",
      "color1": "#db644a",
      "color2": "",
      "material": "ALGODON",
      "trama": "LISA"
    }
}
```

> HTTP Status Codes

- `201`: Si logra crear la prenda exitosamente.
- `400`: Si falla la validacion del request
- `401` / `403`: Si no tiene permisos para agregar prendas al guardarropas
- `404`: Si no existe el usuario o guardarropas
- `500`: Para cualquier error del server
- `503`: Servicio no disponible

### Ver una prenda en particular que tengo en mi guardarropas para poder editarla

`GET /users/:user/guardarropas/:guardarropa/prendas/:prenda`

> REQUEST JSON

Deberia el id de la prenda, junto al guardarropas donde se agrega y el usuario que le crea.

```JSON
{
  "user": "admin",
  "guardarropa": "dummy",
  "prenda": "B003425032"
}
```

> JSON RESPONSE

Deberia devolver los datos de la prenda

```JSON
{
  "prenda":  {
      "_id": "B003425032",
      "tipo": "SUPERIOR",
      "color1": "#db644a",
      "color2": "",
      "material": "ALGODON",
      "trama": "LISA"
    }
}
```

> HTTP Status Codes

- `200`: Si logra obtener la prenda exitosamente.
- `400`: Si falla la validacion del request
- `401` / `403`: Si no tiene permisos para ver las prendas del guardarropas
- `404`: Si no existe el usuario o guardarropas o prenda
- `500`: Para cualquier error del server
- `503`: Servicio no disponible

### Eliminar una prenda de mi guardarropas

> Ruta _REST_

`DELETE /users/:user/guardarropas/:guardarropa/prendas/:prenda`

> REQUEST JSON

Deberia el id de la prenda, junto al guardarropas donde se agrega y el usuario que le crea.

```JSON
{
  "user": "admin",
  "guardarropa": "dummy",
  "prenda": "B003425032"
}
```

> RESPONSE JSON

Podria ser un _empty body_

```JSON
{
}
```

> HTTP Status Codes

- `200`: Si logra eliminar la prenda exitosamente.
- `400`: Si falla la validacion del request
- `401` / `403`: Si no tiene permisos para agregar prendas al guardarropas
- `404`: Si no existe el usuario o guardarropas o guardarropa
- `409`: Si hay algun conflicto con los datos de la prenda en el servidor
- `500`: Para cualquier error del server
- `503`: Servicio no disponible
