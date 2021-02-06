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
public class SolicitudAdopcion {
    private Byte ComprobanteDom;
    private Byte INE;
    private Mascota_resguardo mascota;

    public SolicitudAdopcion(Cliente cliente, DateTime fechaHora,Byte ComprobanteDom, Byte INE){
        super(cliente, fechaHora);
        this.ComprobanteDom = ComprobanteDom;
        this.INE = INE;
    }
    
    public Byte getComprobanteDom() {
        return ComprobanteDom;
    }

    public void setComprobanteDom(Byte ComprobanteDom) {
        this.ComprobanteDom = ComprobanteDom;
    }

    public Byte getINE() {
        return INE;
    }

    public void setINE(Byte INE) {
        this.INE = INE;
    }

    public Mascota_resguardo getMascota() {
        return mascota;
    }

    public void setMascota(Mascota_resguardo mascota) {
        this.mascota = mascota;
    }
    
    
}
