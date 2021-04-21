package quemepongo;

/**
 * Tipos de prendas
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.20.2021
 */
public class Tipo {

    /**
     * El nombre del tipo de Prenda
     *
     * @since 1.0
     */
    String nombre;

    /**
     *
     * La categoria a la que ese tipo de prenda pertenece
     *
     *
     * @since 1.0
     */
    private Categoria categoria;

    /**
     * Determina una categoría de acuerdo al tipo.
     *
     * @return la categoria del tipo
     */
    Categoria categoria() {
        return this.categoria;
    }
}
