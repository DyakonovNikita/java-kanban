import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Тесты:\n");
//        TaskManager taskManager = new TaskManager();
//
//        Epic epic1 = new Epic("Первый эпик", "Важная задача");
//        taskManager.addNewEpic(epic1);
//        if (taskManager.getEpicHashMap().get(0).getStatus() == TaskStatus.NEW) {
//            System.out.println("1 - ✅");
//        } else {
//            System.out.println("1 - ❌");
//        }
//
//        Subtask subtask1 =  new Subtask("Первый сабтаск", "Важная подзадача", epic1);
//        taskManager.addNewSubtask(subtask1);
//        ArrayList<Subtask> subtasks = epic1.getSubtasks();
//        subtasks.add(subtask1);
//        epic1.setSubTasks(subtasks);
//        taskManager.updateEpic(epic1);
//        if (taskManager.getEpicHashMap().get(0).getStatus() == TaskStatus.NEW) {
//            System.out.println("2 - ✅");
//        } else {
//            System.out.println("2 - ❌");
//        }
//
//        subtask1.setStatus(TaskStatus.DONE);
//        taskManager.updateSubtask(subtask1);
//        if (taskManager.getEpicHashMap().get(0).getStatus() == TaskStatus.DONE) {
//            System.out.println("3 - ✅");
//        } else {
//            System.out.println("3 - ❌");
//        }
//
//        Subtask subtask2 = new Subtask("Второй сабтаск", "Не менее важная подзадача", epic1);
//        taskManager.addNewSubtask(subtask2);
//        subtasks.add(subtask2);
//        epic1.setSubTasks(subtasks);
//        taskManager.updateEpic(epic1);
//        if (taskManager.getEpicHashMap().get(0).getStatus() == TaskStatus.IN_PROGRESS) {
//            System.out.println("4 - ✅");
//        } else {
//            System.out.println("4 - ❌");
//        }
        TaskManager taskManager = new TaskManager();
        Epic epic1 = new Epic("Эпик 1","Нужно сделать");
        taskManager.addNewEpic(epic1);
        Subtask subtask1 = new Subtask("Subtask1 создания ","Написать что то ", epic1);
        taskManager.addNewSubtask(subtask1);
        Subtask subtask2 = new Subtask("Subtask2 создания ","Написать что то ", epic1);
        taskManager.addNewSubtask(subtask2);
        System.out.println(epic1);  //NEW

        subtask1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.updateSubtask(subtask1);
        System.out.println(epic1); //IN_PROGRESS

        subtask2.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask2);
        System.out.println(epic1); //IN_PROGRESS

        subtask1.setStatus(TaskStatus.DONE);
        taskManager.updateSubtask(subtask1);
        System.out.println(epic1); //DONE

        System.out.println(taskManager.getEpicHashMap());
        System.out.println(taskManager.getSubtaskHashMap());
    }
}
