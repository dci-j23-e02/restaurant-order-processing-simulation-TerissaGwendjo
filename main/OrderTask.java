
class OrderTask implements Runnable {
    private int orderId;
    private int preparationTime; // in seconds

    public OrderTask(int orderId, int preparationTime) {
        this.orderId = orderId;
        this.preparationTime = preparationTime;
    }

    @Override
    public void run() {
        System.out.println("Chef started preparing Order #" + orderId);

        try {
            // Simulate the time taken to prepare the order
            Thread.sleep(preparationTime * 1000);
        } catch (InterruptedException e) {
            System.out.println("Order #" + orderId + " preparation was interrupted.");
            return;
        }

        System.out.println("Order #" + orderId + " is ready!");
    }
}
