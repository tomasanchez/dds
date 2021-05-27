# 04 - Design of Interfaces between components. Testing

## Content

- Testing
- Interfaces between components
- FAQs
- QMP
- Activities

## Testing

Don't you taste your _guiso_ when you're cooking?

### Why do we test?

- Validate correct behavior
- Find bugs

> A good test **finds** bugs

### Integration Grade

- Unit
- Integration
  - Low
  - High
  - End to End

### Automation Grade

- Manual
- Semi-automatic
- Automatic

### Styles

- Unit or Assert per test
- Spec or _behavoural_
- Etc...

### Quality

- Maintainability
- Strcuture
- Fixture
- Independecy

### Impostor

- Mocks/stubs/etc
- Respects interface
- Fills _voids_
- Avoids reliance upon real implementation
- Verifies behavior

### FAQs

_Mock_ vs _Stub_. The difference relies on what can you do with both of them.

Example

```java
class Company{
    String name;
    Integer numberOfEmployees;

    public List<Taxes> taxesToPay(){
        return getTaxCategory().getTaxes()
    }

    public TaxCategory categorize();{
        // Method stub
        // TODO: complete this
        return TaxCategory.MEDIUM;
    }
}

class TaxCategory{
    LOW, MEDIUM, HIGH;
}
```

Another example, extracting method to another class...

```java
interface TaxRegulator{
    TaxCategory categorize();
}

// For test, and only Test
public class TaxRegulatorMock implements TaxRegulator{
    @Override
    public TaxCategory categorize(){
        return TaxCategory.MEDIUM;
    }
}
```

### Mockito

Tasty mocking framework for unit tests in Java

<https://site.mockito.org/>

## Interfaces between components

How to connect things and not die trying to.

- Way of connecting components
- Allows making and agreement
- Generates abstraction
- Allows abstraction of internal details
- Allows interchange

### Outgoing

How I want to speak to the world

```java
class Promotion{
    String title;
    String promotionalText;
    File image;
}

class User{
    String name;
    String mail;
}
```

```java
class Store{
    PromotionCampaing promotion;

    void promote(Promotion promo, List<User> users){
        users.forEach( user -> promotion.sendPromotion(promo, user));
    }
}
```

### Incoming Interface

How I want the World speaks to me (or I want the world to talk to me)

```java
class MailSender{
    void sendMail(String subject, String address, String body, List<File> attachments)
}
```

### Adapter

```java
class PromotionViaMail implements PromotionCampaing{
    @Override
    public void sendPromotion(Promotion promo, User user){
        new MailSender().sendMail(
            promo.getTitle(),
            user.getMail(),
            promo.getPromotionalTest(user.getName()),
            Arrays.asList(promo.getImage())
        );
    }
}
```
