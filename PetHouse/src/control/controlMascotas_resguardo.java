package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Mascota_resguardo;
import modelo.Mascota_adoptada;
import DAO.DAOMascota_resguardo;
import DAO.DAOMascota_adoptada;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import view.*;
import java.util.Date;
import Tabla.TablaMascotaResguardada;
/**
 *
 * @author Albert
 */
public class controlMascotas_resguardo implements ActionListener{
    private VistaMascotasR vista;
    private Mascota_resguardo mascota;
    private Mascota_adoptada mascota1;
    private TablaMascotaResguardada t = new TablaMascotaResguardada();
     private javax.swing.JTable jTable1;
    
    public controlMascotas_resguardo(VistaMascotasR vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getEditar().addActionListener(this);
        this.vista.getEliminar().addActionListener(this);
        this.vista.getAdoptado().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String nombre, especie, raza, sexo;
            int edad; 
            double peso;
            nombre = vista.getNombre().getText();
            especie = (String) vista.getEspecie().getSelectedItem();
            raza = vista.getRaza().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            peso = Integer.parseInt(vista.getPeso().getText());
            sexo = (String) vista.getSexo().getSelectedItem();
            mascota = new Mascota_resguardo(especie, nombre, raza, edad, peso, sexo);
            System.out.print(mascota.getEspecie());
            DAOMascota_resguardo mascotaBD = new DAOMascota_resguardo();
            try{
                mascotaBD.agregar(mascota);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
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
            mascota = new Mascota_resguardo(especie, nombre, raza, edad, peso, sexo);
            condicion = " nombre = '" + nombre + "'";
            DAOMascota_resguardo mascotaBD = new DAOMascota_resguardo();
            try{
                mascotaBD.modificar(mascota, condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getEliminar() == event.getSource()){
            String nombre, condicion;
            nombre = vista.getNombre().getText();
            condicion = " nombre = '" + nombre + "'";
            DAOMascota_resguardo clienteBD = new DAOMascota_resguardo();
            try{
                clienteBD.eliminar(condicion);
            }catch (Exception e){
                e.printStackTrace();
            }
            t.visializar(jTable1);
        }
        if(vista.getAdoptado()== event.getSource()){
            String nombre, especie, raza, sexo, condicion;
            int edad; 
            double peso;
            nombre = vista.getNombre().getText();
            especie = (String) vista.getEspecie().getSelectedItem();
            raza = vista.getRaza().getText();
            edad = Integer.parseInt(vista.getEdad().getText());
            peso = Integer.parseInt(vista.getPeso().getText());
            sexo = (String) vista.getSexo().getSelectedItem();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            String dia = Integer.toString(c.get(Calendar.DATE));
            String mes = Integer.toString(c.get(Calendar.MONTH));
            String annio = Integer.toString(c.get(Calendar.YEAR));
            Date fecha1 = null;
            try{
                fecha1 = df.parse(dia+"/"+mes+"/"+annio);
                java.sql.Date sqlFecha = new java.sql.Date(fecha1.getTime());
                mascota1 = new Mascota_adoptada(especie, nombre, raza, edad, peso, sexo, "-", sqlFecha);
            } catch(Exception e){
                e.printStackTrace();
            }
            System.out.print(mascota.getEspecie());
            DAOMascota_adoptada mascotaBD = new DAOMascota_adoptada();
            try{
                mascotaBD.agregar(mascota1);
            }catch (Exception e){
                e.printStackTrace();
            }
            condicion = " nombre = '" + nombre + "'";
            DAOMascota_resguardo clienteBD = new DAOMascota_resguardo();
            try{
                clienteBD.eliminar(condicion);
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
