import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {
    private static int tasksIdentifier = 1;
    private HashMap<Integer, Task> taskHashMap = new HashMap<>();
    private HashMap<Integer, Subtask> subtaskHashMap = new HashMap<>();
    private HashMap<Integer, Epic> epicHashMap = new HashMap<>();

    private HistoryManager historyManager = Managers.getDefaultHistory();

    // working with Tasks
    @Override
    public HashMap<Integer, Task> getTaskHashMap() {
        return taskHashMap;
    }

    @Override
    public void clearTaskHashMap() {
        this.taskHashMap = new HashMap<>();
    }

    @Override
    public Task getTaskById(int id) {
        historyManager.add(taskHashMap.get(id));
        return taskHashMap.get(id);
    }

    @Override
    public void addNewTask(Task task) {
        task.setId(tasksIdentifier);
        taskHashMap.put(tasksIdentifier, task);
        tasksIdentifier++;
    }

    @Override
    public void updateTask(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    @Override
    public void removeTaskById(int id) {
        taskHashMap.remove(id);
    }

    // working with Subtasks
    @Override
    public HashMap<Integer, Subtask> getSubtaskHashMap() {
        return subtaskHashMap;
    }

    @Override
    public void clearSubtaskHashMap() {
        this.subtaskHashMap = new HashMap<>();
    }

    @Override
    public Subtask getSubtaskById(int id) {
        historyManager.add(subtaskHashMap.get(id));
        return subtaskHashMap.get(id);
    }


    @Override
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

    @Override
    public void updateSubtask(Subtask subtask) {
        updateEpic(subtask.getEpicOwner());
        subtaskHashMap.put(subtask.getId(), subtask);
    }

    @Override
    public void removeSubtaskById(int id) {
        Subtask subtaskToRemove = subtaskHashMap.get(id);
        updateEpic(subtaskToRemove.getEpicOwner());
        subtaskHashMap.remove(id);
    }

    // working with Epics
    @Override
    public HashMap<Integer, Epic> getEpicHashMap() {
        return epicHashMap;
    }

    @Override
    public void clearEpicHashMap() {
        this.epicHashMap = new HashMap<>();
    }

    @Override
    public Epic getEpicById(int id) {
        historyManager.add(taskHashMap.get(id));
        return epicHashMap.get(id);
    }

    @Override
    public void addNewEpic(Epic epic) {
        epic.setId(tasksIdentifier);
        epicHashMap.put(tasksIdentifier, epic);
        tasksIdentifier++;
    }

    @Override
    public void updateEpic(Epic epic) {
        updateEpicStatus(epic);
        epicHashMap.put(epic.getId(), epic);
    }

    @Override
    public ArrayList<Subtask> getSubtasksByEpicId(int id) {
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

    @Override
    public void removeEpicById(int id) {
        epicHashMap.remove(id);
    }

    @Override
    public ArrayList<? extends Task> getHistory() {
        return historyManager.getHistory();
    }
}