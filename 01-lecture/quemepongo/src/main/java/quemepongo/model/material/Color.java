package quemepongo.model.material;

/**
 * Dominio de colores
 *
 * @author Tomás Sánchez
 * @since 04.25.2021
 * @version 1.0
 */
public class Color {

    /**
     * El código hexadecimal.
     *
     * @since 1.0
     */
    String codigo;

    /**
     * Instancia un color con dicho código.
     *
     * @param codigo el código del color.
     */
    public Color(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

}
