package week3;

public class TaskItem {

    int taskid;
    String taskDescription;
    TaskStatus taskStatus;

    public TaskItem(int taskid,String taskDescripstion,TaskStatus taskStatus ) {
        this.taskid = taskid;
        this.taskDescription = taskDescripstion;
        this.taskStatus = taskStatus;

    }
    public int getTaskid() {
        return taskid;
    }
    public String getTaskDescription()
    {
        return taskDescription;
    }
    public TaskStatus getTaskStatus()
    {
        return taskStatus;
    }

    public void setTaskid(int taskid)
    {
        this.taskid = taskid;
    }
    public void getTaskDescription(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }
    public void getTaskStatus(TaskStatus taskStatus)
    {
        this.taskStatus = taskStatus;
    }

}




