package ucll.be.taskmanager.model.service;

import ucll.be.taskmanager.model.domain.SubTask;
import ucll.be.taskmanager.model.domain.Task;
import ucll.be.taskmanager.model.dto.SubTaskDTO;
import ucll.be.taskmanager.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();
    void addTask(TaskDTO task);
    TaskDTO getTask(long id);
    void editTask(TaskDTO task);
    void addSubTask(long id, SubTaskDTO subTaskDTO);
    void deleteTask(TaskDTO task);
    void deleteAllTasks();
}
