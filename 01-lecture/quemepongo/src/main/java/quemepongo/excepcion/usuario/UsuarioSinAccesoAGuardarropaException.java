package quemepongo.excepcion.usuario;

/**
 * Usuario no posee acceso al gurdarropa.
 *
 * @since 05.27.2021
 * @version 1.0
 */
public class UsuarioSinAccesoAGuardarropaException extends RuntimeException {

    /**
     * Lanza una excepcion.
     *
     * @throws RuntimeException si el usuario no posee acceso al gurdarropa.
     * @since Iteracion V
     */
    public UsuarioSinAccesoAGuardarropaException() {
        super("El usuario no posee acceso al guardarropas");
    }
}
