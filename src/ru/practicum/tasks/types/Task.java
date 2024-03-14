package ru.practicum.tasks.types;

import ru.practicum.tasks.util.TaskStatus;


public class Task {
    protected String name;
    protected String description;
    protected TaskStatus status;
    protected int id = -1;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NEW;
    }

    public Task(Task otherTask) {
        this.name = otherTask.name;
        this.description = otherTask.description;
        this.status = otherTask.status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task otherTask = (Task) obj;
        return this.id == otherTask.id && this.id != -1;
    }

    @Override
    public String toString() {
        return "tasks.Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
