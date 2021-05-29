# Que me Pongo - Iteration V

## Requirements

> Shared Wardrobes

Keep it simple

```java
class User{

    List<Wardrobe> wardrobes;

    public User addWardrobe(wardrobe){
        wardrobes.add(wardrobe);
    }

}
```

How would it be used?

```
> myWardrobe = new Wardrobe()
> roli.addWardrobe(myWardrobe)
> frank.addWardrobe(myWardrobe)
```

> Criteria for Wardrobes

```java
class Wardrobe{
    // Do not model a Criteria criteria - it is not needed
    String criteria;
}
```

> Propposals

```java
class User{
    List<Propposals> propposals;

    addPropposal(Propposal propposal){
        proposals.add(propposal);
    }
}
```

or they could be inside `Wardrobe`

```java
class Wardrobe{

    List<Propposals> propposals;

    addPropposal(Propposal propposal){
        proposals.add(propposal);
    }
}
```

> Accept Propposals

```java
class Wardrobe{

    acceptPropposal(Propposal propposal){
        propposal.accept(this);
    }

}
```

> Undo propposals

```java
class Wardrobe{

    undoPropposal(Propposal propposal){
        propposal.undo(this);
    }

}
```
