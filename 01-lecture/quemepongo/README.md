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


