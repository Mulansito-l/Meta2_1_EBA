/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Casa casa = new Casa();
        GUI gui = new GUI(casa);
        while (true) {
            casa.realizarMediciones();
            EventBus.dispatch(); 
        }
    }
}
