import org.junit.jupiter.api.Test;
import ru.practicum.managers.types.InMemoryHistoryManager;
import ru.practicum.managers.util.Managers;
import ru.practicum.tasks.types.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    @Test
    public void shouldAddingTaskToHistoryAndGetTaskFromHistory() {
        Task task = new Task("Таск", "Описание таска");
        InMemoryHistoryManager historyManager = Managers.getDefaultHistory();

        historyManager.add(task);
        ArrayList<Task> history = historyManager.getHistory();

        assertEquals(task, history.get(0));
    }


}