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
/**
 *
 * @author Albert
 */
public class controlSolicitudEsterilizacion implements ActionListener{
    private VistaSolicitudE vista;
    private SolicitudEsterilizacion solicitud;
    
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
            Cliente solicitante;
            Mascota_cliente mascota;
            solicitante =(Cliente) vista.getSolicitante().getSelectedItem();
            mascota =(Mascota_cliente) vista.getMascota().getSelectedItem();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            try{
                Date fecha = df.parse(fechaC);
                solicitud.setFechaCita((java.sql.Date) fecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            servicio = Double.parseDouble(vista.getServicio().getText());
            solicitud.setCliente(solicitante);
            solicitud.setMascota(mascota);
            solicitud.setAporte(servicio);
            DAOSolicitudEsterilizacion solicitudBD = new DAOSolicitudEsterilizacion();
            try{
                solicitudBD.agregar(solicitud);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEditar() == event.getSource()){
            String fechaC, condicion;
            double servicio;
            Cliente solicitante;
            Mascota_cliente mascota;
            solicitante =(Cliente) vista.getSolicitante().getSelectedItem();
            mascota =(Mascota_cliente) vista.getMascota().getSelectedItem();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            try{
                Date fecha = df.parse(fechaC);
                solicitud.setFechaCita((java.sql.Date) fecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            servicio = Double.parseDouble(vista.getServicio().getText());
            solicitud.setCliente(solicitante);
            solicitud.setMascota(mascota);
            solicitud.setAporte(servicio);
            condicion = " fechaCita = " + fechaC;
            DAOSolicitudEsterilizacion solicitudBD = new DAOSolicitudEsterilizacion();
            try{
                solicitudBD.modificar(solicitud, condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEliminar() == event.getSource()){
            String fechaC, condicion;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            condicion = " fechaCita = " + fechaC;
            DAOSolicitudEsterilizacion solicitudBD = new DAOSolicitudEsterilizacion();
            try{
                solicitudBD.eliminar(condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getMenú() == event.getSource()){
            mainPHL main = new mainPHL();
            controlMenu cm = new controlMenu(main);
            main.setVisible(true);
            vista.dispose();
        }
   }
}