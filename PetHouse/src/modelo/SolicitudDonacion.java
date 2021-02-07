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
public class SolicitudDonacion extends Solicitud{
    private Donativo donativo;

    public SolicitudDonacion(Cliente cliente, Date fecha, Donativo donativo) {
        super(cliente, fecha);
        this.donativo = donativo;
    }

    public Donativo getDonativo() {
        return donativo;
    }

    public void setDonativo(Donativo donativo) {
        this.donativo = donativo;
    }
}
