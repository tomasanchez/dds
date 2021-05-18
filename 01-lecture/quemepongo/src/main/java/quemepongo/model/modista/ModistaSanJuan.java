package quemepongo.model.modista;

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
        bosquejo.setTipo(TipoPrenda.CHOMBA);
        bosquejo.setMaterial(TipoMaterial.ALGODON);
        bosquejo.setColor1(new Color("#verde"));

        return bosquejo.guardarPrenda();
    }

    @Override
    protected Prenda fabricarPrendaInferior() {

        Borrador bosquejo = new Borrador();
        bosquejo.setTipo(TipoPrenda.PANTALON);
        bosquejo.setMaterial(TipoMaterial.ACETATO);
        bosquejo.setColor1(new Color("#gris"));

        return bosquejo.guardarPrenda();
    }

    @Override
    protected Prenda fabricarCalzado() {

        Borrador bosquejo = new Borrador();
        bosquejo.setTipo(TipoPrenda.ZAPATILLAS);
        bosquejo.setMaterial(TipoMaterial.CUERO);
        bosquejo.setColor1(new Color("#blanco"));

        return bosquejo.guardarPrenda();
    }

}
