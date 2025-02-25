/**
 *
 * AireAcondicionado
 */
public class AireAcondicionado implements Consumer{
    
    private final double limite; // Temperatura límite

    public AireAcondicionado(double limite) {
        EventBus.subscribe(this, Temperatura.class);
        this.limite = limite;
    }

    @Override
    public boolean handle(Event e) {
        if (e instanceof Temperatura) {
            Temperatura tempEvent = (Temperatura) e;
            if ((Double) tempEvent.getData() > limite) {
                EventBus.publish(new EncenderAire());
                return true;
            }else{
                EventBus.publish(new ApagarAire());
                return false;
            }
        }
        return false;
    }
}
