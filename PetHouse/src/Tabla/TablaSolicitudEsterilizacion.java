/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import DAO.DAOSolicitudEsterilizacion;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.SolicitudEsterilizacion;

/**
 *
 * @author green
 */
public class TablaSolicitudEsterilizacion {
    DAOSolicitudEsterilizacion dao = null;
    
    public void visializar(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel dt = new  DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Cliente");
        dt.addColumn("Fecha");
        dt.addColumn("Mascota");
        dt.addColumn("Aporte");
        
        dao = new DAOSolicitudEsterilizacion();
        Date fecha = new Date(1-02-2020);
        SolicitudEsterilizacion se = new SolicitudEsterilizacion("-", fecha ,"-", 0);
        try{
            ArrayList<SolicitudEsterilizacion> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                se = list.get(i);
                fila[0] = se.getCliente();
                fila[1] = se.getFecha();
                fila[2] = se.getMascota();
                fila[3] = se.getMascota();
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
