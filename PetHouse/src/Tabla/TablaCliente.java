/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import DAO.DAOCliente;
import javax.swing.JLabel;
import modelo.Cliente;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 *
 * @author green
 */
public class TablaCliente {
    DAOCliente dao = null;
    
    public void visializar(JTable tabla){
        tabla.setDefaultRenderer(Object.class, new Render());
        
        DefaultTableModel dt = new  DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        dt.addColumn("Nombre");
        dt.addColumn("Telefono");
        dt.addColumn("Correo");
        dt.addColumn("Edad");
        
        dao = new DAOCliente();
        Cliente cliente = new Cliente("-","-","-",0);
        try{
            ArrayList<Cliente> list = dao.enlistar();
            if(list.size() > 0){
            for(int i=0; i<list.size(); i++){
                Object fila[] = new Object[10];
                cliente = list.get(i);
                fila[0] = cliente.getNombre();
                fila[1] = cliente.getTelefono();
                fila[2] = cliente.getEmail();
                fila[3] = cliente.getEdad();
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
