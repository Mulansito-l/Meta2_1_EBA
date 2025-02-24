public class PauseAlertHandler implements Consumer {
    @Override
    public boolean handle(Event event) {
        if (event instanceof PauseForRefillEvent) {
            int foodLevel = ((PauseForRefillEvent) event).getCurrentFood();
            System.out.println("\n CONSUMO PAUSADO!");
            System.out.println("Motivo: La comida llegó a " + foodLevel + " gramos");
            System.out.println("Por favor recarga para continuar");
            return true;
        }
        return false;
    }
}