package ucll.be.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ucll.be.taskmanager.domain.SubTask;
import ucll.be.taskmanager.domain.Task;
import ucll.be.taskmanager.service.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute( "tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String getTaskById(@PathVariable Long id, Model model){
        model.addAttribute("task",taskService.getTask(id));
        model.addAttribute("subtasks",taskService.getSubTasks(id));
        return "task";
    }

    @GetMapping("/tasks/new")
    public String getTaskForm(){
        return "addTask";
    }

    @PostMapping("/tasks/newTask")
    public String addTask(@ModelAttribute Task task){
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model){
        model.addAttribute("task",taskService.getTask(id));
        return "editTask";
    }

    @PostMapping("/tasks/editTask")
    public String editTask(@ModelAttribute Task task){
        taskService.editTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/newSubTask/{id}")
    public String addSubTask(@PathVariable Long id, @ModelAttribute SubTask subTask){
        Task mainTask = taskService.getTask(id);
        mainTask.addSubTask(subTask);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String getNewSubTaskPage(@PathVariable Long id, Model model){
        model.addAttribute("task",taskService.getTask(id));
        return "addSubTask";
    }

}
