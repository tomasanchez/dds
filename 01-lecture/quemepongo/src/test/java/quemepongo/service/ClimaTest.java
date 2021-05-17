package quemepongo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quemepongo.service.clima.AccuWeatherAPI;

/**
 * Prueba de Climas.
 *
 * @since 05.17.2021
 * @version 1.0
 */
public class ClimaTest {

    @Test
    public void climaBaires() {
        Assertions.assertDoesNotThrow(() -> {
            new AccuWeatherAPI().getWeatherForBuenosAires();
        });
    }
}
