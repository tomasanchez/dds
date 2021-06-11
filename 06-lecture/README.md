# 06 - Events modeling

## Events modelign

I have things...

### Actions against actions

- `A` has its own responsabilities.
- When `A` executes an own action
  - Another actions must be executed
  - This actions are responsabilities fromt another component (`B`, `C`, `D`, etc)
  - Many different actions
  - Variable actions (in time, for instanjce, etc)

#### Interactive approach

- `A` order each one of the components **what to do**
  - `A` must known specifically all tasks to be executed (hardcoding)
  - `A` also must known exactly all the components
  - `A` must known which task order to each component
  - In variation of task launched, `A` must modify itself

#### Event approach or Reactive

- `A` claims that an event has occurred
  - `A` does not know which task will be executed
  - `A` does not know generically all components (polymofirc list)
  - `A` sends the same message to all components
  - When actions does vary, `A` doesn't even know

### Events and Notifications

- `B` is subscribed to `A` news
- `A` generates events for all subscriptors
- `B` learns aevents which `A` _posted_ and does something

### Modeling Keys

- Accordance of unify message for all (each one for event)
- Polimorfic interested
- Common protoocol for subscription and unsubscription
- Responsabilities for interesteds
- **Observed** does not alter its code when interested changes
- _Fire and forget_
