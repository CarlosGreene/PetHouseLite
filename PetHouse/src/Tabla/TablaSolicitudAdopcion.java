/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;
import DAO.DAOSolicitudAdopcion;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.SolicitudAdopcion;

/**
 *
 * @author green
 */
public class TablaSolicitudAdopcion {
    DAOSolicitudAdopcion dao = null;
    
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
        
        dao = new DAOSolicitudAdopcion();
        Date fecha = new Date(1-02-2020);
        SolicitudAdopcion sa = new SolicitudAdopcion("-", fecha ,"-");
        try{
            ArrayList<SolicitudAdopcion> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                sa = list.get(i);
                fila[0] = sa.getCliente();
                fila[1] = sa.getFecha();
                fila[2] = sa.getMascota();
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
