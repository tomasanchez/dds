# Que me Pongo - Iteration IV

## Requirements

> Be able to know the climatic conditions of Buenos Aires at a given moment

```java
new AppiWeatherAPI().getWeather();
```

> Be able to receive suggestions for outfits that have a garment for each category

```java
class Outfit{
    List<Garment> body;
    List<Garment> legs;
    List<Garment> shoes;
    List<Garment> accesories;
}
```

> Garments to be in accordance with the current temperature when generating a suggestion

```java
class User{
    // It is important to the Garments to be stored in their owner
    Set<Garment> wardrobe;

    // Fisrt instinct must be to have its logic in its class
    public Outfit suggestOutfit(){
        //...
    }
}
```

Using an abstraction...

```java

class User{
    Wardrobe wardrobe;

    public Outfit getSuggestion(){
        return this.wardrobe.suggestOutfit();
    }
}

class Wardrobe{
    Set<Garment> wardrobe;

    Outfit suggestOutfit(){
        //...
    }
}
```

> Configure different weather retrieval services easily

```java
interface WeatherService{
    BigDecimal getTemperature();
}

class AccuWeatherWehaterService{
    private api = new AccuWeatherAPI();

    @Override
    BigDecimal getTemperature(){
        // AccuWeather translation
    }
}
```

> Ensure the quality of my application without incurring unnecessary costs

Short answer `dependy injection` and `mock` when testing

```java
class WeatherServiceTest{

    @BeforeEach
    void setUpFixture(){
        WeatherService service = new MockWeatherService();
        User rolli = new User(service, ...);
    }

    @Test
    void outfitSuggestion(){
        service.setWeather(Weather.COLD);
        Outfit outfit = roli.suggestOutfit();
        assertTrue( outfit.anyGarment( g -> g.typeIs(Type.JACKET)), true)

    }
}
```
