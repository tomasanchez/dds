package quemepongo;

import java.util.Objects;

/**
 * Builder de prendas.
 *
 * @since 04.27.2021
 * @version 1.0
 */
public class Borrador {

    TipoPrenda tipo;

    TipoMaterial material;

    TramaTela trama;

    Color color1;

    Color color2;

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
            this.material = template.material.nombre;
            this.trama = template.material.trama;
            this.color1 = template.color1;
            this.color2 = template.color2;
        }
    }

    /**
     * Setter de tipo de prenda.
     *
     * @param tipo el tipo de la prenda.
     */
    public void especificarTipo(TipoPrenda tipo) {
        this.tipo = tipo;
    }

    /**
     * Setter de material
     *
     * @param material el Tipo de material
     */
    public void especificarMaterial(TipoMaterial material) {
        this.material = material;
    }

    /**
     * Setter de color primario.
     *
     * @param color1 el color principal de la prenda.
     */
    public void especificarColorPrimario(Color color1) {
        this.color1 = color1;
    }

    /**
     * Setter de color secundario.
     *
     * @param color2 el color secundario.
     */
    public void especificarColorSecundario(Color color2) {
        this.color2 = color2;
    }

    /**
     * Setter de trama.
     *
     * @param trama la trama del material de una prenda.
     */
    public void especificarTrama(TramaTela trama) {
        this.trama = trama;
    }

    /**
     * De ser posible guarda la prenda borrador.
     *
     * @since 1.0
     */
    public Prenda guardarPrenda() {
        return new Prenda(tipo, material, trama, color1, color2);
    }
}
