package quemepongo;

import java.util.Objects;

/**
 * Prendas de QuéMePongo
 *
 * @author Tomás Sánchez
 * @since 04.21.2021
 * @version 2.0
 */
public class Prenda {

    /**
     * El tipo de prenda
     *
     * @since 1.0
     */
    public TipoPrenda tipo;

    /**
     * El color primario
     *
     * @since 1.0
     */
    public Color color1;

    /**
     * El color secundario
     *
     * @since 1.1
     */
    public Color color2;

    /**
     * El material con que está hecho la prenda
     *
     * @since 1.0
     */
    public Material material;

    /**
     * La categoría de la prenda, coincidente con la de su tipo.
     *
     * @since 1.0
     */
    public Categoria categoria() {
        return tipo.categoria();
    }

    /**
     * Getter de la trama de la prenda
     *
     * @return la trama del material.
     */
    public TramaTela getTrama() {
        return material.getTrama();
    }

    /**
     * Setter de color secundario a una prenda.
     *
     * @param color2 el color secundario a añadir.
     * @since 2.0
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    /**
     * Setter de tipo a una prenda.
     *
     * @param tipo el nuevo tipo
     * @since 2.0
     */
    public void setTipo(TipoPrenda tipo) {
        this.tipo = tipo;
    }

    /**
     * Setter de color principal a una prenda.
     *
     * @param color1 el color principal.
     * @since 2.0
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * Setter de un material.
     *
     * @param material el material del tipo
     * @since 2.0
     */
    public void setMaterial(Material material) {
        if (!tipo.admiteMaterial(material.nombre))
            throw new PrendaInvalida("El tipo de prenda no acepta el material indicado");
        else
            this.material = material;
    }

    /**
     * Instancia una prenda de un único color
     *
     * @param tipoPrenda el tipo de prenda a crear
     * @param material   el tipo de material
     * @param color1     el color principal
     * @since Iteracion 2
     */
    public Prenda(TipoPrenda tipoPrenda, TipoMaterial material, Color color1) {
        this(tipoPrenda, material, TramaTela.LISA, color1, null);
    }

    /**
     *
     * @param tipo     el tipo de prenda a crear
     * @param material el material con el que esta hecho
     * @param trama    la trama del material
     * @param color1
     * @param color2
     */
    public Prenda(TipoPrenda tipo, TipoMaterial material, TramaTela trama, Color color1, Color color2) {

        // Iteración I
        if (Objects.isNull(tipo))
            throw new PrendaInvalida("Necesita obligatoriamente un tipo de prenda");
        if (Objects.isNull(material))
            throw new PrendaInvalida("Necesita obligatoriamente un material");
        if (Objects.isNull(color1))
            throw new PrendaInvalida("Necesita obligatoriamente un color principal");

        // Iteración II
        if (!tipo.admiteMaterial(material))
            throw new PrendaInvalida("El tipo de prenda no acepta el material indicado");

        this.tipo = tipo;
        this.color1 = color1;
        this.color2 = color2;
        this.material = new Material(material, trama);
    }

    public static class PrendaInvalida extends RuntimeException {
        public PrendaInvalida(String causa) {
            super("Prenda Inválida:" + causa);
        }
    }
}
