package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import modelo.Mascota_resguardo;
import modelo.SolicitudAdopcion;
import DAO.DAOSolicitudAdopcion;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.*;
import Tabla.TablaSolicitudAdopcion;
/**
 *
 * @author Albert
 */
public class controlSolicitudAdopcion implements ActionListener{
    private VistaSolicitudA vista;
    private SolicitudAdopcion solicitud;
    private TablaSolicitudAdopcion t = new TablaSolicitudAdopcion();
    private javax.swing.JTable jTable1;
    
    public controlSolicitudAdopcion(VistaSolicitudA vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String fechaC;
            String solicitante;
            String mascota;
            solicitante =(String) vista.getSolicitante().getSelectedItem();
            mascota =(String) vista.getMascota().getSelectedItem();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
                solicitud = new SolicitudAdopcion(solicitante, sqlFecha, mascota);
            }catch(Exception e){
                e.printStackTrace();
            }
            DAOSolicitudAdopcion solicitudBD = new DAOSolicitudAdopcion();
            try{
                solicitudBD.agregar(solicitud);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getEditar() == event.getSource()){
            String fechaC, condicion;
            String solicitante;
            String mascota;
            solicitante =(String) vista.getSolicitante().getSelectedItem();
            mascota =(String) vista.getMascota().getSelectedItem();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
                solicitud = new SolicitudAdopcion(solicitante, sqlFecha, mascota);
            }catch(Exception e){
                e.printStackTrace();
            }
            condicion = " fecha = '" + solicitud.getFecha() + "'";
            DAOSolicitudAdopcion solicitudBD = new DAOSolicitudAdopcion();
            try{
                solicitudBD.modificar(solicitud, condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getEliminar() == event.getSource()){
            String fechaC, condicion;
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
            } catch(Exception e){
                e.printStackTrace();
            }
            java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
            condicion = " fecha = '" + sqlFecha + "'";
            DAOSolicitudAdopcion solicitudBD = new DAOSolicitudAdopcion();
            try{
                solicitudBD.eliminar(condicion);
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

