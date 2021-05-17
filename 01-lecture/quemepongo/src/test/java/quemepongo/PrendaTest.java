package quemepongo;

import org.junit.jupiter.api.Test;
import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.material.TramaTela;
import quemepongo.model.prenda.Prenda;
import quemepongo.model.prenda.TipoPrenda;
import quemepongo.model.prenda.Prenda.PrendaInvalida;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testeo de Prendas.
 *
 * @version 1.0
 * @since 04.28.2021
 */
public class PrendaTest {

    @Test
    public void noPrendasVacias() {

        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(null, null, null);
        });

        assertThrows(PrendaInvalida.class, () -> {
            new Prenda(null, null, null, null, null);
        });
    }

    @Test
    public void prendaConTramaDefaultLisa() {
        assertTrue(prendaSinOnda(TipoPrenda.CAMISA, TipoMaterial.ALGODON).getTrama()
                .equals(TramaTela.LISA));
    }

    /**
     * Crea una prenda sin onda, lisa y gris.
     *
     * @param tipo el tipo de Prenda
     * @param material el tipo de material
     * @return Una prenda sin onda: lisa y gris.
     */
    private static Prenda prendaSinOnda(TipoPrenda tipo, TipoMaterial material) {
        return new Prenda(tipo, material, new Color("#gris"));
    }

}
