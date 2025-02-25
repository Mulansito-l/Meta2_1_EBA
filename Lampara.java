public class Lampara implements Consumer{
    boolean encendida = false;

    @Override
    public boolean handle(Event e) {

        if (e instanceof EventoPrenderLampara){
            encendida = true;
            System.out.println(encendida);
        }

        else if (e instanceof EventoApagarLampara){
            encendida = false;
            System.out.println(encendida);
        }
        return true;
    }

    public Lampara() {
        EventBus.subscribe(this, EventoPrenderLampara.class);
        EventBus.subscribe(this, EventoApagarLampara.class);
    }
}
