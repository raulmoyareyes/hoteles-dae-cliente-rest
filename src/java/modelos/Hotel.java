package modelos;

/**
 * Clase utilizada para crear hoteles
 *
 * @author Raúl & Gabri
 */
public class Hotel {

    private String nombre;
    private String direccion;
    private String ciudad;
    private int numSimples;
    private int numDobles;
    private int numTriples;
    private float precioSimples;
    private float precioDobles;
    private float precioTriples;

    /**
     * Constructor por defecto.
     */
    public Hotel() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param nombre
     * @param direccion
     * @param ciudad
     * @param numSimples
     * @param numDobles
     * @param numTriples
     * @param precioSimples
     * @param precioDobles
     * @param precioTriples
     */
    public Hotel(String nombre, String direccion, String ciudad, int numSimples, int numDobles, int numTriples, float precioSimples, float precioDobles, float precioTriples) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.numSimples = numSimples;
        this.numDobles = numDobles;
        this.numTriples = numTriples;
        this.precioSimples = precioSimples;
        this.precioDobles = precioDobles;
        this.precioTriples = precioTriples;
    }

    /**
     * Constructor de copia.
     *
     * @param hotel
     */
    public Hotel(final Hotel hotel) {
        this.nombre = hotel.getNombre();
        this.direccion = hotel.getDireccion();
        this.ciudad = hotel.getCiudad();
        this.numSimples = hotel.getNumSimples();
        this.numDobles = hotel.getNumDobles();
        this.numTriples = hotel.getNumTriples();
        this.precioSimples = hotel.getPrecioSimples();
        this.precioDobles = hotel.getPrecioDobles();
        this.precioTriples = hotel.getPrecioTriples();
    }

    /**
     * @return El nombre del hotel
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the numSimples
     */
    public int getNumSimples() {
        return numSimples;
    }

    /**
     * @param numSimples the numSimples to set
     */
    public void setNumSimples(int numSimples) {
        this.numSimples = numSimples;
    }

    /**
     * @return the numDobles
     */
    public int getNumDobles() {
        return numDobles;
    }

    /**
     * @param numDobles the numDobles to set
     */
    public void setNumDobles(int numDobles) {
        this.numDobles = numDobles;
    }

    /**
     * @return the numTriples
     */
    public int getNumTriples() {
        return numTriples;
    }

    /**
     * @param numTriples the numTriples to set
     */
    public void setNumTriples(int numTriples) {
        this.numTriples = numTriples;
    }

    /**
     * @return the precioSimples
     */
    public float getPrecioSimples() {
        return precioSimples;
    }

    /**
     * @param precioSimples the precioSimples to set
     */
    public void setPrecioSimples(float precioSimples) {
        this.precioSimples = precioSimples;
    }

    /**
     * @return the precioDobles
     */
    public float getPrecioDobles() {
        return precioDobles;
    }

    /**
     * @param precioDobles the precioDobles to set
     */
    public void setPrecioDobles(float precioDobles) {
        this.precioDobles = precioDobles;
    }

    /**
     * @return the precioTriples
     */
    public float getPrecioTriples() {
        return precioTriples;
    }

    /**
     * @param precioTriples the precioTriples to set
     */
    public void setPrecioTriples(float precioTriples) {
        this.precioTriples = precioTriples;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve un boolean. True si alguno de los atributos no ha sido
     * inicializado. False si todos los atributos han sido inicializados.
     *
     * @return boolean
     */
    public Boolean hasEmptyFields() {
        if (nombre.isEmpty()) {
            return true;
        } else if (direccion.isEmpty()) {
            return true;
        } else if (ciudad.isEmpty()) {
            return true;
        } else if (numSimples == 0 && numDobles == 0 && numTriples == 0) {
            return true;
        } else if (numSimples > 0 && precioSimples <= 0) {
            return true;
        } else if (numDobles > 0 && precioDobles <= 0) {
            return true;
        } else {
            return numTriples > 0 && precioTriples <= 0;
        }
    }

    public void validar() {

    }
}
