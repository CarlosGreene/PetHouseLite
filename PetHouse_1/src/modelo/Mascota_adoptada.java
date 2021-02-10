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
public class Mascota_adoptada extends Mascota{
    private String cliente;
    private Date fechaCita;
    
    public Mascota_adoptada(String especie, String nombre, String raza, int edad, double peso, String sexo, String cliente, Date fechaCita){
        super(especie, nombre, raza, edad, peso, sexo);
        this.cliente = cliente;
        this.fechaCita = fechaCita;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
    
}
