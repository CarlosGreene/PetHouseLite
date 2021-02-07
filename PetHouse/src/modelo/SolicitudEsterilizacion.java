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
public class SolicitudEsterilizacion extends Solicitud{
    private Mascota_cliente mascota;
    
    public SolicitudEsterilizacion(Cliente cliente, Date fecha, Mascota_cliente mascota){
        super(cliente, fecha);
        this.mascota = mascota;
    }
    

    public Mascota_cliente getMascota() {
        return mascota;
    }

    public void setMascota(Mascota_cliente mascota) {
        this.mascota = mascota;
    }
    
    
    
}
