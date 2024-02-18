import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    static private int tasksIdentifier = 0;
    private HashMap<Integer, Task> taskHashMap = new HashMap<>();
    private HashMap<Integer, Subtask> subtaskHashMap = new HashMap<>();
    private HashMap<Integer, Epic> epicHashMap = new HashMap<>();

    public static int getTasksIdentifier() {
        return tasksIdentifier;
    }

    // working with Tasks
    public HashMap<Integer, Task> getTaskHashMap() {
        return taskHashMap;
    }

    public void clearTaskHashMap() {
        this.taskHashMap = new HashMap<>();
    }

    public Task getTaskById(int id) {
        return taskHashMap.get(id);
    }

    public void addNewTask(Task task) {
        task.setId(tasksIdentifier);
        Task newTask = new Task(task);
        taskHashMap.put(tasksIdentifier, newTask);
        tasksIdentifier++;
    }

    public void updateTask(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    // working with Subtasks
    public HashMap<Integer, Subtask> getSubtaskHashMap() {
        return subtaskHashMap;
    }

    public void clearSubtaskHashMap() {
        this.subtaskHashMap = new HashMap<>();
    }

    public Subtask getSubtaskById(int id) {
        return subtaskHashMap.get(id);
    }

    public void addNewSubtask(Subtask subtask) {
        subtask.setId(tasksIdentifier);
        Subtask newSubtask = new Subtask(subtask);
        updateEpic(newSubtask.getEpicOwner());
        subtaskHashMap.put(tasksIdentifier, newSubtask);
        tasksIdentifier++;
    }

    public void updateSubtask(Subtask subtask) {
        updateEpic(subtask.getEpicOwner());
        subtaskHashMap.put(subtask.getId(), subtask);
    }

    // working with Epics
    public HashMap<Integer, Epic> getEpicHashMap() {
        return epicHashMap;
    }

    public void clearEpicHashMap() {
        this.epicHashMap = new HashMap<>();
    }

    public Epic getEpicById(int id) {
        return epicHashMap.get(id);
    }

    public void addNewEpic(Epic epic) {
        epic.setId(tasksIdentifier);
        Epic newEpic = new Epic(epic);
        updateEpic(newEpic);
        epicHashMap.put(tasksIdentifier, newEpic);
        tasksIdentifier++;
    }

    public void updateEpic(Epic epic) {
        updateEpicStatus(epic);
        epicHashMap.put(epic.getId(), epic);
    }

    public ArrayList<Subtask> getSubtasksById(int id) {
        return epicHashMap.get(id).getSubtasks();
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