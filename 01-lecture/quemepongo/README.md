# Qué Me Pongo V4

## Nuevos Requerimientos

Partiendo de la [versión anterior](./04-qmp.md), ahora se pide:

- Manejar varios guardarropas para separar mis prendas según diversos criterios (ropa de viaje, ropa de entrecasa, etc).

- Poder crear guardarropas compartidos con otros usuaries (ej, ropa que comparto con mi hermane).

- Que otro usuario me proponga tentativamente agregar una prenda al guardarropas.

- Que otro usuario me proponga tentativamente quitar una prenda del guardarropas.

- Ver todas las propuestas de modificación (agregar o quitar prendas) del guardarropas y poder aceptarlas o rechazarlas...

- Poder deshacer las propuestas de modificación que haya aceptado.

## Resolución

### Manejar varios guardarropas según diversos criterios.

![varios guardarropas](images/qmp-iteration-5-1.png)

Definimos un `Usuario` como:

```java
class Usuario{

  private Map<Criterio, Guardarropa>guardarropas;

  public void nuevoGuardarropa(Criterio criterio){
    guardarropas.put(criterio, new Guardarropa());
  }
}
```

Mientras que un `Guardarropa` sería...

```java
class Guardarropa{

  private Map<Categoria, Set<Prenda>> prendas;

  public Guardarropa agregarPrenda(Prenda prenda){
    prendas.get(prenda.categoria()).put(prenda);
    return this;
  }

}
```
