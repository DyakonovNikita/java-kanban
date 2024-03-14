package ru.practicum.managers.types;

import ru.practicum.tasks.types.Epic;
import ru.practicum.tasks.types.Subtask;
import ru.practicum.tasks.types.Task;


import java.util.List;
import java.util.Map;

public interface TaskManager {
    // working with Tasks
    Map<Integer, Task> getTaskHashMap();

    void clearTaskHashMap();

    Task getTaskById(int id);

    void addNewTask(Task task);

    void updateTask(Task task);

    void removeTaskById(int id);

    // working with Subtasks
    Map<Integer, Subtask> getSubtaskHashMap();

    void clearSubtaskHashMap();

    Subtask getSubtaskById(int id);

    void addNewSubtask(Subtask subtask);

    void updateSubtask(Subtask subtask);

    void removeSubtaskById(int id);

    // working with Epics
    Map<Integer, Epic> getEpicHashMap();

    void clearEpicHashMap();

    Epic getEpicById(int id);

    void addNewEpic(Epic epic);

    void updateEpic(Epic epic);

    List<Subtask> getSubtasksByEpicId(int id);

    void removeEpicById(int id);

    List<? extends Task> getHistory();
}
