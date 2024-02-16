import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Subtask> subtasks;

    Epic(String name, String description, TaskStatus status, int id, ArrayList<Subtask> subtasks) {
        super(name, description, status, id);
        this.subtasks = subtasks;
    }

    Epic(Epic epic, int id) {
        super(epic.getName(), epic.getDescription(), epic.getStatus(), id);
        this.subtasks = epic.subtasks;
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubTasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
        updateEpicStatus(this);
    }

    private void updateEpicStatus(Epic epic) {
        ArrayList<Subtask> subtasks = epic.getSubtasks();

        if (subtasks.isEmpty()) {
            epic.setStatus(TaskStatus.NEW);
            return;
        }
        TaskStatus epicStatus = TaskStatus.NEW;
        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() != epicStatus) {
                if (epicStatus != TaskStatus.DONE) {
                    epicStatus = TaskStatus.DONE;
                } else {
                    epic.setStatus(TaskStatus.IN_PROGRESS);
                    return;
                }
            }
        }
        epic.setStatus(epicStatus);
    }
}
