/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.sql.Date;
/**
 *
 * @author Laplenovo
 */
public class Insumo {
    private String producto;
    private String tipoDeInsumo;
    private double precio;
    private Cliente donador;
    private Date fechaCita;
    
    public Insumo(String producto, String tipoDeInsumo ,double precio) {
        this(producto, tipoDeInsumo, precio, null, null);
    }

    public Insumo(String producto, String tipoDeInsumo, double precio, Cliente donador, Date fechaCita){
        this.producto = producto;
        this.tipoDeInsumo = tipoDeInsumo;
        this.precio = precio;
        this.donador = donador;
        this.fechaCita = fechaCita;
    }
    
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoDeInsumo() {
        return tipoDeInsumo;
    }
    
    public void setTipoDeInsumo(String tipoDeInsumo) {
        this.tipoDeInsumo = tipoDeInsumo;
    }
    
    public Cliente getDonador() {
        return donador;
    }
    
    public void setDonador(Cliente donador) {
        this.donador = donador;
    }
    
    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
  
}
