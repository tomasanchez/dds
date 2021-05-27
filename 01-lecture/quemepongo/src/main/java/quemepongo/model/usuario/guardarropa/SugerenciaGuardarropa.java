package quemepongo.model.usuario.guardarropa;

import java.util.Set;
import quemepongo.model.prenda.Categoria;
import quemepongo.model.prenda.Prenda;

/**
 * Sugerencias de modificacion de guardarropas.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public abstract class SugerenciaGuardarropa {

    private Prenda cambioSugerido;

    /**
     * Sugiere una prenda a cambiar
     *
     * @param cambioSugerido la prenda a eliminar
     */
    public SugerenciaGuardarropa(Prenda cambioSugerido) {
        this.cambioSugerido = cambioSugerido;
    }

    public Prenda getCambioSugerido() {
        return cambioSugerido;
    }

    public void setCambioSugerido(Prenda cambioSugerido) {
        this.cambioSugerido = cambioSugerido;
    }

    public Categoria categoria() {
        return this.cambioSugerido.categoria();
    }

    /**
     * Acepta los cambios de una sugerencia.
     *
     * @param prendas el listado sobre el cual efectivizar.
     * @since Iteración V
     */
    protected abstract void aceptarSugerencia(Set<Prenda> prendas);

    /**
     * Deshace los cambios de una sugerencia.
     *
     * @param prendas el listado sobre el cual efectivizar.
     * @since Iteración V
     */
    protected abstract void deshacerSugerencia(Set<Prenda> prendas);
}
