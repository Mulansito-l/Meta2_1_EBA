import java.util.Random;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {

        AireAcondicionado ac = new AireAcondicionado(28.0);

        EventBus.subscribe(ac, Temperatura.class);

        Random random = new Random();

        while (true) {
            double temperature = 20 + random.nextDouble() * 10; // Genera temp random
            System.out.println("Nueva temperatura detectada: " + temperature + "°C");
            EventBus.publish(new Temperatura(temperature));
            EventBus.dispatch();
            try {
                Thread.sleep(1000); // Esperar 1 segundo antes de la siguiente lectura
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

