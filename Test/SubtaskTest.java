import org.junit.jupiter.api.Test;
import ru.practicum.tasks.types.Epic;
import ru.practicum.tasks.types.Subtask;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {
    Epic epic1 = new Epic("Эпик1", "Описание эпика1");
    Epic epic2 = new Epic("Эпик2", "Описание эпика2");


    @Test
    public void subtaskShouldBeEqualIfIDIsEqual() {
        Subtask subtask1 = new Subtask("Сабтаск1", "Описание Сабтаска1", epic1);
        Subtask subtask2 = new Subtask("Сабтаск2", "Описание Сабтаска2", epic2);
        subtask1.setId(1);
        subtask2.setId(1);
        assertEquals(subtask1, subtask2, "Comparison error, check ur equal realisation.");
    }

    @Test
    public void subtaskShouldBeUnequalIfIdIsUnequal() {
        Subtask subtask1 = new Subtask("Сабтаск1", "Описание Сабтаска1", epic1);
        Subtask subtask2 = new Subtask("Сабтаск1", "Описание Сабтаска1", epic1);
        subtask1.setId(1);
        subtask2.setId(2);
        assertNotEquals(subtask1, subtask2, "Compression error, check ur equal realization.");
    }

}