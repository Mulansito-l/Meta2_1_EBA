public class Lampara implements Consumer{
    boolean encendida = false;

    @Override
    public boolean handle(Event e) {

        if (e instanceof PrenderLampara){
            encendida = true;
        }
        else if (e instanceof ApagarLampara){
            encendida = false;
        }
        return true;
    }

    public Lampara() {
        EventBus.subscribe(this, PrenderLampara.class);
        EventBus.subscribe(this, ApagarLampara.class);
    }
}
