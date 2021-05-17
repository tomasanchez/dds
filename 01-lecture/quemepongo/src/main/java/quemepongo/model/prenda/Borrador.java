package quemepongo.model.prenda;

import java.util.Objects;
import quemepongo.model.material.Color;
import quemepongo.model.material.TipoMaterial;
import quemepongo.model.material.TramaTela;

/**
 * Builder de prendas.
 *
 * @since 04.27.2021
 * @version 1.0
 */
public class Borrador {

    /**
     * El tipo de la prenda a constuir.
     *
     * @since 1.0
     */
    private TipoPrenda tipo;

    /**
     * El tipo del material de la prenda a constuir.
     *
     * @since 1.0
     */
    private TipoMaterial material;

    /**
     * La trama del material de la prenda a constuir.
     *
     * @since 1.0
     */
    private TramaTela trama;

    /**
     * El color principal de la prenda a constuir.
     *
     * @since 1.0
     */
    private Color color1;

    /**
     * El color secundario de la prenda a constuir.
     *
     * @since 1.0
     */
    private Color color2;

    /**
     * Borrador desde cero.
     *
     * @since 1.0
     */
    public Borrador() {
        this(null);
    }

    /**
     * Borrador de una prenda de acuerdo a un template.
     *
     * @param template El blueprint de la prenda.
     * @since 1.0
     */
    public Borrador(Prenda template) {
        if (!Objects.isNull(template)) {
            this.tipo = template.tipo;
            this.material = template.getMaterial();
            this.trama = template.getTrama();
            this.color1 = template.color1;
            this.color2 = template.color2;
        }
    }

    /**
     * De ser posible guarda la prenda borrador.
     *
     * @since 1.0
     */
    public Prenda guardarPrenda() {
        return new Prenda(tipo, material, trama, color1, color2);
    }

    public TipoPrenda getTipo() {
        return tipo;
    }

    public TipoMaterial getMaterial() {
        return material;
    }

    public TramaTela getTrama() {
        return trama;
    }

    public Color getColor1() {
        return color1;
    }

    public Color getColor2() {
        return color2;
    }

    public Borrador setTipo(TipoPrenda t) {
        this.tipo = t;
        return this;
    }

    public Borrador setMaterial(TipoMaterial m) {
        this.material = m;
        return this;
    }

    public Borrador setTrama(TramaTela t) {
        this.trama = t;
        return this;
    }

    public Borrador setColor1(Color color) {
        this.color1 = color;
        return this;
    }

    public Borrador setColor2(Color color) {
        this.color2 = color;
        return this;
    }

}
