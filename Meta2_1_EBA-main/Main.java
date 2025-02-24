import java.util.Scanner;

public class Main {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        EventBus.subscribe(new LowFoodAlertHandler(), LowFoodEvent.class);
        EventBus.subscribe(new PauseAlertHandler(), PauseForRefillEvent.class);
        
        DogHouse dogHouse = new DogHouse();
        Scanner scanner = new Scanner(System.in);

        // Hilo de consumo automático
        Thread autoConsumeThread = new Thread(() -> {
            while (running) {
                try {
                    if (!dogHouse.isPaused()) {
                        System.out.println("\n--- Consumo automático ---");
                        System.out.println("Comida actual: " + dogHouse.getCurrentFood() + "g");
                        dogHouse.consumeFood();
                        EventBus.dispatch();
                    }
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        autoConsumeThread.start();

        // Hilo de interacción
        while (running) {
            System.out.print("\n[OPCIONES] [R]ecargar | [S]alir > ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            switch (input) {
                case "R":
                    if (dogHouse.isPaused()) {
                        System.out.print("Gramos a recargar: ");
                        try {
                            int amount = Integer.parseInt(scanner.nextLine());
                            dogHouse.refillFood(amount);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingrese solo números");
                        }
                    } else {
                        System.out.println("⚠️ El sistema no está pausado. Recarga disponible en cualquier momento.");
                    }
                    break;
                case "S":
                    running = false;
                    System.out.println("\nCerrando programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        // Cierre limpio
        try {
            autoConsumeThread.interrupt();
            autoConsumeThread.join();
            scanner.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}