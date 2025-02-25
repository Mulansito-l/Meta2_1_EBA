/**
 * ConsumirComida
 */
public class ConsumirComida implements Event{

    int cantidad;

    ConsumirComida(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String getName() {
        return "Consumir comida";
    }

    @Override
    public Object getData() {
        return cantidad;
    }
    
}
