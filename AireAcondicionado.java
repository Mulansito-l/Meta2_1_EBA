public class AireAcondicionado implements Consumer {
    private final double limite; // Temperatura límite

    public AireAcondicionado(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean handle(Event e) {
        if (e instanceof Temperatura) {
            Temperatura tempEvent = (Temperatura) e;
            if (tempEvent.getTemperature() > limite) {
                System.out.println("Aire acondicionado encendido: Temperatura actual = " + tempEvent.getTemperature() + "°C");
                return true;
            }
        }
        return false;
    }
}
