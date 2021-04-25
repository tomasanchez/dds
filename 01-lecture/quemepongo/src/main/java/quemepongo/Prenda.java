package quemepongo;

import java.util.Objects;

/**
 * Prendas de QuéMePongo
 *
 * @author Tomás Sánchez
 * @since 04.21.2021
 * @version 1.2
 */
public class Prenda {

    /**
     * El tipo de prenda
     *
     * @since 1.0
     */
    public final TipoPrenda tipo;

    /**
     * El color primario
     *
     * @since 1.0
     */
    public final String color1;

    /**
     * El color secundario
     *
     * @since 1.1
     */
    public String color2;

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
     * @since 1.2
     */
    public Prenda(TipoPrenda tipoPrenda, String principal, Material matnr) {
        this(tipoPrenda, principal, null, matnr);
    }

    /**
     * Instancia una prenda con dos colores
     *
     * @param tipoPrenda - el tipo de la prendas
     * @param principal  - el color principal
     * @param secundario - el color secundario
     * @param matnr      - el material con el que está hecha
     * @author Tomás Sánchez
     * @since 1.2
     */
    public Prenda(TipoPrenda tipoPrenda, String principal, String secundario, Material matnr) {
        if (Objects.isNull(principal) || Objects.isNull(tipoPrenda) || Objects.isNull(matnr))
            throw new IllegalArgumentException("El tipo, color principal y material son obligatorios");

        tipo = tipoPrenda;
        color1 = principal;
        material = matnr;
        color2 = secundario;
    }

}
