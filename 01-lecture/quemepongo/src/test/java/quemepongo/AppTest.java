package quemepongo;

import org.junit.jupiter.api.Test;
import quemepongo.model.modsita.Recomendador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertDoesNotThrow(() -> {
            new Recomendador().recomendarUniforme();
        }, "Error");
    }
}
