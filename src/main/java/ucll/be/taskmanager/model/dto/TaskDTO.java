package ucll.be.taskmanager.model.dto;


import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    private long id;
    
    private String title;

    private String description;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    private List<SubTaskDTO> subTasks;

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d u 'at' h a");

    public TaskDTO(){
        subTasks = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<SubTaskDTO> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

    public void addSubTask(SubTaskDTO subTask){
        subTasks.add(subTask);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFormattedDate(){
        return date.format(formatter);
    }
}
