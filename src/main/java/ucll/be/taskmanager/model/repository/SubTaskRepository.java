package ucll.be.taskmanager.model.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ucll.be.taskmanager.model.domain.SubTask;

import java.util.List;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
