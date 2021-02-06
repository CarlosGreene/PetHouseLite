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
public class SolicitudEsterilizacion {
    private Mascota_cliente mascota;
    
    public SolicitudEsterilizacion(Cliente cliente, DateTime fechaHora,Mascota_cliente mascota){
        super(cliente, fechaHora);
        this.mascota = mascota;
    }
    

    public Mascota_cliente getMascota() {
        return mascota;
    }

    public void setMascota(Mascota_cliente mascota) {
        this.mascota = mascota;
    }
    
    
    
}
