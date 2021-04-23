package quemepongo;

/**
 * Prendas de QuéMePongo
 *
 * @author Tomás Sánchez
 * @since 04.21.2021
 * @version 1.0
 */
public class Prenda {

    /**
     * El tipo de prenda
     *
     * @since 1.0
     */
    public final Tipo tipo;

    /**
     * El color primario
     *
     * @since 1.0
     */
    public final Color color1;

    /**
     * El color secundario
     *
     * @since 1.0
     */
    public Color color2 = Color.NINGUNO;

    /**
     * El material con que está hecho la prenda
     *
     * @since 1.0
     */
    public final Material material;

    /**
     * La categoría de la prenda, coincidente con la de su tipo.
     *
     * @since 1.0
     */
    public Categoria categoria() {
        return tipo.categoria();
    }

    /**
     * Instancia una prenda de un único color.
     *
     * @param tipoPrenda - el tipo de la prendas
     * @param principal  - el color principal
     * @param matnr      - el material con el que está hecha
     * @author Tomás Sánchez
     * @since 1.0
     */
    public Prenda(Tipo tipoPrenda, Color principal, Material matnr) {
        tipo = tipoPrenda;
        color1 = principal;
        material = matnr;
    }

    /**
     * Instancia una prenda con dos colores
     *
     * @param tipoPrenda - el tipo de la prendas
     * @param principal  - el color principal
     * @param secundario - el color secundario
     * @param matnr      - el material con el que está hecha
     * @author Tomás Sánchez
     * @since 1.0
     */
    public Prenda(Tipo tipoPrenda, Color principal, Color secundario, Material matnr) {
        tipo = tipoPrenda;
        color1 = principal;
        color2 = secundario;
        material = matnr;
    }

}
