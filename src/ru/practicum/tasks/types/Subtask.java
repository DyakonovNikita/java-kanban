package ru.practicum.tasks.types;

public class Subtask extends Task {
    private final Epic epicOwner;

    public Subtask(String name, String description, Epic epic_owner) {
        super(name, description);
        this.epicOwner = epic_owner;
    }

    public Epic getEpicOwner() {
        return epicOwner;
    }


    @Override
    public String toString() {
        return "tasks.Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", epicOwner=" + epicOwner +
                "} ";
    }
}
