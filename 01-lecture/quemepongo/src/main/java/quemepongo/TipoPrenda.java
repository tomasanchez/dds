package quemepongo;

/**
 * Tipos de prendas
 *
 * @author Tomás Sánchez
 * @version 2.0
 * @since 04.20.2021
 */
public enum TipoPrenda {

    LENTES(Categoria.ACCESORIOS), REMERA_MANGAS_CORTAS(Categoria.SUPERIOR), CAMISA(Categoria.SUPERIOR),
    JEANS(Categoria.INFERIOR);

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
     * @since 1.0
     */
    Categoria categoria() {
        return this.categoria;
    }

    /**
     *
     * Inicia
     *
     * @since 2.0
     */
    TipoPrenda(Categoria cat) {
        categoria = cat;
    }
}
