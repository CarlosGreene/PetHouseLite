package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import modelo.Mascota_cliente;
import DAO.DAOMascota_cliente;
import view.*;
/**
 *
 * @author Albert
 */
public class controlMascotas_cliente implements ActionListener{
    private VistaMascotasC vista;
    private Mascota_cliente mascota;
    
    public controlMascotas_cliente(VistaMascotasC vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
        this.vista.getFoto().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String nombre, especie, raza, sexo;
            Cliente dueño;
            int edad, peso;
            nombre = vista.getNombre().getText();
            especie = (String) vista.getEspecie().getSelectedItem();
            raza = vista.getRaza().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            peso = Integer.parseInt(vista.getPeso().getText());
            sexo = (String) vista.getSexo().getSelectedItem();
            dueño = (Cliente) vista.getDueño().getSelectedItem();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setEdad(edad);
            mascota.setPeso(peso);
            mascota.setSexo(sexo);
            mascota.setCliente(dueño);
            DAOMascota_cliente mascotaBD = new DAOMascota_cliente();
            try{
                mascotaBD.agregar(mascota);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEditar() == event.getSource()){
            String nombre, especie, raza, sexo, condicion;
            Cliente dueño;
            int edad, peso;
            nombre = vista.getNombre().getText();
            especie = (String) vista.getEspecie().getSelectedItem();
            raza = vista.getRaza().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            peso = Integer.parseInt(vista.getPeso().getText());
            sexo = (String) vista.getSexo().getSelectedItem();
            dueño = (Cliente) vista.getDueño().getSelectedItem();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setEdad(edad);
            mascota.setPeso(peso);
            mascota.setSexo(sexo);
            mascota.setCliente(dueño);
            condicion = " nombre = " + nombre;
            DAOMascota_cliente mascotaBD = new DAOMascota_cliente();
            try{
                mascotaBD.modificar(mascota, condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEliminar() == event.getSource()){
            String nombre, condicion;
            nombre = vista.getNombre().getText();
            condicion = " nombre = " + nombre;
            DAOMascota_cliente clienteBD = new DAOMascota_cliente();
            try{
                clienteBD.eliminar(condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getFoto() == event.getSource()){
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

