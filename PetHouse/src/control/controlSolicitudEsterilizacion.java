package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import modelo.Mascota_cliente;
import modelo.SolicitudEsterilizacion;
import DAO.DAOSolicitudEsterilizacion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.*;
import Tabla.TablaSolicitudEsterilizacion;
/**
 *
 * @author Albert
 */
public class controlSolicitudEsterilizacion implements ActionListener{
    private VistaSolicitudE vista;
    private SolicitudEsterilizacion solicitud;
    private TablaSolicitudEsterilizacion t = new TablaSolicitudEsterilizacion();
    private javax.swing.JTable jTable1;
    
    public controlSolicitudEsterilizacion(VistaSolicitudE vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String fechaC;
            double servicio;
            String solicitante;
            String mascota;
            solicitante =(String) vista.getSolicitante().getSelectedItem();
            mascota =(String) vista.getMascota().getSelectedItem();
            servicio = Double.parseDouble(vista.getServicio().getText());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
                solicitud = new SolicitudEsterilizacion(solicitante, sqlFecha, mascota, servicio);
            }catch(Exception e){
                e.printStackTrace();
            }
            DAOSolicitudEsterilizacion solicitudBD = new DAOSolicitudEsterilizacion();
            try{
                solicitudBD.agregar(solicitud);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getEditar() == event.getSource()){
            String fechaC, condicion;
            double servicio;
            String solicitante;
            String mascota;
            solicitante =(String) vista.getSolicitante().getSelectedItem();
            mascota =(String) vista.getMascota().getSelectedItem();
            servicio = Double.parseDouble(vista.getServicio().getText());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            Date fecha = null;
            try{
                fecha = df.parse(fechaC);
                java.sql.Date sqlFecha = new java.sql.Date(fecha.getTime());
                solicitud = new SolicitudEsterilizacion(solicitante, sqlFecha, mascota, servicio);
            }catch(Exception e){
                e.printStackTrace();
            }

            condicion = " fecha = '" + solicitud.getFecha() + "'";
            DAOSolicitudEsterilizacion solicitudBD = new DAOSolicitudEsterilizacion();
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
            DAOSolicitudEsterilizacion solicitudBD = new DAOSolicitudEsterilizacion();
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