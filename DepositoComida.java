/**
 * DepositoComida
 */
public class DepositoComida implements Consumer{
    private boolean paused;
    private int food;

    DepositoComida(int food){
        EventBus.subscribe(this, LowFood.class);
        EventBus.subscribe(this, ConsumoComida.class);
        EventBus.subscribe(this, RellenoComida.class);
        this.food = food;
        this.paused = false;
    }

    @Override
    public boolean handle(Event e) {

        if(e instanceof ConsumoComida){
            consumeFood((Integer) e.getData());
            return true;
        }else if(e instanceof RellenoComida){
            refillFood((Integer)e.getData());
            return true;
        }
        return false;
    }

    public void consumeFood(int consumed) {
        if (paused || food <= 0) return;
        
        food = Math.max(food - consumed, 0);
        if (food < 300) {
            EventBus.publish(new LowFood(food));
        }
        EventBus.publish(new ActualizacionMedidorComida());
    }

    public void refillFood(int amount) {
        if (amount <= 0) {
            return;
        }
        food += amount;
        paused = false;
        EventBus.publish(new ActualizacionMedidorComida());
    }

    public int getCurrentFood() {
        return food;
    }

    public boolean isPaused() {
        return paused;
    }
}
