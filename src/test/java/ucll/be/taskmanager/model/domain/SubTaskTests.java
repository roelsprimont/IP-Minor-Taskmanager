package ucll.be.taskmanager.model.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SubTaskTests {
    private SubTask subTask = new SubTask();

    @Test
    public void setIdTest(){
        subTask.setId(123);
        assertEquals(123,subTask.getId());
    }

    @Test
    public void setTitleTest(){
        subTask.setTitle("testTitle");
        assertNotNull(subTask.getTitle());
        assertEquals("testTitle",subTask.getTitle());
    }

    @Test
    public void setDescriptionTest(){
        subTask.setDescription("desc");
        assertNotNull(subTask.getDescription());
        assertEquals("desc",subTask.getDescription());
    }

    @Test
    public void setDateTest(){
        LocalDateTime date = LocalDateTime.now();
        subTask.setDate(date);
        assertNotNull(subTask.getDate());
        assertEquals(date,subTask.getDate());
    }
}
