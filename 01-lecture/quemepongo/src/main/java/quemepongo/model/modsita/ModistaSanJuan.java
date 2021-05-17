package quemepongo.model.modsita;

import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.prenda.Borrador;
import quemepongo.model.prenda.Prenda;
import quemepongo.model.prenda.TipoPrenda;

/**
 * Factory de Uniformes del Colegio San Juan.
 *
 * @version 1.0
 * @since 04.28.2021
 */
public class ModistaSanJuan extends Modista {

    @Override
    protected Prenda fabricarPrendaSuperior() {

        Borrador bosquejo = new Borrador();
        bosquejo.especificarTipo(TipoPrenda.CHOMBA);
        bosquejo.especificarMaterial(TipoMaterial.ALGODON);
        bosquejo.especificarColorPrimario(new Color("#verde"));

        return bosquejo.guardarPrenda();
    }

    @Override
    protected Prenda fabricarPrendaInferior() {

        Borrador bosquejo = new Borrador();
        bosquejo.especificarTipo(TipoPrenda.PANTALON);
        bosquejo.especificarMaterial(TipoMaterial.ACETATO);
        bosquejo.especificarColorPrimario(new Color("#gris"));

        return bosquejo.guardarPrenda();
    }

    @Override
    protected Prenda fabricarCalzado() {

        Borrador bosquejo = new Borrador();
        bosquejo.especificarTipo(TipoPrenda.ZAPATILLAS);
        bosquejo.especificarMaterial(TipoMaterial.CUERO);
        bosquejo.especificarColorPrimario(new Color("#blanco"));

        return bosquejo.guardarPrenda();
    }

}
