package ucll.be.taskmanager.service;

import ucll.be.taskmanager.domain.SubTask;
import ucll.be.taskmanager.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    void addTask(Task task);
    Task getTask(long id);
    void editTask(Task task);
    List<SubTask> getSubTasks(long id);
}
