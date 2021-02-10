package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Mascota_resguardo;
import DAO.DAOMascota_resguardo;
import view.*;
/**
 *
 * @author Albert
 */
public class controlMascotas_resguardo implements ActionListener{
    private VistaMascotasR vista;
    private Mascota_resguardo mascota;
    
    public controlMascotas_resguardo(VistaMascotasR vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getAdoptado().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
        this.vista.getFoto().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String nombre, especie, raza, sexo;
            int edad, peso;
            nombre = vista.getNombre().getText();
            especie = (String) vista.getEspecie().getSelectedItem();
            raza = vista.getRaza().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            peso = Integer.parseInt(vista.getPeso().getText());
            sexo = (String) vista.getSexo().getSelectedItem();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setEdad(edad);
            mascota.setPeso(peso);
            mascota.setSexo(sexo);
            DAOMascota_resguardo mascotaBD = new DAOMascota_resguardo();
            try{
                mascotaBD.agregar(mascota);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(vista.getEditar() == event.getSource()){
            String nombre, especie, raza, sexo, condicion;
            int edad, peso;
            nombre = vista.getNombre().getText();
            especie = (String) vista.getEspecie().getSelectedItem();
            raza = vista.getRaza().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            peso = Integer.parseInt(vista.getPeso().getText());
            sexo = (String) vista.getSexo().getSelectedItem();
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setEdad(edad);
            mascota.setPeso(peso);
            mascota.setSexo(sexo);
            condicion = " nombre = " + nombre;
            DAOMascota_resguardo mascotaBD = new DAOMascota_resguardo();
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
            DAOMascota_resguardo clienteBD = new DAOMascota_resguardo();
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
