/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import DAO.DAOMascota_cliente;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Mascota_cliente;

/**
 *
 * @author green
 */
public class TablaMascotaCliente {
     DAOMascota_cliente dao = null;
    
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
        
        dao = new DAOMascota_cliente();
        Mascota_cliente mc = new Mascota_cliente("-","-","-",0,0,"-","-");
        try{
            ArrayList<Mascota_cliente> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                mc = list.get(i);
                fila[0] = mc.getEspecie();
                fila[1] = mc.getNombre();
                fila[2] = mc.getRaza();
                fila[3] = mc.getEdad();
                fila[4] = mc.getPeso();
                fila[5] = mc.getSexo();
                fila[6] = mc.getCliente();
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
