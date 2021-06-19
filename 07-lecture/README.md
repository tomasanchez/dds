# 07 - Events modeling

Things happen to me... AGAIN.

## Content

- Going over
- Communication Patterns
  - Call & Return
  - Shared Memory
  - Exceptions
  - Events and Notifications
  - Callbacks
- Examples

## Going over

We determined that the _Event approach_ is more suitable than the _Interactive approach_.

It provides decoupling, using, for example an observer

```java

interface Observer{
    void notify(Notification notification);
}

class Observed{

    List<Observer> observer;

    void notify(Notification notification){
        observer.forEach( o ->
                o.notify(notification)
            );
    }

}

class User implements Observer{

    @Override
    void notify(Notification notification{
        getView().show(notification);
    })
}
```

## Communication Patterns

Speak louder, 'cause I have a towel.

> Let `A` and `B` be different system components.

- `A` and `B` need to colaborate.
- How `A` makes requests to `B`
- How does `B` response results to `A`.

### Call & return

- `A` calls `B` and awaits (syncrhonic)
- `B` executes the job and answers
- `A` recives `B`'s response
- No _side effects_

### Shared Memory

- `A` calls `B` (awaits or not)
- `B` executes the job and leaves the result in the shared memory
- `A` learns that `B` has produced a result (recovers control, asks or is notified)
- `A` gets the result

### Exceptions

- Delegation chain
- A component throws an exception
- Exception bubbles up to another component which catches this exception.
- The exception contains data which was communicated
- Commonly used to propagate errors

### Events and Notifications

- `A` subscribes to `B`'s updates
- `B` generates _events_ for all its subscribers
- `A` learn `B`' updates and does something

### Callbacks

- `A` calls `B`
- `A` tells `B` what to do with the result
- `A` does another job
- `B` does what `A` told it of what to do with results

### Comparissons

A practical example

```js
// We want to add two numbers and show it
```

```js
/**
 * With call and return
 */
const callAndReturn = () => {
  const add = (a, b) => a + b;

  // Main
  console.log(add(0, 6));
};
```

```js
/**
 * Sharing memory
 */
const sharedMemory = () => {
  let add = (sharedMemory, a, b) => {
    sharedMemory = a + b;
  };

  // Main
  var sharedMemory = -1;
  add(sharedMemory, 0, 6);
  console.log(sharedMemory);
};
```

```js
/**
 * Callback
 */
const sharedMemory = () => {
  const add = (a, b, fcallback) => fcallback(a + b);

  // Main
  add(0, 6, (result) => console.log(result));
};
```

---

Another example

> A Person's birthday

```js
class Person {
  name;
  age;

  constructor(name, age) {
    this.name = name;
    this.age = age;
  }
}
```

```js
/**
 * With call and return
 */
const callAndReturn = () => {
  const birthday = (person) => new Person(person.name, person.age++));

  //Main
  const roli = new Person("Roli", 27);
  console.log(birthday(roli));
};
```

```js
/**
 * Sharing memory
 */
const sharedMemory = () => {
  let birthday = (person) => {
    person.age++;
  };

  // Main
  const roli = new Person("Roli", 27);
  birthday(roli);
  console.log(roli);
};
```

---

A QMP example

```js
class AccuWeatherAPI{
    getTemperature();
}
```

```js
/**
 * Now this request may take a while
 */
const getCABATemperature = () => {
  new AccuWeatherAPI();
  getTemperature("CABA, Argentina");
};
```

```js
/**
 * Using Call back
 */
const getCABATemperature = () => {
  const API = new AccuWeatherAPI();

  setTimeout( () API.getTemperature("CABA, Argentina"), 5000);
};
```
