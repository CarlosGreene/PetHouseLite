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
public class SolicitudDonacion {
    private Donativo donativo;

    public SolicitudDonacion(Cliente cliente, DateTime fechaHora,Donativo donativo) {
        super(cliente, fechaHora);
        this.donativo = donativo;
    }

    public Donativo getDonativo() {
        return donativo;
    }

    public void setDonativo(Donativo donativo) {
        this.donativo = donativo;
    }
}
