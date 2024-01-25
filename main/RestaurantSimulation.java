import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RestaurantSimulation {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool size
        ExecutorService executorService = Executors.newFixedThreadPool(3); // Change the pool size as needed

        // Submit multiple OrderTask instances to the executor service
        executorService.submit(new OrderTask(1, 5));
        executorService.submit(new OrderTask(2, 3));
        executorService.submit(new OrderTask(3, 8));

        // Graceful shutdown of the executor service
        executorService.shutdown();

        try {
            // Wait for all orders to finish with a timeout
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                // Force a shutdown if the timeout is reached
                System.out.println("Timeout reached. Forcefully shutting down the kitchen.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All orders have been completed or the timeout was reached.");
    }
}
