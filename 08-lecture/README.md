# 08 - MVC

## Contet

- Applications
- Presentation and responsibilities
- Graphic Interfaces
- Model View Controller

## Applications

> Beyond the domain

### Parts

- Presentation
- Domain
- Persistency

### Concerns and Responsabilities of Presentation

- Data visualization. Show, modify and update data.
- Defines navigation
- The user interface **models Use Cases**

Example

Conversor Miles to Kilometers

```
Window
    ____________________________________
    |                                  |
    |               Number             |
    |                                  |
    |       Convert to Kilometers      |
    |----------------------------------|
    |               Number             |
    |__________________________________|

Container                                       TAGS
```

### Model View Controller (MVC)

```
        presents UI
    ------------------->
View                    User
    <-------------------
            uses
```

```
    notifies user actions
    ------------------->
View                    Controller
    <-------------------
           changes
```

```
             changes
        ------------------->
Controller                  Model
        <-------------------
          notifies changes
```

### Model View View-Model

```
        DataBinding
    ------------------->
View                    ViewModel
    <-------------------
    NotifyPropertyChanged
```

```
            References
        ------------------->
ViewModel                   Model
```

The excellence of MVVM is the _two-way_ data binding.
