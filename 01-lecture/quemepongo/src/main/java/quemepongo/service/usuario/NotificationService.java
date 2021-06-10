package quemepongo.service.usuario;

/**
 * Notification service.
 *
 * @since 06.10.2021
 * @version 1.0
 */
public interface NotificationService {

    /**
     * Makes a browser notification.
     *
     * @param message the notification message
     * @since Iteración VI
     */
    void notify(String message);
}
