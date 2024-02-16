public class Subtask extends Task {
    final private Epic epic_owner;

    Subtask(String name, String description, TaskStatus status, int id, Epic epic_owner) {
        super(name, description, status, id);
        this.epic_owner = epic_owner;
    }

    Subtask(Subtask subtask, int id) {
        super(subtask.getName(), subtask.getDescription(), subtask.getStatus(), id);
        this.epic_owner = subtask.getEpic_owner();
    }

    public Epic getEpic_owner() {
        return epic_owner;
    }
}
