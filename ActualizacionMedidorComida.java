/**
 * ActualizarMedidorComida
 */
public class ActualizacionMedidorComida implements Event{
    
    ActualizacionMedidorComida(){

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
