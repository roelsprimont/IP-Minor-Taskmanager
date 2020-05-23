package ucll.be.taskmanager.service;

import org.springframework.stereotype.Service;
import ucll.be.taskmanager.domain.SubTask;
import ucll.be.taskmanager.domain.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private List<Task> taskRepository;

    public TaskServiceImpl() {
        taskRepository = new ArrayList<>();
        Task t1 = new Task(1, "Kamer opruimen", LocalDateTime.now());
        Task t2 = new Task(2, "Hond eten geven", LocalDateTime.now());
        Task t3 = new Task(3, "Huiswerk maken", LocalDateTime.now(), "Wiskunde pg237 en Frans woordjes oefenen");
        taskRepository.add(t1);
        taskRepository.add(t2);
        taskRepository.add(t3);
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository;
    }

    @Override
    public void addTask(Task task) {
        task.setId(taskRepository.get(taskRepository.size() - 1).getId() + 1);
        taskRepository.add(task);
    }

    @Override
    public Task getTask(long id) {
        for (Task t : taskRepository) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void editTask(Task task) {
        Task oldTask = getTask(task.getId());
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setDate(task.getDate());
    }

    @Override
    public List<SubTask> getSubTasks(long id){
        return getTask(id).getSubTasks();
    }
}
