# 05 - Reifying Behaviour

When actions are also things.

## Reify

Objecs as behavior

What is a _thing_?

`Data + Operations`

- Convert a method in an object
- Parameters as properties
- Behavior as `apply` _method_
- Not allways needed.

`Data(Parameters) + Operations (apply)`

## Synchronism

### Synchronous

- Instant execution
- Control flow taken over
- Summoner waits for it to end
- Classic object methods

### Asynchronous

- Instant or Delay execution
- _Parallel_ execution (without blocking control flow)
- Summoner does NOT wait, continues with other tasks
- They're not native, _manual modelling_

## Behaviour

Why to reify behaviour?

- Differs task execution in time
- Cancel a pending task and never execute it
- Systems implementation for rejection and acceptance
- Undo task executed
- Disengaging exeuction of control flow.
