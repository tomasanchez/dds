package quemepongo.model.modista;

import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.prenda.Borrador;
import quemepongo.model.prenda.Categoria;
import quemepongo.model.prenda.Prenda;
import quemepongo.model.prenda.TipoPrenda;

/**
 * Factory de Atuendos de acuerdo al clima actual.
 *
 * @version 2.0
 * @since 04.27.2021
 */
public class ModistaDeTemporada extends Modista {

    // private Pronostico pronostico = new Pronostico();

    /**
     * Fabrica una prenda de la categoria dada apto para las condiciones cliamticas pronosticadas.
     *
     * @param categoria la categoria de la prenda
     * @return una prenda apta para condiciones climáticas actuales.
     */
    private Prenda fabricarPrendaClimatica(Categoria categoria) {
        return new Borrador().setTipo(getTipoClimatico(categoria)).setMaterial(TipoMaterial.ALGODON)
                .setColor1(new Color("#GRIS")).guardarPrenda();
    }

    /**
     * Obtiene un tipo de prenda segun la categoria.
     *
     * @param categoria la categoria del tipo de prenda
     * @return un tipo de prenda apto para el clima actual.
     */
    private TipoPrenda getTipoClimatico(Categoria categoria) {
        return null;
    }

    @Override
    protected Prenda fabricarPrendaSuperior() {
        return fabricarPrendaClimatica(Categoria.SUPERIOR);
    }

    @Override
    protected Prenda fabricarPrendaInferior() {
        return fabricarPrendaClimatica(Categoria.INFERIOR);
    }

    @Override
    protected Prenda fabricarCalzado() {
        return fabricarPrendaClimatica(Categoria.CALZADO);
    }

    @Override
    protected Prenda fabricarAccesorio() {
        return fabricarPrendaClimatica(Categoria.INFERIOR);
    }

}
