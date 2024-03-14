import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.practicum.managers.types.InMemoryTaskManager;
import ru.practicum.tasks.types.Epic;
import ru.practicum.tasks.types.Subtask;
import ru.practicum.tasks.types.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {
    Task task = new Task("Таск", "Описание таска");
    Epic epic = new Epic("Эпик", "Описание эпика");
    Subtask subtask = new Subtask("Сабтаск", "Описание сабтаска", epic);
    InMemoryTaskManager taskManager = new InMemoryTaskManager();
    ArrayList<Task> tasks = new ArrayList<>();
    ArrayList<Task> tasksFromTasksManager = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        tasks.add(task);
        tasks.add(epic);
        tasks.add(subtask);

        taskManager.addNewTask(task);
        taskManager.addNewEpic(epic);
        taskManager.addNewSubtask(subtask);

        tasksFromTasksManager.add(task);
        tasksFromTasksManager.add(epic);
        tasksFromTasksManager.add(subtask);
    }

    @Test
    public void shouldContainTasksAndFindThemById() {
        assertEquals(tasks, tasksFromTasksManager, "tasks.Task Manager work wrong.");
    }

    @Test
    public void shouldNotChangeTaskWhenAddItToManager() {
        ArrayList<String> fullTasks = new ArrayList<>();
        for (Task task : tasks) {
            fullTasks.add(task.toString());
        }

        ArrayList<String> fullTasksFromTasksManager = new ArrayList<>();
        for (Task task : tasksFromTasksManager) {
            fullTasksFromTasksManager.add(task.toString());
        }

        assertEquals(fullTasks, fullTasksFromTasksManager, "tasks.Task Manager work wrong.");
    }

    @Test
    public void shouldSaveTaskHistory() {
        for (int i = 0; i < 30; i ++) {
            Task task = new Task("Таск " + i, "Описание таска " + i);
            taskManager.addNewTask(task);
            taskManager.getTaskById(i);

        }

        ArrayList<Integer> rightHistoryTaskIdsList = new ArrayList<>();
        for (int i = 20; i < 30; i++) {
            rightHistoryTaskIdsList.add(i);
        }

        ArrayList<Integer> testHistoryTaskIdsList = new ArrayList<>();
        for (Task task : taskManager.getHistory()) {
            testHistoryTaskIdsList.add(task.getId());
        }

        assertEquals(testHistoryTaskIdsList, rightHistoryTaskIdsList);

    }
}