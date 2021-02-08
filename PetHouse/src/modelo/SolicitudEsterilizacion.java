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
    private double aporte;
    
    public SolicitudEsterilizacion(Cliente cliente, Date fecha, Mascota_cliente mascota, double aporte){
        super(cliente, fecha);
        this.mascota = mascota;
        this.aporte = aporte;
    }

    public Mascota_cliente getMascota() {
        return mascota;
    }

    public void setMascota(Mascota_cliente mascota) {
        this.mascota = mascota;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }
    
}
