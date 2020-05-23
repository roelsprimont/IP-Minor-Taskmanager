package ucll.be.taskmanager.domain;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Task  {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d u 'at' h a");
    private String title;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    private long id;
    private List<SubTask> subTasks;

    public Task(){}

    public Task(long id, String title, LocalDateTime date){
        setId(id);
        setTitle(title);
        setDate(date);
        setDescription("No description");
        subTasks = new ArrayList<>();
    }

    public Task(long id, String title, LocalDateTime date,String description){
        this(id,title,date);
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
