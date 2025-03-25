/**
 * ConsumirComida
 */
public class ConsumoComida implements Event{

    int cantidad;

    ConsumoComida(int cantidad){
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
