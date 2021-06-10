package quemepongo.model.clima;

import quemepongo.service.usuario.NotificationService;

public enum AlertaClimatica {
    /**
     * Alerta de tormenta.
     */
    TORMENTA {
        @Override
        public void notificar(NotificationService service) {
            service.notify("Se esperan Tormentas :: Lleve paraguas!");
        }
    },
    /**
     * Alerta de tormenta.
     */
    GRANIZO {
        @Override
        public void notificar(NotificationService service) {
            service.notify("Granizo!");
        }
    },
    /**
     * Alerta de nevadas.
     */
    NEVADA {
        @Override
        public void notificar(NotificationService service) {
            service.notify("Nieve");
        }
    };

    /**
     * Notifica la alerta climatica.
     *
     * @param service el servicio de noticacion
     * @since Iteración VI
     */
    public abstract void notificar(NotificationService service);
}
