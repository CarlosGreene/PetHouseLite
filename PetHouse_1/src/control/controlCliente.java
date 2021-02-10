package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import DAO.DAOCliente;
import view.*;
/**
 *
 * @author Albert
 */
public class controlCliente implements ActionListener{
    private VistaCliente vista;
    private Cliente cliente;
    
    public controlCliente(VistaCliente vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String nombre, telefono, email;
            int edad;
            nombre = vista.getNombre().getText();
            telefono = vista.getNúmero().getText();
            email = vista.getCorreo().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            cliente.setNombre(nombre);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setEdad(edad);
            DAOCliente clienteBD = new DAOCliente();
            try{
                clienteBD.agregar(cliente);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEditar() == event.getSource()){
            String nombre, telefono, email, condicion;
            int edad;
            nombre = vista.getNombre().getText();
            telefono = vista.getNúmero().getText();
            email = vista.getCorreo().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            cliente.setNombre(nombre);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setEdad(edad);
            condicion = " nombre = " + nombre;
            DAOCliente clienteBD = new DAOCliente();
            try{
                clienteBD.modificar(cliente, condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEliminar() == event.getSource()){
            String nombre, condicion;
            nombre = vista.getNombre().getText();
            condicion = " nombre = " + nombre;
            DAOCliente clienteBD = new DAOCliente();
            try{
                clienteBD.eliminar(condicion);
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
