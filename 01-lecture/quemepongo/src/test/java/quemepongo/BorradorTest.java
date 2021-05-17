package quemepongo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.material.TramaTela;
import quemepongo.model.prenda.Borrador;
import quemepongo.model.prenda.Prenda;
import quemepongo.model.prenda.TipoPrenda;
import quemepongo.model.prenda.Prenda.PrendaInvalida;

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
        bosquejo.especificarTipo(TipoPrenda.CAMISA);
        bosquejo.especificarMaterial(TipoMaterial.ALGODON);
        bosquejo.especificarColorPrimario(colorPrueba());

        Prenda camisaAlgodonGris =
                new Prenda(TipoPrenda.CAMISA, TipoMaterial.ALGODON, colorPrueba());
        Prenda guardada = bosquejo.guardarPrenda();

        // Mismo color
        assertTrue(camisaAlgodonGris.color1.codigo.equals(guardada.color1.codigo));
        // Misma trama y además la trama es LISA.
        assertTrue(camisaAlgodonGris.getTrama().equals(guardada.getTrama())
                && esTramaDefault(guardada));
        // Mismo material
        assertTrue(camisaAlgodonGris.material.nombre.equals(guardada.material.nombre));
        // Mismo tipo
        assertTrue(camisaAlgodonGris.tipo.equals(guardada.tipo));
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
