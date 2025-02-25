/**
 * ActualizarMedidorComida
 */
public class ActualizarMedidorComida implements Event{
    
    ActualizarMedidorComida(){

    }

    @Override
    public String getName() {
        return "Actualizar medidor";
    }
    @Override
    public Object getData() {
        return null;
    } 
}
