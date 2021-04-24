# Qué Me Pongo - Iteration I

## (Possible) Solution

Do not overthink it, not start designing without requiremnts.

Example

```java
class User{
    List<Cloth> cloths;

    void loadCloths(){
        // Unknown behavior ...
    }
}
```

Remember _KISS_

We will try to avoid using `string` to implement the cloth's `types`, mainly because we might want to add some behavior to this.

```java
class Cloth{
    String clothType;
}

// Intead...

class Cloth{
    ClothType type;
}
```

Then there are many ways to implement `ClothTypes`, it is not recommend to use inheritance in this case due to the considerable amount of possible _types_. For this iteration we will use `enums`.
This exactly concept will also apply to `Material`.

With `Color` there is a special case, as this is key to the requirements. As there are a large amount of colors. We will adopt a standard of `#RGB`, using the type `String`, as this is an inside behaviour, validation will not be necessary.

A more flexible approach would be using a `Color` class where the color `code` is a `String`

```java
class Color{
    String code;
}
```

**HOWEVER**, we end with a `class` with no behaviour, but, it provides **ABSTACTION**.

As a `Cloth` will be immutable, there is no need to use the keyword `final`, not defining _setters_ is enough.

```java
class Cloth{
    ClothType type;
    Material material;
    Color color1;
    Color color2;
}
```

For validation we should create a `domain exception`. For example...

```java
public InvalidCloth extends RuntimeException{
    public InvalidCloth(String cause){
        super("Cloth is invalid: " + cause);
    }
}
```

**Note** that we should _allways_ `extend` from `RuntimeException`, to avoid checking if it is catched.

### Recommendations

Approach:

- Cloth validation in Cloth class
- If for validations are OK
- Allways extend from RuntimeException
- Normalize computable data (no replication)
- Avoid errors instead of detecting them.
