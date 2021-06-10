package quemepongo.service.clima;

import quemepongo.repositories.AlertasPublicadas;

public class PublicadorDeAletartas {

    ServicioMetereologico serviceMetereologico = ServicioMetereologico.defaultService();
    AlertasPublicadas repositorio;

    public ServicioMetereologico getServiceMetereologico() {
        return serviceMetereologico;
    }

    public PublicadorDeAletartas setServiceMetereologico(
            ServicioMetereologico serviceMetereologico) {
        this.serviceMetereologico = serviceMetereologico;
        return this;
    }

    public AlertasPublicadas getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(AlertasPublicadas repositorio) {
        this.repositorio = repositorio;
    }

    public PublicadorDeAletartas actualizarAlertas() {
        getServiceMetereologico().getAlertas("Buenos Aires").addAll(getRepositorio().getAlertas());
        return this;
    }

}
