package quemepongo.service.clima;

import java.util.List;
import quemepongo.model.clima.AlertaClimatica;
import quemepongo.repositories.AlertasPublicadas;
import quemepongo.service.usuario.LauncherDeSugerenciaDiaria;
import quemepongo.service.usuario.MailSender;
import quemepongo.service.usuario.NotificationService;

public class PublicadorDeAlertas {

    ServicioMetereologico serviceMetereologico = ServicioMetereologico.defaultService();
    AlertasPublicadas repositorio;
    LauncherDeSugerenciaDiaria sugerenciasLauncher;
    NotificationService notificationService;
    MailSender mailSender;

    public PublicadorDeAlertas(ServicioMetereologico serviceMetereologico,
            AlertasPublicadas repositorio, LauncherDeSugerenciaDiaria sugerenciasLauncher,
            NotificationService notificationService, MailSender mailSender) {
        this.serviceMetereologico = serviceMetereologico;
        this.repositorio = repositorio;
        this.sugerenciasLauncher = sugerenciasLauncher;
        this.notificationService = notificationService;
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
        notificarAlertas(alertas);
        alertas.addAll(getRepositorio().getAlertas());
        actualizarSugerencias();
        return this;
    }

    private void actualizarSugerencias() {
        getSugerenciasLauncher().sugerirAtuendos();
    }

    private void notificarAlertas(List<AlertaClimatica> alertas) {
        alertas.forEach(alerta -> alerta.notificar(notificationService));
        enviarMailDeAlertas(alertas);
    }

    private void enviarMailDeAlertas(List<AlertaClimatica> alertas) {
        alertas.forEach(alerta -> {
            List<String> mails = getSugerenciasLauncher().getRepositorio().getMails();
            mails.forEach(mail -> alerta.notificar(mailSender, mail));
        });
    }
}
