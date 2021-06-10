package quemepongo.repositories;

import java.util.ArrayList;
import java.util.List;
import quemepongo.model.clima.AlertaClimatica;

/**
 * Repositorio de Usuario de Que me Pongo.
 *
 * @since 06.10.2021
 * @version 1.0
 */
public class AlertasPublicadas {
    List<AlertaClimatica> alertas = new ArrayList<AlertaClimatica>();

    public List<AlertaClimatica> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaClimatica> alertas) {
        this.alertas = alertas;
    }

    public AlertasPublicadas addAlerta(AlertaClimatica alerta) {
        getAlertas().add(alerta);
        return this;
    }

}
