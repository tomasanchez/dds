package quemepongo.model.clima;

import quemepongo.service.usuario.MailSender;
import quemepongo.service.usuario.NotificationService;

public enum AlertaClimatica {
    /**
     * Alerta de tormenta.
     */
    TORMENTA("Se esperan Tormentas :: Lleve paraguas!"),
    /**
     * Alerta de tormenta.
     */
    GRANIZO("Alerta de Granizo! :: Evite el uso de automóviles"),
    /**
     * Alerta de nevadas.
     */
    NEVADA("Se esperan nevadas!");

    private final String MSG;

    public String getMessage() {
        return this.MSG;
    }

    AlertaClimatica(String msg) {
        this.MSG = msg;
    }

    /**
     * Notifica la alerta climatica.
     *
     * @param service el servicio de noticacion
     * @since Iteración VI
     */
    public AlertaClimatica notificar(NotificationService service) {
        service.notify(getMessage());
        return this;
    }

    public AlertaClimatica notificar(MailSender service, String mail) {
        service.send(mail, getMessage());
        return this;
    }
}
