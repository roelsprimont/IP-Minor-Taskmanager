package ucll.be.taskmanager.model.repository;

import ucll.be.taskmanager.model.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
