/**
 * Temperatura
 */
public class Temperatura implements Event{

    private final String name;
    private final double temperatura;

    public Temperatura(double temperatura) {
        this.name = "Evento de temperatura";
        this.temperatura = temperatura;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getData() {
        return temperatura;
    }
}
