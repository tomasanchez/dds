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
public abstract class Tentativa {

    private Prenda tentativa;

    /**
     * Sugiere una prenda a cambiar
     *
     * @param tentativa la prenda a eliminar
     */
    public Tentativa(Prenda tentativa) {
        this.tentativa = tentativa;
    }

    public Prenda getTentativa() {
        return tentativa;
    }

    public void setTentativa(Prenda tentativa) {
        this.tentativa = tentativa;
    }

    public Categoria categoria() {
        return this.tentativa.categoria();
    }

    /**
     * Acepta los cambios de una sugerencia.
     *
     * @param prendas el listado sobre el cual efectivizar.
     * @since Iteración V
     */
    protected abstract void aceptarTentativa(Set<Prenda> prendas);

    /**
     * Deshace los cambios de una sugerencia.
     *
     * @param prendas el listado sobre el cual efectivizar.
     * @since Iteración V
     */
    protected abstract void deshacerCambios(Set<Prenda> prendas);
}
