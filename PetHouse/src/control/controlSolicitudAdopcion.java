package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import modelo.Mascota_resguardo;
import modelo.SolicitudAdopcion;
import DAO.DAOSolicitudAdopcion;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.*;
/**
 *
 * @author Albert
 */
public class controlSolicitudAdopcion implements ActionListener{
    private VistaSolicitudA vista;
    private SolicitudAdopcion solicitud;
    
    public controlSolicitudAdopcion(VistaSolicitudA vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
        this.vista.getComprobante().addActionListener(this);
        this.vista.getINE().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String fechaC;
            Cliente solicitante;
            Mascota_resguardo mascota;
            solicitante =(Cliente) vista.getSolicitante().getSelectedItem();
            mascota =(Mascota_resguardo) vista.getMascota().getSelectedItem();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            try{
                Date fecha = df.parse(fechaC);
                solicitud.setFechaCita((java.sql.Date) fecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            solicitud.setCliente(solicitante);
            solicitud.setMascota(mascota);
            solicitud.setComprobanteDom(ComprobanteDom);
            solicitud.setINE(INE);
            DAOSolicitudAdopcion solicitudBD = new DAOSolicitudAdopcion();
            try{
                solicitudBD.agregar(solicitud);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEditar() == event.getSource()){
            String fechaC, condicion;
            Cliente solicitante;
            Mascota_resguardo mascota;
            solicitante =(Cliente) vista.getSolicitante().getSelectedItem();
            mascota =(Mascota_resguardo) vista.getMascota().getSelectedItem();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            try{
                Date fecha = df.parse(fechaC);
                solicitud.setFechaCita((java.sql.Date) fecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            solicitud.setCliente(solicitante);
            solicitud.setMascota(mascota);
            solicitud.setComprobanteDom(ComprobanteDom);
            solicitud.setINE(INE);
            condicion = " fechaCita = " + fechaC;
            DAOSolicitudAdopcion solicitudBD = new DAOSolicitudAdopcion();
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
            DAOSolicitudAdopcion solicitudBD = new DAOSolicitudAdopcion();
            try{
                solicitudBD.eliminar(condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getComprobante()== event.getSource()){
            mainPHL main = new mainPHL();
            controlMenu cm = new controlMenu(main);
            main.setVisible(true);
            vista.dispose();
        }
        if(vista.getINE()== event.getSource()){
            mainPHL main = new mainPHL();
            controlMenu cm = new controlMenu(main);
            main.setVisible(true);
            vista.dispose();
        }
        if(vista.getMenú() == event.getSource()){
            mainPHL main = new mainPHL();
            controlMenu cm = new controlMenu(main);
            main.setVisible(true);
            vista.dispose();
        }
   }
}

