import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Subtask> subtasks = new ArrayList<>();

    Epic(String name, String description) {
        super(name, description);
    }

    Epic(Epic epic) {
        super(epic.getName(), epic.getDescription());
        this.subtasks = epic.subtasks;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubTasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

}
