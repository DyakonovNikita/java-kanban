import org.junit.jupiter.api.Test;
import ru.practicum.managers.types.InMemoryHistoryManager;
import ru.practicum.managers.types.InMemoryTaskManager;
import ru.practicum.managers.util.Managers;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    public void shouldReturnInMemoryHistoryManager() {
        InMemoryHistoryManager inMemoryHistoryManager = new InMemoryHistoryManager();
        assertEquals(inMemoryHistoryManager.getClass(), Managers.getDefaultHistory().getClass());
    }

    @Test
    public void shouldReturnInMemoryTaskManager() {
        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
        assertEquals(inMemoryTaskManager.getClass(), Managers.getDefault().getClass());
    }
}