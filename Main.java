/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        Lampara lampara = new Lampara();
        SensorLuminico sensor = new SensorLuminico();

        sensor.setHora(2);
        sensor.verificarHoraDeEncender();

        while (true) {
            EventBus.dispatch(); 
        }

    }
}
