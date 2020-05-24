package ucll.be.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ucll.be.taskmanager.model.dto.SubTaskDTO;
import ucll.be.taskmanager.model.dto.TaskDTO;
import ucll.be.taskmanager.model.service.TaskService;

import javax.validation.Valid;


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
    public String getTaskById(@PathVariable long id, Model model){
        TaskDTO task = taskService.getTask(id);
        model.addAttribute("task",task);
        model.addAttribute("subtasks",task.getSubTasks());
        return "task";
    }

    @GetMapping("/tasks/new")
    public String getTaskForm(){
        return "addTask";
    }

    @PostMapping("/tasks/newTask")
    public String addTask(@ModelAttribute TaskDTO task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addTask";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String getEditPage(@PathVariable long id, Model model){
        model.addAttribute("task",taskService.getTask(id));
        return "editTask";
    }

    @PostMapping("/tasks/editTask")
    public String editTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "editTask";
        }
        taskService.editTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("/tasks/newSubTask/{id}")
    public String addSubTask(@PathVariable long id, @ModelAttribute SubTaskDTO subTask, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addSubTask";
        }
        taskService.addSubTask(id, subTask);
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String getNewSubTaskPage(@PathVariable long id, Model model){
        model.addAttribute("task",taskService.getTask(id));
        return "addSubTask";
    }

}
