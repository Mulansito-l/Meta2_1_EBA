public class SensorLuminico {

    boolean horaDeEncender = false;
    int hora;

    public void verificarHoraDeEncender() {
        if ((hora > 20 || hora < 6)) {
            horaDeEncender = true;
            EventBus.publish(new EventoPrenderLampara());
        }
        else {
            EventBus.publish(new EventoApagarLampara());
            horaDeEncender = false;
        }
    }

    public void setHora(int hora){
        this.hora = hora;
    }
}