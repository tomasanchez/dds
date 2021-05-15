# 03 - Control, Refactors and Dependency Injection

## Content

- Control Inversion
- Dependency Injection
- Refactors
  - Code Smells

## Control Inversion

_Or When the controlled controls the controller_.

Direct vs Inverse control. Where could it be used?

Example, as **direct control**

```js
class Cloth {
  pay(paymentMethod) {
    price = this.base - discount;
    paymentMethod.authorizePayment(price);
  }
}

// >> shirt.pay(payPal)
```

now **inverting control**

```js
class Prenda implements Payable {
  @Override
  autorizatedPrice() {
    return this.base - discount;
  }
}

// >> payPal.authorizeItem(item)

// Somewhere...
class PayPal{
    aturhizeItem(Payable item){
        authorizePayment(item.autorizatedPrice());
    }
}
```

This approach will be useful when there is a need of code reciclying or executing certain methods in an established order. See _frameworks_, where there are `client code`, a generic code block, for example when using `JUnit`, our code is the `client code` of _JUnit_.

## Dependency Injection

_Obtaining what I need_

```java
class User{
    //...
    List<Suggestion> generateSuggerstion(){
        return generator.generateFor(cloths);
    }

    boolean isTheUser(String username){
        return userName.equals(username);
    }
}
```

Dependencies:

- Are the valued need for the obejct's behavior
- Do not change

Checking out the code snippet, `generator`, `this.userName`, and `cloths`, some are of trivial obtainable, meanwhile, others are context dependant.

for example...

```java
class User{

    List<Cloth> cloths;
    String userName;

    //...
    List<Suggestion> generateSuggerstion(){
        return generator.generateFor(this.cloths);
    }

    boolean isTheUser(String username){
        return this.userName.equals(username);
    }
}
```

An approach to resolve `generator` could be using a **Singleton**.

```java
class Suggester{
    static Suggester INSTANCE = new Suggester();

    static Suggester getInstance(){ return INSTANCE; }

    List<Suggestion> generateFor(List<Cloths>){
        //...
    }
}
```

## Refactoring

_Change management_.

**Acepting changes**...

Patchs

- Faster
- Short legs

Refactors:

- Longer (deeper)
- Longer duration

What is **refactoring**?

- Design adaptation.
- Mantaining requirements (functionals or not)
- Small steps.

### Code smells

- Commons and sometimes namable.
- Potentially design problem.
- Not necessarily wrong.
