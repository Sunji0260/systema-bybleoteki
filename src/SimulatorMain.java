public class SimulatorMain {
    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();

        Worker w1 = new Worker(queue, 1);
        Worker w2 = new Worker(queue, 2);
        Worker w3 = new Worker(queue, 3);

        w1.start();
        w2.start();
        w3.start();

        for (int i = 1; i <= 10; i++) {
            queue.addTask(new Task(i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        w1.interrupt();
        w2.interrupt();
        w3.interrupt();
    }
}
