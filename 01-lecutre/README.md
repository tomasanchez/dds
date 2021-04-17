# 01 - Design Quality

## Content

- Design Quality
- Error Handling
- FAQs
- Macowins: Q&A
- Macowins: Group talk
- Next lecture activities

## Design Qualities

### Simplicity

- Design must be understood clear, not difficult to navigate, _`keep it simple and stupid`_ (**KISS**).
- Do not add a new functionality that does not address the current problem. _`You aren't gonna neeed it`_ (**YAGNI**)

### Hardiness

In the event of inappropriate use by the user, external systems or internal failures, the system:

- MUST NOT generate inconsisten data or erratic behavoir.
- SHOULD report errors and return to a consistent state.
- FACILITATE the cause detection.

### Flexibility

Ability to reflect changes in the domain in a simple and easy way. We can see it in two axes: **extensibility** and **maintainability**.

#### Maintainability

Ability to modify existing features with the least possible effort.

#### Extensibility

Ability to add new features with little impact.

#### (Un) Coupling

Coupling is a degree of dependency between two modules / components: it is the level of knowledge that one module has over another.

##### Explicit

It is clear that an objects knows the corresponding properties of another.

##### Implicit

It is not that clear, however, it trust an expected behaviour of an object.

### Testability

Ensures that the code works correctly and is maintainable. Verifying the testability of small components will help improve the overall system.

### Cohesion

It is about how many responsibilities the component has. The more there are, the less cohesive it will be.

### Abstaction

Two main axis, **Quality** and **Quantity**.

On the one hand, good abstractions define better metaphores, falling into place into the model.

Using better abstractions, maximize two desing qualities:

- **Reusability** possibility to use a previously built module / component to solve a new problem.
- **Genericity** being able to use a previously defined module / component that can be applied to solve different problems.

### Escalability

Ease with which a system initially designed for a certain load can be adapted to support a greater load.
Support an increase on the **volume** of users, data, without much effort, related to performance.

### Performance

Evaluating how well the system makes use of available resources, the system is more efficient if it requires fewer resources to perform a certain task.
Not related with functional requirements.

## Error Handling

### What to do

- Not hide it
- Propagate them
- Treat it _ONLY IF KNOWN HOW_
- Mantain Consistency
- Mistrust outside, trust inside, (What can't be controlled, and waht can be)
- Fail fast

### Exceptions

- Delegation chain
- A component of the chain `throws` an exception.
- The exception bubbles untils it finds a `catch`.

### Call & Return

- The interface implies return an `operation state`
- Code is not syntactimant different from non-error return values.
- Implies search for alternatives to return the operation value.
- Hand-made propagation.

#### Reify

- Models result as a complex object
- Object can contain the operation value.
- Object can have behavior to know how to propagate.
- Widely used in functional languages with _pattern matching_
