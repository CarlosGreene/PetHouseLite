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
public class SolicitudAdopcion extends Solicitud{
    private byte[] ComprobanteDom;
    private byte[] INE;
    private String mascota;

    public SolicitudAdopcion(String cliente, Date fecha, byte[] ComprobanteDom, byte[] INE, String mascota){
        super(cliente, fecha);
        this.ComprobanteDom = ComprobanteDom;
        this.INE = INE;
        this.mascota = mascota;
    }
    
    public byte[] getComprobanteDom() {
        return ComprobanteDom;
    }

    public void setComprobanteDom(byte[] ComprobanteDom) {
        this.ComprobanteDom = ComprobanteDom;
    }

    public byte[] getINE() {
        return INE;
    }

    public void setINE(byte[] INE) {
        this.INE = INE;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
    
    
}
