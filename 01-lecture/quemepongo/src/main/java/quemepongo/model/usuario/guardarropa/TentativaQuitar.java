package quemepongo.model.usuario.guardarropa;

import java.util.Set;
import quemepongo.model.prenda.Prenda;

/**
 * Sugerencias de modificacion remover de guardarropas.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class TentativaQuitar extends Tentativa {

    /**
     * Sugiere eliminar una prenda del guardarropa.
     *
     * @param tentativa
     */
    public TentativaQuitar(Prenda tentativa) {
        super(tentativa);
    }

    @Override
    protected void aceptarTentativa(Set<Prenda> prendas) {
        prendas.remove(getTentativa());
    }

    @Override
    protected void deshacerCambios(Set<Prenda> prendas) {
        prendas.add(getTentativa());
    }

}
