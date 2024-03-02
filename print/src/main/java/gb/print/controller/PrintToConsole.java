package gb.print.controller;

import gb.task_manager.model.TaskModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/print")
@Component
public class PrintToConsole {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from print controller! Microservice №2";
    }

    @PostMapping("/task-data")
    public void printTaskData(@RequestBody TaskModel taskModel) {
        System.out.println("Received task data: " + taskModel.toString());
    }

}
