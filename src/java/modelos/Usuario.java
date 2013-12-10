/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raul
 */
@XmlRootElement
public class Usuario {
    
    private String dni;
    private String nombre;
    private String direccion;

    /**
     * Construye un objeto de tipo usuario pasandole todos los parámetros
     * necesarios para inicializar todos los atributos.
     *
     * @param _nombre
     * @param _direccion
     * @param _dni
     */
    public Usuario(String _nombre, String _direccion, String _dni) {
        nombre = _nombre;
        direccion = _direccion;
        dni = _dni;
    }

    /**
     * Constructor por defecto. Construye un objeto de tipo usuario sin
     * inicializar los atributos.
     */
    public Usuario() {

    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
