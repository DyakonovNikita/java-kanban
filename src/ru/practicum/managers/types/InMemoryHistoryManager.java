package ru.practicum.managers.types;

import ru.practicum.tasks.types.Task;
import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager {

    private ArrayList<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (history.size() < 10) {
            history.add(task);
        } else {
            for (int i = 0; i < 9; i++) {
                history.set(i, history.get(i+1));
            }
            history.set(9, task);
        }
    }

    @Override
    public ArrayList<Task> getHistory() {
        return history;
    }
}
