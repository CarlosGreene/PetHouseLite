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
public class Solicitud {
    private Cliente cliente;
    private Date fecha;
    
    public Solicitud(Cliente cliente, Date fecha) {
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
