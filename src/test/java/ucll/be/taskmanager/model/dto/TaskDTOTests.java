package ucll.be.taskmanager.model.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskDTOTests {
    private TaskDTO task = new TaskDTO();

    @Test
    public void setIdTest(){
        task.setId(123);
        assertEquals(123,task.getId());
    }

    @Test
    public void setTitleTest(){
        task.setTitle("testTitle");
        assertNotNull(task.getTitle());
        assertEquals("testTitle",task.getTitle());
    }

    @Test
    public void setDescriptionTest(){
        task.setDescription("desc");
        assertNotNull(task.getDescription());
        assertEquals("desc",task.getDescription());
    }

    @Test
    public void setDateTest(){
        LocalDateTime date = LocalDateTime.now();
        task.setDate(date);
        assertNotNull(task.getDate());
        assertEquals(date,task.getDate());
    }
}
