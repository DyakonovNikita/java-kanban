package ru.practicum.managers.util;

import ru.practicum.managers.types.InMemoryHistoryManager;
import ru.practicum.managers.types.InMemoryTaskManager;
import ru.practicum.managers.types.TaskManager;

public class Managers {
    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static InMemoryHistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

}
