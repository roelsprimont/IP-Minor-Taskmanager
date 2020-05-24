package ucll.be.taskmanager.model.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ucll.be.taskmanager.model.dto.SubTaskDTO;
import ucll.be.taskmanager.model.dto.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskServiceTests {
    @Autowired
    private TaskService taskService;

    //Most of these tests also test adding a test so we won't be testing that specifically...

    @Test
    public void testGetTasks(){
        //Setup new task
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setTitle("test");
        taskDTO1.setDate(LocalDateTime.now());
        taskDTO1.setDescription("testdescription");

        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setTitle("2222");
        taskDTO2.setDate(LocalDateTime.now());
        taskDTO2.setDescription("2desc");

        //Component to test
        taskService.addTask(taskDTO1);
        taskService.addTask(taskDTO2);
        List<TaskDTO> tasks = taskService.getTasks();

        //Checking...
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(2, tasks.size());

        TaskDTO task = tasks.get(0);
        assertEquals("test",task.getTitle());

        TaskDTO task2 = tasks.get(1);
        assertEquals("2desc",task2.getDescription());


        //Cleaning up
        taskService.deleteAllTasks();
    }

    @Test
    public void testDeleteTask(){
        //Setup new task
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("TOEDIT");
        taskDTO.setDate(LocalDateTime.now());
        taskDTO.setDescription("TOEDIT DESCRIPTION");

        //Testing if add went fine
        taskService.addTask(taskDTO);
        TaskDTO taskDTOFromService = taskService.getTasks().get(0);
        assertEquals(taskDTO.getTitle(), taskDTOFromService.getTitle());

        //Testing delete
        taskService.deleteTask(taskDTOFromService);
        List<TaskDTO> tasks = taskService.getTasks();
        assertTrue(tasks.isEmpty());
        assertEquals(0,tasks.size());

        //Cleaning up
        taskService.deleteAllTasks();
    }

    @Test
    public void testAddSubTask(){
        //Setup new task
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("TOEDIT");
        taskDTO.setDate(LocalDateTime.now());
        taskDTO.setDescription("TOEDIT DESCRIPTION");

        //Testing if add went fine
        taskService.addTask(taskDTO);
        TaskDTO taskDTOFromService = taskService.getTasks().get(0);
        assertEquals(taskDTO.getTitle(), taskDTOFromService.getTitle());

        //Setting up new subtask
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("subtask!");
        subTaskDTO.setDate(LocalDateTime.now());
        subTaskDTO.setDescription("subtask description!");

        //Testing the addSubTask
        taskService.addSubTask(taskDTOFromService.getId(),subTaskDTO);
        List<TaskDTO> tasks = taskService.getTasks();
        List<SubTaskDTO> subTasks = tasks.get(0).getSubTasks();
        assertNotNull(subTasks);
        assertFalse(subTasks.isEmpty());
        assertEquals(1, subTasks.size());
        assertEquals("subtask!",subTasks.get(0).getTitle());

        //Cleaning up
        taskService.deleteAllTasks();
    }
}
