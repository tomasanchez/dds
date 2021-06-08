package quemepongo.model.prenda;

import org.junit.jupiter.api.Test;
import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.material.TramaTela;
import quemepongo.model.prenda.Prenda.PrendaInvalida;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pruebas de Borrador.
 *
 * @version 1.0
 * @since 04.28.2021
 */
public class BorradorTest {

    @Test
    public void noGuardarPrendasInvalidas() {
        // No se guarda una prenda Vacía
        assertThrows(PrendaInvalida.class, () -> {
            new Borrador().guardarPrenda();
        });
    }

    @Test
    public void creaRopaBien() {

        // Instancio y relleno una Prenda
        Borrador bosquejo = new Borrador();
        bosquejo.setTipo(TipoPrenda.CAMISA);
        bosquejo.setMaterial(TipoMaterial.ALGODON);
        bosquejo.setColor1(colorPrueba());

        Prenda camisaAlgodonGris =
                new Prenda(TipoPrenda.CAMISA, TipoMaterial.ALGODON, colorPrueba());
        Prenda guardada = bosquejo.guardarPrenda();

        // Mismo color
        assertTrue(camisaAlgodonGris.getColor1().equals(guardada.getColor1()));
        // Misma trama y además la trama es LISA.
        assertTrue(camisaAlgodonGris.getTrama().equals(guardada.getTrama())
                && esTramaDefault(guardada));
        // Mismo material
        assertTrue(camisaAlgodonGris.getMaterial().equals(guardada.getMaterial()));
        // Mismo tipo
        assertTrue(camisaAlgodonGris.getTipo().equals(guardada.getTipo()));
    }

    /**
     * Instancia un color de prueba.
     *
     * @return un color válido.
     */
    private Color colorPrueba() {
        return new Color("#gris");
    }

    /**
     * Verifica si posee la trama default.
     *
     * @param prenda la prenda a verificar
     * @return si posee la trama LISA.
     */
    private boolean esTramaDefault(Prenda prenda) {
        return prenda.getTrama().equals(TramaTela.LISA);
    }

}
