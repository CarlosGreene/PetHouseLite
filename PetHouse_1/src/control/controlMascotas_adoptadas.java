package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Mascota_adoptada;
import DAO.DAOMascota_adoptada;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import view.*;
/**
 *
 * @author Albert
 */
public class controlMascotas_adoptadas implements ActionListener{
    private VistaMascotasA vista;
    private Mascota_adoptada mascota;
    
    public controlMascotas_adoptadas(VistaMascotasA vista){
        this.vista = vista;
        this.vista.getAgregar().addActionListener(this);
        this.vista.getMenú().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getAgregar() == event.getSource()){
            String fechaC, dueño;
            dueño = (String) vista.getDueño().getSelectedItem();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            fechaC = vista.getFecha().getText();
            try{
                Date fecha = df.parse(fechaC);
                mascota.setFechaCita((java.sql.Date) fecha);
            }catch(Exception e){
                e.printStackTrace();
            }
            mascota.setCliente(dueño);
            DAOMascota_adoptada mascotaBD = new DAOMascota_adoptada();
            try{
                mascotaBD.agregar(mascota);
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
