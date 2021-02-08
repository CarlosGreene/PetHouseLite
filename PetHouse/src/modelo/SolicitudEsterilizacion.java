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
    private String mascota;
    private double aporte;
    
    public SolicitudEsterilizacion(String cliente, Date fecha, String mascota, double aporte){
        super(cliente, fecha);
        this.mascota = mascota;
        this.aporte = aporte;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }
    
}
