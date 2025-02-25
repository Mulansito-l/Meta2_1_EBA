public class SensorNivelComida implements Event{

    float nivelDeComida;

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Object getData() {
        return nivelDeComida;
    }
}