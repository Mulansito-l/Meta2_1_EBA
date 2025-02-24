public class DogHouse {
    private int food = 1000;
    private boolean paused = false;

    public void consumeFood() {
        if (paused || food <= 0) return;
        
        food = Math.max(food - 250, 0);
        
        if (food <= 100) {
            paused = true;
            EventBus.publish(new PauseForRefillEvent(food));
        } else if (food <= 300) {
            EventBus.publish(new LowFoodEvent(food));
        }
    }

    public void refillFood(int amount) {
        if (amount <= 0) {
            System.out.println("Error: cantidad debe ser positiva");
            return;
        }
        food += amount;
        paused = false;
        System.out.println(" Recarga exitosa: +" + amount + "g | Total: " + food + "g");
    }

    public int getCurrentFood() {
        return food;
    }

    public boolean isPaused() {
        return paused;
    }
}