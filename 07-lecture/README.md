# 07 - Events modeling

Things happen to me... AGAIN.

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
