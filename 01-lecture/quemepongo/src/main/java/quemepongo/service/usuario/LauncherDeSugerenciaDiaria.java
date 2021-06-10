package quemepongo.service.usuario;

import quemepongo.model.usuario.guardarropa.Guardarropa;
import quemepongo.repositories.UsuariosRegistrados;

public class LauncherDeSugerenciaDiaria {

    UsuariosRegistrados repositorio;

    public LauncherDeSugerenciaDiaria(UsuariosRegistrados repositorio) {
        this.repositorio = repositorio;
    }

    public UsuariosRegistrados getRepositorio() {
        return repositorio;
    }

    public LauncherDeSugerenciaDiaria setRepositorio(UsuariosRegistrados repositorio) {
        this.repositorio = repositorio;
        return this;
    }

    public LauncherDeSugerenciaDiaria sugerirAtuendos() {
        repositorio.getAllGuardarropas().forEach(Guardarropa::sugerirAtuendo);
        return this;
    }

}
