/**
 * DepositoComida
 */
public class DepositoComida implements Consumer{
    private boolean paused;
    private int food;

    DepositoComida(int food){
        EventBus.subscribe(this, LowFood.class);
        EventBus.subscribe(this, ConsumirComida.class);
        EventBus.subscribe(this, RellenarComida.class);
        this.food = food;
        this.paused = false;
    }

    @Override
    public boolean handle(Event e) {

        if(e instanceof ConsumirComida){
            consumeFood((Integer) e.getData());
            return true;
        }else if(e instanceof RellenarComida){
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
        EventBus.publish(new ActualizarMedidorComida());
    }

    public void refillFood(int amount) {
        if (amount <= 0) {
            return;
        }
        food += amount;
        paused = false;
        EventBus.publish(new ActualizarMedidorComida());
    }

    public int getCurrentFood() {
        return food;
    }

    public boolean isPaused() {
        return paused;
    }
}
