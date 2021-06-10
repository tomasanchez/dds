package quemepongo.service.clima;

import java.util.List;
import quemepongo.model.clima.AlertaClimatica;
import quemepongo.repositories.AlertasPublicadas;
import quemepongo.service.usuario.LauncherDeSugerenciaDiaria;

public class PublicadorDeAlertas {

    ServicioMetereologico serviceMetereologico = ServicioMetereologico.defaultService();
    AlertasPublicadas repositorio;
    LauncherDeSugerenciaDiaria sugerenciasLauncher;

    public PublicadorDeAlertas(ServicioMetereologico serviceMetereologico,
            AlertasPublicadas repositorio, LauncherDeSugerenciaDiaria sugerenciasLauncher) {
        this.serviceMetereologico = serviceMetereologico;
        this.repositorio = repositorio;
        this.sugerenciasLauncher = sugerenciasLauncher;
    }

    public ServicioMetereologico getServiceMetereologico() {
        return serviceMetereologico;
    }

    public PublicadorDeAlertas setServiceMetereologico(ServicioMetereologico serviceMetereologico) {
        this.serviceMetereologico = serviceMetereologico;
        return this;
    }

    public LauncherDeSugerenciaDiaria getSugerenciasLauncher() {
        return sugerenciasLauncher;
    }

    public void setSugerenciasLauncher(LauncherDeSugerenciaDiaria sugerenciasLauncher) {
        this.sugerenciasLauncher = sugerenciasLauncher;
    }

    public AlertasPublicadas getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(AlertasPublicadas repositorio) {
        this.repositorio = repositorio;
    }

    public PublicadorDeAlertas actualizarAlertas() {
        List<AlertaClimatica> alertas = getServiceMetereologico().getAlertas("Buenos Aires");
        alertas.addAll(getRepositorio().getAlertas());
        actualizarSugerencias();
        return this;
    }

    private void actualizarSugerencias() {
        getSugerenciasLauncher().sugerirAtuendos();
    }

}
