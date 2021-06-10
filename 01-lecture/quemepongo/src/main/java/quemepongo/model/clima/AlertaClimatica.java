package quemepongo.model.clima;

import quemepongo.service.usuario.NotificationService;

public enum AlertaClimatica {
    /**
     * Alerta de tormenta.
     */
    TORMENTA("Se esperan Tormentas :: Lleve paraguas!") {
        @Override
        public void notificar(NotificationService service) {
            service.notify(getMessage());
        }
    },
    /**
     * Alerta de tormenta.
     */
    GRANIZO("Alerta de Granizo! :: Evite el uso de automóviles") {
        @Override
        public void notificar(NotificationService service) {
            service.notify(getMessage());
        }
    },
    /**
     * Alerta de nevadas.
     */
    NEVADA("Se esperan nevadas!") {
        @Override
        public void notificar(NotificationService service) {
            service.notify(getMessage());
        }
    };

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
    public abstract void notificar(NotificationService service);
}
