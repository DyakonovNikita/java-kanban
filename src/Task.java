public class Task {
    private String name;
    private String description;
    static private int sum_of_tasks = 0;
    final int id;
    private TaskStatus status;

    Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = sum_of_tasks;
        sum_of_tasks++;
        this.status = TaskStatus.NEW;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getSum_of_tasks() {
        return sum_of_tasks;
    }

    public int getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
