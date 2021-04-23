# Que Me Pongo

## Enunciado

QuéMePongo es una empresa dedicada al armado de atuendos adecuados a las condiciones climáticas y preferencias de sus clientes. El servicio que provee se basa en tomar las prendas del guardarropas de une user y generar diferentes combinaciones posibles que cubran las necesidades de les mismes en términos de distintos factores climáticos tales como temperatura, viento, sol, lluvia, etc. Asimismo, se busca que estos atuendos se adecuen de la mejor forma a las sensibilidades particulares respecto de dichos factores de cada user y a sus gustos en el aspecto estético.

## Primera Iteración

Comenzaremos definiendo que un atuendo es una combinación de prendas que tiene sentido usar juntas. Algunos ejemplos de atuendos podrían ser:

- tus anteojos de sol favoritos, una remera de mangas cortas azul, el pantalón que te regaló tu mamá y unas zapatillas converse.
- un pañuelo verde, una remera de mangas largas rayada, un pantalón de jean y un par de botas de cuero.
- una musculosa de mickey, una pollera amarilla y unas crocs.

Como primer paso para generar los atuendos, les users de QuéMePongo identificaron el siguiente requerimiento como principal:

> Como user de QuéMePongo, quiero poder cargar prendas válidas para generar atuendos con ellas.

Y luego, al consultar más sobre este requerimiento general, logramos definir que

### Como user de QuéMePongo, quiero...

- especificar qué tipo de prenda estoy cargando (zapatos, camisa de mangas cortas, pantalón, etc).
- identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).
- poder indicar de qué tela o material está hecha una prenda
- poder indicar un color principal para mis prendas
- poder indicar, si existe, un color secundario para mis prendas.
- evitar que haya prendas sin tipo, tela, categoría o color primario
- evitar que haya prendas cuya categoría no se condiga con su tipo. (Ej, una remera no puede ser calzado).

## Resolución

![Diagrama de Clases](images/que_me_pongo-cd.png)

Nótese como se dejó, por el momento, de lado el concepto de `Atuendo`, dado que en esta iteración no se especifican requirimientos, ni comportamientos relacionados a él, salvo que se compone por prendas. Sin embargo su adición no debería levantar muchos conflictos pero sí _breaking changes_.

Utilizamos `enums` para establecer un dominio de datos, si bien en el caso de `Categoría` es más evidente su necesidad, consdieramos establecerlos también para `Color` y `Material`.

### Atendiendo Requerimientos

> Especificar qué tipo de prenda estoy cargando (zapatos, camisa de mangas cortas, pantalón, etc).

Primero definiendo un _dominio de datos_ para la categoría...

```java
public enum Categoria{
  ACCESORIO,
  PARTE_SUPERIOR,
  PARTE_INFERIOR,
  CALZADO
}
```

Aplica lo mismo a los tipos de prenda. Pero además determinamos la categoría a la que se asocia un tipo.

```java
public enum Tipo{

  LENTES(Categoria.CALZADO),
  // ... TIPO(CATEGORIA)
  CAMISA(Categoria.PARTE_SUPERIOR);

  private Categoria categoria;

  public Categoria categoria();
  Tipo(Categoria cat){
    categoria = cat;
  }
}
```

```java
public class Prenda{
  public Tipo tipo;
}
```

> Identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).

Luego...

```java
public class Prenda{
  public Tipo tipo;
  public Categoria categoria(){}
}
```

> Poder indicar de qué tela o material está hecha una prenda

```java
public enum Material{
  TELA1,
  MATERIAL1,
  // Materiales o Telas...
}
```

```java
public class Prenda{
  public Tipo tipo;
  public Categoria categoria(){}
  public Material material;
}
```

> Poder indicar un color principal para mis prendas y, si existe, un color secundario para mis prendas.

Determinamos un dominio para los colores...

```java
public enum Color{
  NINGUNO
  // Colores disponibles
  // ...
}
```

Si modificamos nuestra `Prenda`

```java
public class Prenda{
  public Tipo tipo;
  public Categoria categoria(){}
  public Material material;
  public Color color1;
  public Color color2;
}
```

> Evitar que haya prendas sin tipo, tela, categoría o color primario

Para ello utilizamos el _keyword_ `final` para declarar una constante que **requiera** ser inicializada.

```java
public class Prenda{
  public final Tipo tipo;
  public Categoria categoria(){}
  public final Color color1;
  public Color color2 = Color.NINGUNO;
  public final Material material;
}
```

> Evitar que haya prendas cuya categoría no se condiga con su tipo. (Ej, una remera no puede ser calzado).

Una propuesta sería que la prenda no posea el atributo de `categoría`, sino que lo consultáse directamente de su tipo

```java
public class Prenda{
  //...
  public Categoría categoria(){
    return tipo.categoria();
  }
}
```

Entoncés, por definición, la categoría **SIEMPRE** estaría en coincidencia con el `tipo`.
