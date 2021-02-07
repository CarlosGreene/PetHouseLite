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
public class Donativo extends Insumo{
    private Cliente donador;
    
    public Donativo(String producto, int cantidad, double precio){
        super(producto,cantidad,precio);
        this.donador = donador;
    }
    
    public Cliente getCliente() {
        return donador;
    }

    public void setCliente(Cliente donador) {
        this.donador = donador;
    }
}
