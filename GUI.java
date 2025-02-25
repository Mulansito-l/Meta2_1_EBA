import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * GUI
 */
public class GUI implements Consumer{

    Casa casa;
    JFrame ventanaPrincipal;
    JPanel panelMonitoreo;
    JLabel lHora;
    JTextField hora;
    JButton setHora;
    JLabel lTemp;
    JTextField temp;
    JButton setTemp;
    JLabel lComida;
    JButton consumirComida;
    JButton rellenarComida;
    JLabel aire;
    JLabel luz;

    GUI(Casa casa){
        EventBus.subscribe(this, LowFood.class);
        EventBus.subscribe(this, ActualizarMedidorComida.class);
        EventBus.subscribe(this, EncenderAire.class);
        EventBus.subscribe(this, ApagarAire.class);
        EventBus.subscribe(this, PrenderLampara.class);
        EventBus.subscribe(this, ApagarLampara.class);

        this.casa = casa;
        ventanaPrincipal = new JFrame("Monitoreo de la casa");
        ventanaPrincipal.setBounds(0, 0, 450, 800);
        panelMonitoreo = new JPanel(null);
        panelMonitoreo.setBounds(0,0,450,800);
        lHora = new JLabel("Hora del dia");
        lHora.setBounds(50,20,300,20);
        hora = new JTextField();
        hora.setBounds(50,50,300,20);
        setHora = new JButton("Cambiar hora del dia");
        setHora.setBounds(50,80,300,20);
        lTemp= new JLabel("Temperatura");
        lTemp.setBounds(50,200,300,20);
        temp= new JTextField();
        temp.setBounds(50,230,300,20);
        setTemp = new JButton("Cambiar temperatura");
        setTemp.setBounds(50,260,300,20);
        lComida = new JLabel("Comida restante: " + casa.getRemainingFood().toString());
        lComida.setBounds(50,110,300,20);
        consumirComida = new JButton("Consumir comida");
        consumirComida.setBounds(50,140,300,20);
        rellenarComida= new JButton("Rellenar comida");
        rellenarComida.setBounds(50,170,300,20);
        aire = new JLabel("Aire acondicionado: Apagado"); 
        aire.setBounds(50,290,300,20);
        luz = new JLabel("Luz: Apagado"); 
        luz.setBounds(50,320,300,20);

        setHora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer nHora = Integer.parseInt(hora.getText()); 
                if(nHora != null && (nHora >= 0 && nHora <= 23))
                    casa.sensorLuminico.setHora(nHora);
            } 
        });

        setTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double nTemp = Double.parseDouble(temp.getText()); 
                if(nTemp!= null)
                    EventBus.publish(new Temperatura(nTemp)); 
            } 
        });

        consumirComida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventBus.publish(new ConsumirComida(200));
            }
        });

        rellenarComida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventBus.publish(new RellenarComida(100));
            }
        });


        panelMonitoreo.add(lHora);
        panelMonitoreo.add(hora);
        panelMonitoreo.add(setHora);
        panelMonitoreo.add(lTemp);
        panelMonitoreo.add(temp);
        panelMonitoreo.add(setTemp);
        panelMonitoreo.add(lComida);
        panelMonitoreo.add(consumirComida);
        panelMonitoreo.add(rellenarComida);
        panelMonitoreo.add(aire);
        panelMonitoreo.add(luz);
        ventanaPrincipal.add(panelMonitoreo);
        ventanaPrincipal.setVisible(true);
    }

    @Override
    public boolean handle(Event e) {
        if(e instanceof LowFood){
            JOptionPane.showMessageDialog(null, "YA NO TIENE COMIDA EL PERRO :-C");
            return true;
        }else if(e instanceof ActualizarMedidorComida){
            lComida.setText("Comida restante: " + casa.getRemainingFood().toString());
        }else if( e instanceof EncenderAire){
            aire.setText("Aire acondicionado: Encendido");
        }else if( e instanceof ApagarAire){
            aire.setText("Aire acondicionado: Apagado");
        }else if( e instanceof ApagarLampara){
            luz.setText("Luz: Apagado"); 
        }else if( e instanceof PrenderLampara){
            luz.setText("Luz: Encendido"); 

        }
        return false;
    }
}
