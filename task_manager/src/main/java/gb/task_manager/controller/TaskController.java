package gb.task_manager.controller;

import gb.task_manager.model.TaskModel;
import gb.task_manager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<TaskModel> taskModels = taskService.getAllTasks();
        model.addAttribute("tasks", taskModels);
        return "tasks";
    }

    @PostMapping("/tasks")
    public String createNewTask(@ModelAttribute("taskForm") TaskModel taskModel) {
        taskModel.calculateCreated();
        taskService.createTask(taskModel);
        return "redirect:/tasks";
    }


    @PostMapping("/tasks-deleteAll")
    public String deleteAll() {
        taskService.deleteAll();
        return "redirect:/tasks";
    }

    @PostMapping("/tasks-delete-by-id")
    public String deleteTaskById(@RequestParam Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }

    @PostMapping("tasks-update-by-id")
    public String updateTaskStatusById(@RequestParam Long id, @ModelAttribute("taskForm") TaskModel taskModel) {
        taskService.updateTaskStatusById(id, taskModel);
        return "redirect:/tasks";
    }


    @GetMapping("/tasks-by-status")
    public String getAllTasksByStatus(Model model) {
        List<TaskModel> taskModels = taskService.getAllTasksByStatus(TaskModel.Status.NOT_STARTED);
        model.addAttribute("tasks", taskModels);
        return "tasks-by-status";
    }


    @PostMapping("/tasks-by-status")
    public String getTasksByStatus(@RequestParam("status") TaskModel.Status status, Model model) {
        List<TaskModel> taskModels = taskService.getAllTasksByStatus(status);
        model.addAttribute("tasks", taskModels);
        model.addAttribute("status", status); // Добавляем статус для сохранения в форму
        return "tasks-by-status"; // Возвращаем название представления, где отображается таблица с задачами
    }



}
