package org.tasktrackerapp.tasktracker.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tasktrackerapp.tasktracker.Models.TaskModel;
import org.tasktrackerapp.tasktracker.Services.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listTasks(Model model) {
        List<TaskModel> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "list_tasks";
    }

    @GetMapping("/add")
    public String showAddTaskForm(TaskModel task) {
        return "add_task";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute("task") TaskModel task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable Long id, Model model) {
        TaskModel task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit_task";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @ModelAttribute("task") TaskModel task) {
        task.setId(id);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
