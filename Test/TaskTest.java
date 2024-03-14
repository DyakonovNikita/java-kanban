import org.junit.jupiter.api.Test;
import ru.practicum.tasks.types.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void taskShouldBeEqualIfIDIsEqual() {
        Task task1 = new Task("Таск1", "Описание Таска1");
        Task task2 = new Task("Таск2", "Описание таска2");
        task1.setId(1);
        task2.setId(1);
        assertEquals(task1, task2, "Comparison error, check ur equal realisation.");
    }

    @Test
    public void taskShouldBeUnequalIfIdIsUnequal() {
        Task task1 = new Task("Таск1", "Описание Таска1");
        Task task2 = new Task("Таск1", "Описание таска1");
        task1.setId(1);
        task2.setId(2);
        assertNotEquals(task1, task2, "Compression error, check ur equal realization.");
    }

}