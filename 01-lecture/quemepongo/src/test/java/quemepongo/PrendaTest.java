package quemepongo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrendaTest {

    @Test
    public void prendasValidas() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Prenda(null, null, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Prenda(null, null, null, null);
        });
    }
}
