import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    private static int tasksIdentifier = 1;
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
        taskHashMap.put(tasksIdentifier, task);
        tasksIdentifier++;
    }

    public void updateTask(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    public void removeTaskById(int id) {
        taskHashMap.remove(id);
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
        Epic epicOwner = subtask.getEpicOwner();
        ArrayList<Subtask> subtasks = epicOwner.getSubtasks();
        subtasks.add(subtask);
        epicOwner.setSubTasks(subtasks);
        updateEpic(subtask.getEpicOwner());
        subtaskHashMap.put(tasksIdentifier, subtask);
        tasksIdentifier++;
    }

    public void updateSubtask(Subtask subtask) {
        updateEpic(subtask.getEpicOwner());
        subtaskHashMap.put(subtask.getId(), subtask);
    }

    public void removeSubtaskById(int id) {
        Subtask subtaskToRemove = subtaskHashMap.get(id);
        updateEpic(subtaskToRemove.getEpicOwner());
        subtaskHashMap.remove(id);
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
        epicHashMap.put(tasksIdentifier, epic);
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
            if (subtask.getStatus() == TaskStatus.IN_PROGRESS) {
                epic.setStatus(TaskStatus.IN_PROGRESS);
                return;
            }

            if (subtask.getStatus() != epicStatus) {
                if (subtask.getStatus() == TaskStatus.DONE) {
                    epicStatus = TaskStatus.DONE;
                } else {
                    epic.setStatus(TaskStatus.IN_PROGRESS);
                    return;
                }
            }
        }
        epic.setStatus(epicStatus);
    }

    public void removeEpicById(int id) {
        epicHashMap.remove(id);
    }

}