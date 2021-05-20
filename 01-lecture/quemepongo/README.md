# Qué Me Pongo V4

## Nuevos Requerimientos

Partiendo de la [versión anterior](./02-qmp.md), ahora se pide:

- Poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.
- Recibir sugerencias de atuendos que tengan una prenda para cada categoría, , aunque a futuro podrán tener más.
- Al generar una sugerencia las prendas sean acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada.
- Configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas
- Asegurar la calidad de mi aplicación sin incurrir en costos innecesarios.

## Solución

### Conocer las condiciones climáticas.

![condicion climatica](images/qmp-iteration-4-1.png)

Existe un `Pronóstico` que permite determinar el clima del instante en el que se lo solicite.

```java
class Pronostico{

  CondicionClimatica getBuenosAires();
}
```

Éste pronóstico obtiene una `CondicionClimatica`, la cual provee **abstracción**.

```java
class CondicionClimatica{
  Temperatura temperatura;
  double precipitaciones;
  Clima clima;
}
```

La misma se conforma de `Temperatura` que abstrae los grados y la unidad de medida, además de permitir realizar las conversiones de unidades.

Por otro lado el `Clima` es determinado segun la temperatura.

### Recibir sugerencias de Atuendos

Recordemos que poseíamos un `Recomendador` de la [iteración anterior](./02-qmp.md), el cual recomendaba `Uniformes`.

![atuendos](images/qmp-iteration-4-2.png)

Notamos ciertas _repeticiones_ en cuanto a `Uniforme` y `Atuendo`, por lo cual decido en extraerlas a una clase `Conjunto`, para no crear una **herencia** que podría limitarnos.

```java
class Conjunto{
  Prenda superior;
  Prenda inferior;
  Prenda calzado;
  Prenda accesorio;
}
```

Tendremos que refactorizar los métodos de la `Factory de Prendas` presentada en la iteración anterior.

Sin embargo esto resulta muy sencillo:

Recordemos la iteración anterior poseíamos

```java
abstract class Modista{
  Uniforme fabricarUniforme(){
    return new Uniforme(fabricarPrendaSuperior(), fabricarPrendaInferior(), ...);
  }
}
```

Refactorizando...

```java
abstract class Modista{

  Uniforme fabricarUniforme(){
    return new Uniforme(fabricarConjunto());
  }

  Atuendo fabricarAtuendo(){
    return new Atuendo(fabricarConjunto());
  }

  Conjunto fabricarConjunto(){
    return new Conjunto( fabricarPrendaSuperior(),
                         fabricarPrendaInferior(),
                         ...);
  }
}
```

Por lo cual, una solución sería que el `Recomendador`utilice un `Modista` que fabrique un atuendo para recomendar.
