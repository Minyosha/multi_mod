package gb.task_manager.service;


import gb.task_manager.model.TaskModel;
import gb.task_manager.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskModel createTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }


    public TaskModel updateTask(Long id, TaskModel taskModelDetails) {
        Optional<TaskModel> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskModel taskModel = optionalTask.get();
            taskModel.setDescription(taskModelDetails.getDescription());
            taskModel.setStatus(taskModelDetails.getStatus());
            taskModel.setCreated(taskModelDetails.getCreated());
            return taskRepository.save(taskModel);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }


    public void deleteAll() {
        taskRepository.deleteAll();
    }

    public void updateTaskStatusById(Long id, TaskModel taskModel) {
        Optional<TaskModel> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskModel taskModel1 = optionalTask.get();
            taskModel1.setStatus(taskModel.getStatus());
            taskRepository.save(taskModel1);
        }
    }

    public List<TaskModel> getAllTasksByStatus(TaskModel.Status status) { // Изменение типа параметра на объект перечисления
        return taskRepository.findAllByStatus(status);
    }
}
