/**
 * SensorLuminico
 */
public class SensorLuminico {
    boolean horaDeEncender = false;
    int hora;

    public void verificarHoraDeEncender() {
        if ((hora > 20 || hora < 6)) {
            horaDeEncender = true;
            EventBus.publish(new PrenderLampara());
        }
        else {
            EventBus.publish(new ApagarLampara());
            horaDeEncender = false;
        }
    }

    public void setHora(int hora){
        this.hora = hora;
    } 
}
