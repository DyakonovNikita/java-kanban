import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    @Test
    public void shouldAddingTaskToHistoryAndGetTaskFromHistory() {
        Task task = new Task("Таск", "Описание таска");
        HistoryManager historyManager = Managers.getDefaultHistory();

        historyManager.add(task);
        ArrayList<Task> history = historyManager.getHistory();

        assertEquals(task, history.get(0));
    }


}