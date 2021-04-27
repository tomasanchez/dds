package quemepongo;

import org.junit.jupiter.api.Test;

import quemepongo.Prenda.PrendaInvalida;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PrendaTest {

    @Test
    public void noPrendasNulls() {

        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(null, null, null);
        });

        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(null, null, null, null, null);
        });
    }
}
