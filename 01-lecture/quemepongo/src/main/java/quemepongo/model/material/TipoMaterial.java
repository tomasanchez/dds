package quemepongo.model.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dominios de Tipo de Material.
 *
 * @version 1.0
 * @since 04.25.2021
 */
public enum TipoMaterial {
    /**
     * Material de Jean.
     */
    JEAN("LISA,ESTAMPADO"),
    /**
     * Material de Algodón.
     */
    ALGODON("LISA,LUNARES,A_CUADROS"),
    /**
     * Material de Lino.
     */
    LINO("LISA"),
    /**
     * Material de Cuero.
     */
    CUERO("A_CUADROS,LISA,ESTAMPADO"),
    /**
     * Material de Polliester.
     */
    POLLIESTER("LISA,RAYADA,LUNARES,A_CUADROS,ESTAMPADO"),
    /**
     * Material de Acetato.
     */
    ACETATO("LISA");

    /**
     * Las tramas admitidas.
     *
     * @since 1.0
     */
    private List<TramaTela> tramas;

    /**
     * Crea un material con las tramas admitidas indicados.
     *
     * @param tramas las tramas admitidas
     * @since 1.0
     */
    TipoMaterial(String tramas) {
        String[] tramasAdmitidasStr = tramas.split(",");
        this.tramas = new ArrayList<TramaTela>();
        Arrays.stream(tramasAdmitidasStr).map(str -> TramaTela.valueOf(str))
                .forEach(trama -> this.tramas.add(trama));
    }

    /**
     * Verifica si el material acepta la trama indicada.
     *
     * @param trama la trama que busca ser admitida
     * @return si el material admite la trama en cuestión
     * @since 1.0
     */
    public boolean admiteTrama(TramaTela trama) {
        return trama.equals(TramaTela.LISA) ? true : tramas.stream().anyMatch(t -> t.equals(trama));
    }
}
