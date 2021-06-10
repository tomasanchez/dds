package quemepongo.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import quemepongo.model.usuario.Usuario;
import quemepongo.model.usuario.guardarropa.Guardarropa;

/**
 * Repositorio de Usuario de Que me Pongo.
 *
 * @since 06.10.2021
 * @version 1.0
 */
public class UsuariosRegistrados {

    List<Usuario> usuarios = new ArrayList<Usuario>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public UsuariosRegistrados setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
        return this;
    }

    /**
     * Obtiene todos los guardarropas de los usuarios
     *
     * @return listado de guardarropas
     * @since Iteración VI
     */
    public List<Guardarropa> getAllGuardarropas() {
        List<Guardarropa> guardarropas = new ArrayList<Guardarropa>();
        getUsuarios().stream().map(Usuario::getAllGuardarropas).collect(Collectors.toList())
                .forEach(list -> list.addAll(guardarropas));
        return guardarropas;
    }


    public List<String> getMails() {
        return getUsuarios().stream().map(Usuario::getMail).collect(Collectors.toList());
    }
}
