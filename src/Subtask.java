public class Subtask extends Task {
    private final Epic epicOwner;

    public Subtask(String name, String description, Epic epic_owner) {
        super(name, description);
        this.epicOwner = epic_owner;
    }

    Subtask(Subtask subtask) {
        super(subtask.getName(), subtask.getDescription());
        this.epicOwner = subtask.getEpicOwner();
    }

    public Epic getEpicOwner() {
        return epicOwner;
    }


    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", epicOwner=" + epicOwner +
                "} ";
    }
}
