import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(tasks, tasksFromTasksManager, "Task Manager work wrong.");
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

        assertEquals(fullTasks, fullTasksFromTasksManager, "Task Manager work wrong.");
    }

}