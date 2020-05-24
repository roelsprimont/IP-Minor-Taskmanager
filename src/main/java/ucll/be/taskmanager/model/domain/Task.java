package ucll.be.taskmanager.model.domain;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
public class Task  {
    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @OneToMany(mappedBy = "task", fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubTask> subTasks;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d u 'at' h a");

    public Task(){subTasks = new ArrayList<>();}

    public Task(long id, String title, LocalDateTime date,String description){
        setId(id);
        setTitle(title);
        setDate(date);
        setDescription(description);
        subTasks = new ArrayList<>();
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addSubTask(SubTask subTask){
        subTasks.add(subTask);
    }

    public List<SubTask> getSubTasks(){
        return subTasks;
    }
}
