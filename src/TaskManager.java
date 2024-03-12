import java.util.ArrayList;
import java.util.HashMap;

public interface TaskManager {
    // working with Tasks
    HashMap<Integer, Task> getTaskHashMap();

    void clearTaskHashMap();

    Task getTaskById(int id);

    void addNewTask(Task task);

    void updateTask(Task task);

    void removeTaskById(int id);

    // working with Subtasks
    HashMap<Integer, Subtask> getSubtaskHashMap();

    void clearSubtaskHashMap();

    Subtask getSubtaskById(int id);

    void addNewSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    void removeSubtaskById(int id);

    // working with Epics
    HashMap<Integer, Epic> getEpicHashMap();

    void clearEpicHashMap();

    Epic getEpicById(int id);

    void addNewEpic(Epic epic);

    void updateEpic(Epic epic);

    ArrayList<Subtask> getSubtasksByEpicId(int id);

    void removeEpicById(int id);

    ArrayList<? extends Task> getHistory();
}
