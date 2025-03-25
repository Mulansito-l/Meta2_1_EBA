public class Lampara implements Consumer{
    boolean encendida = false;

    @Override
    public boolean handle(Event e) {

        if (e instanceof EncendidoLampara){
            encendida = true;
        }
        else if (e instanceof ApagadoLampara){
            encendida = false;
        }
        return true;
    }

    public Lampara() {
        EventBus.subscribe(this, EncendidoLampara.class);
        EventBus.subscribe(this, ApagadoLampara.class);
    }
}
