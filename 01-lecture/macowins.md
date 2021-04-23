# Macowins [Solution]

In class solutions of [Macowins](../00-lecture/macowins/README.md).

## Inheritance Solution

For `Cloth` class an approach might be...

```java
abstract class Cloth{
    double ownPrice;
    abstract double price();
}

class newCloth extends Cloth{
    double price() { return ownPrice}
}

class promoCloth extends Cloth{
    double offPrice
    double price() { return ownPrice - offPrice}
}

class saleCloth exteds Cloth{
    double price() { return ownPrice * 0.5}
}

```

## Composition

Instead of inherit from `Cloth` class, the `price()` message is delegated to an instance of a class dedicated to obtain the value, in this case `Status`.

```java
public class Cloth{
    ClothType type;
    Status status;
    double price;

    public double price(){
        return status.price(price);
    }
}

public interface Status{
    double price(Cloth cloth);
}

public class newCloth implements Status{
    // Code here...
}
```

## Personal Note

I found the implementation of a `FunctionalInterface` way too interesting.

```java
@FunctionalInterface
public interface Status{
    double price(basePrice, discount);
}

public class Cloth{

    Status status;
    double price, disctount;
    public price(){
        return status.price(price, discount);
    }

    static private Status newCloth = ((p, d) -> p);
    static private Status promCloth = ((p, d) -> p - d);
    static private Status saleCloth = ((p, d) -> p * 0.5);
}
```

## Sales - With Item

```java
public class Sale{
    List<Items> items;

    double price(){ return items.sum(item -> item.price())}
}

public class Item{
    Cloth cloth;
    int quantity;
    double price(){return cloth.price() * quantity}
}
```

## Sales - No Item

```java
public class Sale{
    List<Cloth> cloths;
    double price(){ return cloths.sum( cloth -> cloth.price()) }
}
```
