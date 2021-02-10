/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;
import DAO.DAOInsumo;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Insumo;
import java.sql.Date;
/**
 *
 * @author green
 */
public class TablaInsumo {
    DAOInsumo dao = null;
    
    public void visializar(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel dt = new  DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Producto");
        dt.addColumn("Tipo de insumo");
        dt.addColumn("Precio");
        dt.addColumn("Donador");
        dt.addColumn("Fecha");
        
        dao = new DAOInsumo();
        Date fecha = new Date(1-02-2020);
        Insumo insumo = new Insumo("-","-",0,"-",fecha);
        try{
            ArrayList<Insumo> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                insumo = list.get(i);
                fila[0] = insumo.getProducto();
                fila[1] = insumo.getTipoDeInsumo();
                fila[2] = insumo.getPrecio();
                fila[3] = insumo.getDonador();
                fila[4] = insumo.getFechaCita();
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
