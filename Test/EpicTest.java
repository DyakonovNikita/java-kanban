import org.junit.jupiter.api.Test;
import ru.practicum.tasks.types.Epic;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    public void epicShouldBeEqualIfIDIsEqual() {
        Epic epic1 = new Epic("Эпик1", "Описание эпика1");
        Epic epic2 = new Epic("Эпик2", "Описание эпика2");
        epic1.setId(1);
        epic2.setId(1);
        assertEquals(epic1, epic2, "Comparison error, check ur equal realisation.");
    }

    @Test
    public void epicShouldBeUnequalIfIdIsUnequal() {
        Epic epic1 = new Epic("Эпик1", "Описание эпика1");
        Epic epic2 = new Epic("Эпик1", "Описание эпика1");
        epic1.setId(1);
        epic2.setId(2);
        assertNotEquals(epic1, epic2, "Compression error, check ur equal realization.");
    }

}