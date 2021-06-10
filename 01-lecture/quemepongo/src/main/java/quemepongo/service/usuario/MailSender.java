package quemepongo.service.usuario;

public interface MailSender {

    /**
     * Sends a mail to a specific direction.
     *
     * @param address the mail address
     * @param message the mail message
     */
    public void send(String address, String message);
}
