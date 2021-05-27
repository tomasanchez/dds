package quemepongo.model.usuario.guardarropa;

import java.util.Set;
import quemepongo.model.prenda.Prenda;

/**
 * Sugerencias de modificacion remover de guardarropas.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class SugerenciaQuitar extends SugerenciaGuardarropa {

    /**
     * Sugiere eliminar una prenda del guardarropa.
     *
     * @param cambioSugerido
     */
    public SugerenciaQuitar(Prenda cambioSugerido) {
        super(cambioSugerido);
    }

    @Override
    protected void aceptarSugerencia(Set<Prenda> prendas) {
        prendas.remove(getCambioSugerido());
    }

    @Override
    protected void deshacerSugerencia(Set<Prenda> prendas) {
        // TODO Auto-generated method stub

    }

}
