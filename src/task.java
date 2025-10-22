public class Task {
    private final int id;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Задача №" + id;
    }
}
