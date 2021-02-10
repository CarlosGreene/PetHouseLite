package control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
/**
 *
 * @author Albert
 */
public class controlMenu implements ActionListener{
    private mainPHL vista;
    
    public controlMenu(mainPHL vista){
        this.vista = vista;
        this.vista.getCliente().addActionListener(this);
        this.vista.getMascotasR().addActionListener(this);
        this.vista.getMascotasA().addActionListener(this);
        this.vista.getMascotasC().addActionListener(this);
        this.vista.getSolicitudesA().addActionListener(this);
        this.vista.getSolicitudesE().addActionListener(this);
        this.vista.getRInventario().addActionListener(this);
    }
    
   public void actionPerformed(ActionEvent event){
        if(vista.getCliente() == event.getSource()){
            VistaCliente vc = new VistaCliente();
            controlCliente cc = new controlCliente(vc);
            vc.setVisible(true);
            vista.dispose();
        }
        if(vista.getMascotasR() == event.getSource()){
            VistaMascotasR vm = new VistaMascotasR();
            controlMascotas_resguardo cm = new controlMascotas_resguardo(vm);
            vm.setVisible(true);
            vista.dispose();
        }
        if(vista.getMascotasC() == event.getSource()){
            VistaMascotasC vm = new VistaMascotasC();
            controlMascotas_cliente cm = new controlMascotas_cliente(vm);
            vm.setVisible(true);
            vista.dispose();
        }
        if(vista.getMascotasA() == event.getSource()){
            VistaMascotasA vm = new VistaMascotasA();
            controlMascotas_adoptadas cm = new controlMascotas_adoptadas(vm);
            vm.setVisible(true);
            vista.dispose();
        }
        if(vista.getSolicitudesA() == event.getSource()){
            VistaSolicitudA vs = new VistaSolicitudA();
            controlSolicitudAdopcion cs = new controlSolicitudAdopcion(vs);
            vs.setVisible(true);
            vista.dispose();
        }
        if(vista.getSolicitudesE() == event.getSource()){
            VistaSolicitudE vs = new VistaSolicitudE();
            controlSolicitudEsterilizacion cs = new controlSolicitudEsterilizacion(vs);
            vs.setVisible(true);
            vista.dispose();
        }
        if(vista.getRInventario() == event.getSource()){
            VistaInventario vi = new VistaInventario();
            controlInventario ci = new controlInventario(vi);
            vi.setVisible(true);
            vista.dispose();
        }
   }
}
