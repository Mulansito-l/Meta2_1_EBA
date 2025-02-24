/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            EventBus.dispatch(); 
        }
    }
}
