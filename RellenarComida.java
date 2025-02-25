/**
 * RellenarComida
 */
public class RellenarComida implements Event{
    int cantidad;

    RellenarComida(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String getName() {
        return "Rellenar comida";
    }

    @Override
    public Object getData() {
        return cantidad;
    }
}
