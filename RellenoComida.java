/**
 * RellenarComida
 */
public class RellenoComida implements Event{
    int cantidad;

    RellenoComida(int cantidad){
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
