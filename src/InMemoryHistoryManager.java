import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{

    ArrayList<Task> history = new ArrayList<>(10);

    @Override
    public void add(Task task) {
        if (history.size() < 10) {
            history.add(task);
        } else {
            for (int i = 0; i < 9; i++) {
                history.add(i, history.get(i+1));
            }
            history.add(10, task);
        }
    }

    @Override
    public ArrayList<Task> getHistory() {
        return history;
    }
}
