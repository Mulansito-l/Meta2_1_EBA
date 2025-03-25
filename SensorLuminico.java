/**
 * SensorLuminico
 */
public class SensorLuminico {
    boolean horaDeEncender = false;
    int hora;

    public void verificarHoraDeEncender() {
        if ((hora > 20 || hora < 6)) {
            horaDeEncender = true;
            EventBus.publish(new EncendidoLampara());
        }
        else {
            EventBus.publish(new ApagadoLampara());
            horaDeEncender = false;
        }
    }

    public void setHora(int hora){
        this.hora = hora;
    } 
}
