package org.tasktrackerapp.tasktracker.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.tasktrackerapp.tasktracker.Models.TaskModel;
import org.tasktrackerapp.tasktracker.Repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public TaskModel saveTask(TaskModel task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskModel getTaskById(Long id) {
        Optional<TaskModel> optionalTask = taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
