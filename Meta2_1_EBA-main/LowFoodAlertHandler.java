public class LowFoodAlertHandler implements Consumer {
    @Override
    public boolean handle(Event event) {
        if (event instanceof LowFoodEvent) {
            int foodLevel = ((LowFoodEvent) event).getCurrentFood();
            System.out.println("ALERTA! Comida baja: " + foodLevel + " gramos. ¡Recarga el recipiente!");
            return true;
        }
        return false;
    }
}