/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;
import DAO.DAOMascota_resguardo;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Mascota_resguardo;

/**
 *
 * @author green
 */
public class TablaMascotaResguardada {
    DAOMascota_resguardo dao = null;
    
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
        
        dao = new DAOMascota_resguardo();
        Date fecha = new Date(1-02-2020);
        Mascota_resguardo mr = new Mascota_resguardo("-","-","-",0,0,"-");
        try{
            ArrayList<Mascota_resguardo> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                mr = list.get(i);
                fila[0] = mr.getEspecie();
                fila[1] = mr.getNombre();
                fila[2] = mr.getRaza();
                fila[3] = mr.getEdad();
                fila[4] = mr.getPeso();
                fila[5] = mr.getSexo();
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
