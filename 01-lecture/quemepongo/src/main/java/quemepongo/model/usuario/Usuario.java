package quemepongo.model.usuario;

import java.util.HashMap;
import java.util.Map;
import quemepongo.model.usuario.guardarropa.Guardarropa;

/**
 * Usuario de Que me Pongo.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class Usuario {

    /**
     * Guardarropas propios.
     *
     * @since Iteración V
     */
    private Map<String, Guardarropa> misGuardarropas = new HashMap<String, Guardarropa>();

    /**
     * Guardarropas Compartidos.
     *
     * @since Iteración V
     */
    private Map<Usuario, Map<String, Guardarropa>> guardarropasDeOtros =
            new HashMap<Usuario, Map<String, Guardarropa>>();


    /**
     * Obtiene el guardarropas del criterio.
     *
     * @param criterio el criterio del guardarropas.
     * @return el guardarropas.
     * @since Iteración V
     */
    public Guardarropa getGuardaropa(String criterio) {
        return misGuardarropas.get(criterio);
    }

    /**
     * Añade un guardarropas nuevo.
     *
     * @param criterio el criterio de agrupación.
     * @param guardarropa el guardarropas.
     * @return el usuario.
     * @since Iteración V
     */
    public Usuario nuevoGuardarropa(String criterio) {
        misGuardarropas.put(criterio, new Guardarropa());
        return this;
    }

    /**
     * Añade un guardarropas compartido.
     *
     * @param usuario el usuario que lo comparte.
     * @param criterio el criterio del guardarropas.
     * @return el usuario.
     * @since Iteración V
     */
    public Usuario agregarGuardarropaAjeno(Usuario usuario, String criterio) {

        siNoExisteAgregarCompartido(usuario);

        agregarGuardarropaCompartido(usuario, criterio);

        return this;
    }

    /**
     * De no existir entrada para el usuario, la crea.
     *
     * @param usuario el usuario que comparte guardarropas.
     * @since Iteración V
     */
    private void siNoExisteAgregarCompartido(Usuario usuario) {
        if (!guardarropasDeOtros.containsKey(usuario)) {
            guardarropasDeOtros.put(usuario, new HashMap<String, Guardarropa>());
        }
    }

    /**
     * Agrega al la entrada de usuario un guardarr
     *
     * @param usuario el usuario compartidor
     * @param criterio el criterio del guardarropa
     * @since Iteración V
     */
    private void agregarGuardarropaCompartido(Usuario usuario, String criterio) {

        Map<String, Guardarropa> guardarropas = this.guardarropasDeOtros.get(usuario);
        Guardarropa guardarropa = usuario.getGuardaropa(criterio);
        guardarropas.put(criterio, guardarropa);
    }
}
