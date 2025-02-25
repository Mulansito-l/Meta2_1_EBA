/**
 * LowFoodEvent
 */
public class LowFood implements Event{

    private final int currentFood;

    public LowFood(int currentFood) {
        this.currentFood = currentFood;
    }

    @Override
    public String getName() {
        return "LowFoodEvent";
    }

    @Override
    public Object getData() {
        return currentFood;
    }

    // Método adicional para claridad
    public int getCurrentFood() {
        return currentFood;
    }
    
}
