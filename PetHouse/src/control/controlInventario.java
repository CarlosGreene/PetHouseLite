package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Insumo;
import DAO.DAOInsumo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.*;
import Tabla.TablaInsumo;
/**
 *
 * @author Albert
 */
public class controlInventario implements ActionListener{
    private VistaInventario vista;
    private Insumo insumo;
    private javax.swing.JTable jTable1;
    TablaInsumo t = new TablaInsumo();
    
    public controlInventario(VistaInventario vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String producto, tipo, fechaC, donador;
            double costo;
            producto = vista.getProducto().getText();
            tipo =(String) vista.getTipo().getSelectedItem();
            if(vista.getAnónimo().isSelected()){
                donador = null;
            }else{
                donador =(String) vista.getDonador().getSelectedItem();
            }
            costo = Double.parseDouble(vista.getCosto().getText());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
                insumo = new Insumo(producto, tipo, costo, donador, sqlFecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            DAOInsumo insumoBD = new DAOInsumo();
            try{
                insumoBD.agregar(insumo);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getEditar() == event.getSource()){
            String producto, tipo, fechaC, donador, condicion;
            double costo;
            producto = vista.getProducto().getText();
            tipo =(String) vista.getTipo().getSelectedItem();
            if(vista.getAnónimo().isSelected()){
                donador = null;
            }else{
                donador =(String) vista.getDonador().getSelectedItem();
            }
            costo = Double.parseDouble(vista.getCosto().getText());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
                insumo = new Insumo(producto, tipo, costo, donador, sqlFecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            condicion = " producto = '" + producto + "'";
            DAOInsumo insumoBD = new DAOInsumo();
            try{
                insumoBD.modificar(insumo, condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getEliminar() == event.getSource()){
            String producto, condicion;
            producto = vista.getProducto().getText();
            condicion = " producto = '" + producto + "'";
            DAOInsumo insumoBD = new DAOInsumo();
            try{
                insumoBD.eliminar(condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getMenú() == event.getSource()){
            mainPHL main = new mainPHL();
            controlMenu cm = new controlMenu(main);
            main.setVisible(true);
            vista.dispose();
        }
   }
}