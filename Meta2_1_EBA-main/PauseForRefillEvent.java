public class PauseForRefillEvent implements Event {
    private final int currentFood;

    public PauseForRefillEvent(int currentFood) {
        this.currentFood = currentFood;
    }

    @Override
    public String getName() {
        return "PauseForRefillEvent";
    }

    @Override
    public Object getData() {
        return currentFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }
}