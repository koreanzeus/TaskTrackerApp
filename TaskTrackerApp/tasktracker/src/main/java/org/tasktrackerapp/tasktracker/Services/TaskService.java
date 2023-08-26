package org.tasktrackerapp.tasktracker.Services;

import java.util.List;

import org.tasktrackerapp.tasktracker.Models.TaskModel;

public interface TaskService {
    List<TaskModel> getAllTasks();
    TaskModel saveTask(TaskModel task);
    TaskModel getTaskById(Long id);
    void deleteTask(Long id);
}
