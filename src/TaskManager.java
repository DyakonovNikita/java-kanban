import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {
    static private int taskIdentifier = 0;
    static private int subtaskIdentifier = 0;
    static private int epicIdentifier = 0;
    private HashMap<Integer, Task> taskHashMap = new HashMap<>();
    private HashMap<Integer, Subtask> subtaskHashMap = new HashMap<>();
    private HashMap<Integer, Epic> epicHashMap = new HashMap<>();

    // working with Tasks
    public HashMap<Integer, Task> getTaskHashMap() {
        return taskHashMap;
    }

    public void setTaskHashMap(HashMap<Integer, Task> taskHashMap) {
        this.taskHashMap = taskHashMap;
    }

    public void clearTaskHashMap() {
        this.taskHashMap = new HashMap<>();
    }

    public Task getTaskById(int id) {
        return taskHashMap.get(id);
    }

    public void addNewTask(Task task) {
        Task newTask = new Task(task, taskIdentifier);
        taskHashMap.put(taskIdentifier, newTask);
        taskIdentifier++;
    }

    public void updateTask(Task task) {
        taskHashMap.put(task.getId(), task);
    }

    // working with Subtasks
    public HashMap<Integer, Subtask> getSubtaskHashMap() {
        return subtaskHashMap;
    }

    public void setSubtaskHashMap(HashMap<Integer, Subtask> subtaskHashMap) {
        this.subtaskHashMap = subtaskHashMap;
    }

    public void clearSubtaskHashMap() {
        this.subtaskHashMap = new HashMap<>();
    }

    public Subtask getSubtaskById(int id) {
        return subtaskHashMap.get(id);
    }

    public void addNewSubtask(Subtask subtask) {
        Subtask newSubtask = new Subtask(subtask, subtaskIdentifier);
        subtaskHashMap.put(subtaskIdentifier, newSubtask);
        subtaskIdentifier++;
    }

    public void updateSubtask(Subtask subtask) {
        subtaskHashMap.put(subtask.getId(), subtask);
    }

    // working with Epics
    public HashMap<Integer, Epic> getEpicHashMap() {
        return epicHashMap;
    }

    public void setEpicHashMap(HashMap<Integer, Epic> epicHashMap) {
        this.epicHashMap = epicHashMap;
    }

    public void clearEpicHashMap() {
        this.epicHashMap = new HashMap<>();
    }

    public Epic getEpicById(int id) {
        return epicHashMap.get(id);
    }

    public void addNewEpic(Epic epic) {
        Epic newEpic = new Epic(epic, epicIdentifier);
        epicHashMap.put(epicIdentifier, newEpic);
        epicIdentifier++;
    }

    public void updateEpic(Epic epic) {
        epicHashMap.put(epic.getId(), epic);
    }

    public ArrayList<Subtask> getSubtasksById(int id) {
        return epicHashMap.get(id).getSubtasks();
    }

}