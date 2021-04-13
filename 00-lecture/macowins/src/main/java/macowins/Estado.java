package macowins;

/**
 * Modificador de Precio es utilizado para expresiones lambda.
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.13.2021
 */
interface ModificadorDePrecio {
    double modificar(double precioBase, double descuento);
}

/**
 * Estado representa el estado que puede tener una prenda.
 *
 * @author Tomás Sánchez
 * @version 1.0
 * @since 04.13.2021
 */
public class Estado {

    /**
     * Nombre del estado
     */
    String nombre;

    /**
     * Breve descripcion del estado.
     */
    String descripcion;

    /**
     * Funcion lambda modificadora de precio
     */
    private ModificadorDePrecio modificador;

    /**
     * Crea una instancia de un estado.
     * 
     * @param estado - el nombre del estado
     * @param desc   - la descripcion del mismo
     * @param mod    - funcion modificadora de precio
     */
    public Estado(String estado, String desc, ModificadorDePrecio mod) {
        modificador = mod;
        nombre = estado;
        descripcion = desc;
    }

    /**
     * Obtiene el precio total de una prenda.
     * 
     * @param precioBase - precio sin descuentos
     * @param descuento  - descuentos a realizar
     * @return
     */
    public double obtenerPrecio(double precioBase, double descuento) {
        return modificador.modificar(precioBase, descuento);
    }
}