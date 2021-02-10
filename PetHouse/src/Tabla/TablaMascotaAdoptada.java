/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import DAO.DAOMascota_adoptada;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Mascota_adoptada;

/**
 *
 * @author green
 */
public class TablaMascotaAdoptada {
    DAOMascota_adoptada dao = null;
    
    public void visializar(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel dt = new  DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Especie");
        dt.addColumn("Nombre");
        dt.addColumn("Raza");
        dt.addColumn("Edad");
        dt.addColumn("Peso");
        dt.addColumn("Sexo");
        dt.addColumn("Cliente");
        dt.addColumn("Fecha");
        
        dao = new DAOMascota_adoptada();
        Date fecha = new Date(1-02-2020);
        Mascota_adoptada ma = new Mascota_adoptada("-","-","-",0,0,"-","-",fecha);
        try{
            ArrayList<Mascota_adoptada> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                ma = list.get(i);
                fila[0] = ma.getEspecie();
                fila[1] = ma.getNombre();
                fila[2] = ma.getRaza();
                fila[3] = ma.getEdad();
                fila[4] = ma.getPeso();
                fila[5] = ma.getSexo();
                fila[6] = ma.getCliente();
                fila[7] = ma.getFechaCita();
                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(60);
        }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
