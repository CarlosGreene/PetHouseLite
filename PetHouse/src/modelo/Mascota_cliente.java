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
public class Mascota_cliente extends Mascota{
    private String cliente;
    
    public Mascota_cliente(String especie, String nombre, String raza, int edad, double peso, String sexo, String cliente){
        super(especie, nombre, raza, edad, peso, sexo);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}
