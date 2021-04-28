package quemepongo;

/**
 * Factory de Uniformes del Instituto Jhonson.
 *
 * @version 1.0
 * @since 04.28.2021
 */
public class ModistaJhonson extends Modista {

    @Override
    protected Prenda fabricarPrendaSuperior() {

        Borrador bosquejo = new Borrador();
        bosquejo.especificarTipo(TipoPrenda.CAMISA);
        bosquejo.especificarMaterial(TipoMaterial.ALGODON);
        bosquejo.especificarColorPrimario(new Color("#blanco"));

        return bosquejo.guardarPrenda();
    }

    @Override
    protected Prenda fabricarPrendaInferior() {

        Borrador bosquejo = new Borrador();
        bosquejo.especificarTipo(TipoPrenda.PANTALON);
        bosquejo.especificarMaterial(TipoMaterial.ACETATO);
        bosquejo.especificarColorPrimario(new Color("#negro"));

        return bosquejo.guardarPrenda();
    }

    @Override
    protected Prenda fabricarCalzado() {

        Borrador bosquejo = new Borrador();
        bosquejo.especificarTipo(TipoPrenda.ZAPATOS);
        bosquejo.especificarMaterial(TipoMaterial.CUERO);
        bosquejo.especificarColorPrimario(new Color("#negro"));

        return bosquejo.guardarPrenda();
    }
}
