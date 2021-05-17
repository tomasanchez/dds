package quemepongo.model.prenda;

import java.util.Objects;
import quemepongo.model.material.Color;
import quemepongo.model.material.Material;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.material.TramaTela;

/**
 * Prendas de QuéMePongo.
 *
 * @author Tomás Sánchez
 * @since 04.21.2021
 * @version 2.0
 */
public class Prenda {

    /**
     * El tipo de prenda.
     *
     * @since 1.0
     */
    private TipoPrenda tipo;

    /**
     * El color primario.
     *
     * @since 1.0
     */
    private Color color1;

    /**
     * El color secundario.
     *
     * @since 1.1
     */
    private Color color2;

    /**
     * El material con que está hecho la prenda.
     *
     * @since 1.0
     */
    private Material material;

    /**
     * Instancia una prenda de un único color.
     *
     * @param tipoPrenda el tipo de prenda a crear
     * @param material el tipo de material
     * @param color1 el color principal
     * @since Iteracion 2
     */
    public Prenda(TipoPrenda tipoPrenda, TipoMaterial material, Color color1) {
        this(tipoPrenda, material, TramaTela.LISA, color1, null);
    }

    /**
     * Instancia una prenda con dos colores.
     *
     * @param tipo el tipo de prenda a crear
     * @param material el material con el que esta hecho
     * @param trama la trama del material
     * @param color1 el color principal.
     * @param color2 el color secundario.
     */
    public Prenda(TipoPrenda tipo, TipoMaterial material, TramaTela trama, Color color1,
            Color color2) {
        // Iteración I
        if (Objects.isNull(tipo)) {
            throw new PrendaInvalida("Necesita obligatoriamente un tipo de prenda");
        }
        if (Objects.isNull(material)) {
            throw new PrendaInvalida("Necesita obligatoriamente un material");
        }
        if (Objects.isNull(color1)) {
            throw new PrendaInvalida("Necesita obligatoriamente un color principal");
        }

        // Iteración II
        if (!tipo.admiteMaterial(material)) {
            throw new PrendaInvalida("El tipo de prenda no acepta el material indicado");
        }


        this.tipo = tipo;
        this.color1 = color1;
        this.color2 = color2;
        this.material = new Material(material, trama);
    }

    /**
     * La categoría de la prenda, coincidente con la de su tipo.
     *
     * @since 1.0
     */
    public Categoria categoria() {
        return tipo.categoria();
    }

    public TramaTela getTrama() {
        return material.getTrama();
    }

    public TipoMaterial getMaterial() {
        return material.getMaterial();
    }

    public String getColor1() {
        return this.color1.getCodigo();
    }

    public String getColor2() {
        return this.color2.getCodigo();
    }

    /**
     * Setter de un material.
     *
     * @param material el material del tipo
     * @since 2.0
     */
    public void setMaterial(Material material) {
        if (!tipo.admiteMaterial(getMaterial())) {
            throw new PrendaInvalida("El tipo de prenda no acepta el material indicado");
        } else {
            this.material = material;
        }
    }

    /**
     * Excepciom de Prendas de QuéMePongo.
     *
     * @author Tomás Sánchez
     * @since 04.21.2021
     * @version 2.0
     */
    public static class PrendaInvalida extends RuntimeException {
        public PrendaInvalida(String causa) {
            super("Prenda Inválida:" + causa);
        }
    }
}
