package ucll.be.taskmanager.model.domain;

import org.hibernate.annotations.Fetch;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class SubTask
{
    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Task.class)
    @JoinColumn(name="task_id",  nullable = false)
    private Task task;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d u 'at' h a");

    public SubTask(){}
    public SubTask(long id, String title, LocalDateTime date,String description){
        setId(id);
        setTitle(title);
        setDescription(description);
        setDate(date);
    }

    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFormattedDate(){
        return date.format(formatter);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

}

