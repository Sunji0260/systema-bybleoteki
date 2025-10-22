import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
    private final Queue<Task> queue = new LinkedList<>();

    public synchronized void addTask(Task task) {
        queue.add(task);
        System.out.println(task + " добавлена в очередь");
        notify(); // Разбудить поток-обработчик
    }

    public synchronized Task getTask() {
        while (queue.isEmpty()) {
            try {
                wait(); // Ждём, пока появится задача
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return queue.poll();
    }
}
