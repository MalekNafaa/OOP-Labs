package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStructures {
    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the github", TaskStatus.TO_DO),
                new TaskItem(2, "Prepare for the quiz", TaskStatus.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab2", TaskStatus.COMPLETED));
    }

    // TODO create a method to get all objects
    public List<TaskItem> getTasks() {
        return tasks;
    }

    // TODO create a method getByStatus that will accept a Status parameter and filter the tasks with the provided status
    public List<TaskItem> getByStatus(TaskStatus status) {
        List<TaskItem> newTasksbyStatus = new ArrayList<>();
        for (TaskItem task : tasks) {
            if (task.getTaskStatus().equals(status))
                newTasksbyStatus.add(task);
        }
        return newTasksbyStatus;
    }

    // TODO create a method to find tasks whose id parameter greater than or equal to 2
    public List<TaskItem> taskidbiggeror2(int taskid) {
        List<TaskItem> res = new ArrayList<>();
        for (TaskItem task : tasks) {
            if (task.getTaskid() >= 2)
                res.add(task);
        }
        return res;
    }

    // TODO create a method that will, by using the forEach stream method, print to the console the description of each task
    /*public List<TaskItem> getdscripstionforeach(String taskDescripstion) {
        List<TaskItem> res = new ArrayList<>();
        for (TaskItem task : tasks) {
                res.add(task);
        }
        return res;
    }*/
    public void getdscripstionforeach() {
        for (TaskItem task : tasks) {
            System.out.println(task.getTaskDescription());
        }
    }
}
