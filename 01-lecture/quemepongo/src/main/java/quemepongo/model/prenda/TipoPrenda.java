package quemepongo.model.prenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import quemepongo.model.clima.Clima;
import quemepongo.model.material.TipoMaterial;

/**
 * Tipos de prendas.
 *
 * @author Tomás Sánchez
 * @version 3.0
 * @since 04.20.2021
 */
public enum TipoPrenda {

    /**
     * Tipo Lentes (Accesorio).
     */
    LENTES(Categoria.ACCESORIOS),
    /**
     * Tipo Remera (Superior).
     */
    REMERA_MANGAS_CORTAS(Categoria.SUPERIOR),
    /**
     * Tipo Camisa (Superior).
     */
    CAMISA(Categoria.SUPERIOR),
    /**
     * Tipo Chomba (Superior).
     */
    CHOMBA(Categoria.SUPERIOR),
    /**
     * Tipo Pantalon (Inferior).
     */
    PANTALON_JEAN(Categoria.INFERIOR, "JEAN"),
    /**
     * Tipo Pantalon (Inferior).
     */
    PANTALON(Categoria.INFERIOR, "ALGODON,ACETATO"),
    /**
     * Tipo Zapatos (Inferior).
     */
    ZAPATOS(Categoria.CALZADO, "CUERO"),
    /**
     * Tipo Zapatillas (Inferior).
     */
    ZAPATILLAS(Categoria.CALZADO, "CUERO");

    /**
     * La categoria a la que ese tipo de prenda pertenece.
     *
     *
     * @since 1.0
     */
    private Categoria categoria;

    /**
     * El clima para el cual está pensado la prenda.
     *
     * @since Iteración IV
     */
    private Clima clima;

    /**
     * Listado de materiales admitidos por el tipo de prenda.
     *
     * @since 3.0
     */
    private List<TipoMaterial> materiales = new ArrayList<TipoMaterial>();

    /**
     * Tipos de prenda.
     *
     * @param cat la categoría correspondiente
     * @since 2.0
     */
    TipoPrenda(Categoria cat) {
        this(cat, cat.equals(Categoria.CALZADO) ? "" : "ALGODON");
    }

    /**
     * Prenda con Categoria y Clima.
     *
     * @param cat la categoria a la que pertenece
     * @param clima el clima para el cual es apto
     * @since Iteración IV
     */
    TipoPrenda(Categoria cat, Clima clima) {
        this(cat, cat.equals(Categoria.CALZADO) ? "" : "ALGODON", clima);
    }

    /**
     * Tipo de prenda que admite materiales.
     *
     * @param categoria la categoria del tipo de prenda
     * @param materiales los materiales que admite
     */
    TipoPrenda(Categoria categoria, String materiales) {
        this(categoria, materiales, null);
    }

    /**
     * Tipo de prendas que admite clima y materiales.
     *
     * @param categoria La categoría a la que pertenece
     * @param materiales los materiales que soporta
     * @param clima el clima para el cual es apta.
     * @since Iteración IV
     */
    TipoPrenda(Categoria categoria, String materiales, Clima clima) {
        this.categoria = categoria;
        agregarMateriales(materiales);
        this.clima = clima;
    }

    /**
     * Agrega un string de materiales a la lista.
     *
     * @param materiales los materiales compatibles
     * @since Iteración IV
     */
    private void agregarMateriales(String mts) {
        String[] materialesAdmitidos = mts.split(",");
        Arrays.stream(materialesAdmitidos).map(str -> TipoMaterial.valueOf(str))
                .forEach(material -> this.materiales.add(material));
    }

    private boolean esDeCategoria(Categoria cat) {
        return this.categoria.equals(cat);
    }

    /**
     * Determina una categoría de acuerdo al tipo.
     *
     * @return la categoria del tipo
     * @since 1.0
     */
    public Categoria categoria() {
        return this.categoria;
    }

    /**
     * Determina si el tipo de prenda soporta el material.
     *
     * @param material el material a verificar.
     * @return si lo acepta o no.
     */
    public boolean admiteMaterial(TipoMaterial material) {
        return materiales.stream().anyMatch(admitido -> admitido.equals(material));
    }

    /**
     * Verifica si un tipo es apto para el clima.
     *
     * @param clim el clima a contrastar
     * @return si es apto para ese clima
     * @since Iteración IV
     */
    public boolean aptoClima(Clima clim) {
        return Objects.isNull(this.clima) || this.clima.equals(clim);
    }

    /**
     * Obtiene un tipo de prenda al azar, que cumpla con categoria y clima.
     *
     * @param categoria la categoria de la prenda
     * @param clima el clima para el cual utilizar la prenda
     * @return un Tipo de Prenda que cumple
     * @since Iteración IV
     */
    public static TipoPrenda getTipoByCategoriaYClima(Categoria categoria, Clima clima) {
        return Arrays.stream(TipoPrenda.values()).filter(t -> t.esDeCategoria(categoria))
                .filter(t -> t.aptoClima(clima)).findAny().get();
    }

}
