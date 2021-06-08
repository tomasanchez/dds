package quemepongo.api.clima.accuweather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import quemepongo.model.clima.CondicionClimatica;
import quemepongo.model.clima.GradoTemperatura;
import quemepongo.model.clima.Temperatura;

public class AccuWeatherAdapterTest {

    private AccuWeatherAdapter adapter;

    @BeforeEach
    void initAdapter() {
        adapter = new AccuWeatherAdapter();
    }

    @Test
    void testGetCondicionClimatica() {
        Assertions.assertEquals(CondicionClimatica.class,
                adapter.getCondicionClimatica("Buenos Aires").getClass());
    }

    @Test
    void esFarenheit() {
        Temperatura temperatura = adapter.getCondicionClimatica("Buenos Aires").getTemperatura();
        Assertions.assertEquals(GradoTemperatura.FAHRENHEIT, temperatura.getUnidad());
    }

    @Test
    void esValorDefault57() {
        Temperatura temperatura = adapter.getCondicionClimatica("Buenos Aires").getTemperatura();
        Assertions.assertEquals(57, temperatura.getFahrenheit());
    }

    @Test
    void noHayProbabilidadesDeLluviaPorDefault() {
        CondicionClimatica pronostico = adapter.getCondicionClimatica("Buenos Aires");
        Assertions.assertEquals(0, pronostico.getPrecipitaciones());
    }
}
