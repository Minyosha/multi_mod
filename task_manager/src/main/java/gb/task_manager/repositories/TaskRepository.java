package gb.task_manager.repositories;

import gb.task_manager.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository <TaskModel, Long> {
    List<TaskModel> findAllByStatus(TaskModel.Status status);
}
