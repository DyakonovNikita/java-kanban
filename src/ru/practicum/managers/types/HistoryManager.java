package ru.practicum.managers.types;

import ru.practicum.tasks.types.Task;

import java.util.List;

public interface HistoryManager {
    void add(Task task);

    List<Task> getHistory();
}
