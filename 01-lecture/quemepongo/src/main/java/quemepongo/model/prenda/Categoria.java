package quemepongo.model.prenda;

/**
 * Dominio de categorías de Prendas.
 *
 * @author Tomás Sánchez
 * @since 04.20.2021
 * @version 1.0
 */
public enum Categoria {

    /**
     * Categoria de Prendas Accesorios.
     */
    ACCESORIOS("Accesorios"),
    /**
     * Categoria de Prendas Superiores.
     */
    SUPERIOR("Prenda Superior"),
    /**
     * Categoria de Prendas Inferiores.
     */
    INFERIOR("Prenda Inferior"),
    /**
     * Categoria de Prendas Calzado.
     */
    CALZADO("Calzado");

    /**
     * La etiqueta a mostrar.
     *
     * @since 1.0
     */
    private final String label;

    /**
     * Genera una categoría con la una etiqueta o label.
     *
     * @param nombre la etiqueta de la categoría.
     * @since 1.0
     */
    Categoria(String nombre) {
        this.label = nombre;
    }

    /**
     * Obtiene el label de una categoría.
     *
     * @return la etiqueta de la categoría.
     * @since 1.0
     */
    @Override
    public String toString() {
        return this.label;
    }

}
