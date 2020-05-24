package ucll.be.taskmanager.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucll.be.taskmanager.model.domain.SubTask;
import ucll.be.taskmanager.model.domain.Task;
import ucll.be.taskmanager.model.dto.SubTaskDTO;
import ucll.be.taskmanager.model.dto.TaskDTO;
import ucll.be.taskmanager.model.repository.SubTaskRepository;
import ucll.be.taskmanager.model.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SubTaskRepository subTaskRepository;

    @Override
    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(task -> taskConverter(task)).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDate(taskDTO.getDate());
        taskRepository.save(task);
    }

    @Override
    public TaskDTO getTask(long id) {
        Task task = taskRepository.getOne(id);
        return taskConverter(task);
    }

    @Override
    public void editTask(TaskDTO taskDTO) {
        Task task = taskRepository.getOne(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDate(taskDTO.getDate());
        taskRepository.save(task);
    }

    public void addSubTask(long id, SubTaskDTO subTaskDTO ){
        SubTask subTask = new SubTask();
        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setDescription(subTaskDTO.getDescription());
        subTask.setDate(subTaskDTO.getDate());
        subTask.setTask(taskRepository.getOne(id));
        subTaskRepository.save(subTask);
    }



    private SubTaskDTO subTaskConverter(SubTask subTask){
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setId(subTask.getId());
        subTaskDTO.setTitle(subTask.getTitle());
        subTaskDTO.setDescription(subTask.getDescription());
        subTaskDTO.setDate(subTask.getDate());
        return subTaskDTO;
    }

    private TaskDTO taskConverter(Task task){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setDate(task.getDate());
        taskDTO.setSubTasks(task.getSubTasks().stream().map(subTask -> subTaskConverter(subTask)).collect(Collectors.toList()));
        return taskDTO;
    }
}
