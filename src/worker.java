public class Worker extends Thread {
    private final TaskQueue taskQueue;
    private final int workerId;

    public Worker(TaskQueue taskQueue, int workerId) {
        this.taskQueue = taskQueue;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        while (true) {
            Task task = taskQueue.getTask();
            if (task != null) {
                System.out.println("Поток " + workerId + " выполняет " + task);
                try {
                    Thread.sleep(1000); // Имитация обработки задачи
                } catch (InterruptedException e) {
                    System.out.println("Поток " + workerId + " завершает работу");
                    break;
                }
            }
        }
    }
}
