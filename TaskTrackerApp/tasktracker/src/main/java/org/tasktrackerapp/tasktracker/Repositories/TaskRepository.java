package org.tasktrackerapp.tasktracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tasktrackerapp.tasktracker.Models.TaskModel;


public interface TaskRepository extends JpaRepository<TaskModel, Long>{
    
}
