### Exercise: Restaurant Order Processing Simulation

#### Background
Imagine you are developing a simulation for a restaurant's kitchen where multiple chefs (threads) are preparing orders. Each order takes a certain amount of time to prepare. The restaurant has a fixed number of chefs, and you need to ensure that all orders are processed efficiently using a thread pool.

#### Task
Create a Java program that simulates the processing of restaurant orders using a fixed thread pool. Each `OrderTask` represents a different order that needs to be prepared by a chef. You will use an `ExecutorService` to manage a pool of chef threads that execute these order tasks.

#### Requirements
1. Define a class `OrderTask` that implements `Runnable`. Each order should have a unique ID and a preparation time (in seconds).
2. In your `main` method, create an `ExecutorService` with a fixed thread pool size representing the number of chefs.
3. Submit multiple `OrderTask` instances to the executor service, each with a different order ID and preparation time.
4. After submitting all orders, initiate a graceful shutdown of the executor service.
5. Wait for all orders to finish with a timeout (e.g., 5 minutes). If all orders are not finished within the timeout, force a shutdown.
6. Print a message before an order starts being prepared, and another message after it has been completed, including the order ID.
7. After all orders have been processed or the timeout has been reached, print a summary message indicating the completion of the simulation.

#### Sample Output
```
Chef started preparing Order #1
Chef started preparing Order #2
Order #1 is ready!
Chef started preparing Order #3
Order #2 is ready!
...
All orders have been completed or the timeout was reached.
```

#### Tips
- Use `Thread.sleep()` to simulate the time taken to prepare each order.
- Handle `InterruptedException` in your `OrderTask` run method.
- Consider using `System.currentTimeMillis()` to track and print the time taken for each order.

This exercise will help students understand how to use the concurrency API to manage multiple tasks and how to coordinate the graceful shutdown of an application using multiple threads. It also reinforces the importance of handling interruptions and the practical use of thread pools in real-world scenarios.
