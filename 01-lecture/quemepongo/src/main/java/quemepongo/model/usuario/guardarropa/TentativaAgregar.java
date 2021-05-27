package quemepongo.model.usuario.guardarropa;

import java.util.Set;
import quemepongo.model.prenda.Prenda;

/**
 * Tentatibvas de modificacion añadir de guardarropas.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class TentativaAgregar extends Tentativa {

    /**
     * Sugiere añadir una prenda del guardarropa.
     *
     * @param tentativa la prenda a añadir
     */
    public TentativaAgregar(Prenda tentativa) {
        super(tentativa);
    }

    @Override
    public void aceptarTentativa(Set<Prenda> prendas) {
        prendas.add(getTentativa());
    }

    @Override
    public void deshacerCambios(Set<Prenda> prendas) {
        prendas.remove(getTentativa());
    }

}
