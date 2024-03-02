package gb.task_manager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskControllerWithRest {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from task manager! Microservice №1";
    }
}
