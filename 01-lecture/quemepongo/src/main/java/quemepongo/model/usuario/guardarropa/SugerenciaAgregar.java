package quemepongo.model.usuario.guardarropa;

import java.util.Set;
import quemepongo.model.prenda.Prenda;

/**
 * Sugerencias de modificacion añadir de guardarropas.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class SugerenciaAgregar extends SugerenciaGuardarropa {


    /**
     * Sugiere añadir una prenda del guardarropa.
     *
     * @param cambioSugerido la prenda a añadir
     */
    public SugerenciaAgregar(Prenda cambioSugerido) {
        super(cambioSugerido);
    }

    @Override
    public void aceptarSugerencia(Set<Prenda> prendas) {
        prendas.add(getCambioSugerido());
    }

    @Override
    public void deshacerSugerencia(Set<Prenda> prendas) {
        prendas.remove(getCambioSugerido());
    }

}
