/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Laplenovo
 */
public class Albergue {
    private String nombre;
    private String ubicacion;
    private String telefono;

    public Albergue(String nombre, String ubicacion, String telefono) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }
        
    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
