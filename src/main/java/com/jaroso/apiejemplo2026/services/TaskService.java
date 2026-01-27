package com.jaroso.apiejemplo2026.services;

import com.jaroso.apiejemplo2026.dtos.TaskCreateDto;
import com.jaroso.apiejemplo2026.dtos.TaskDto;
import com.jaroso.apiejemplo2026.dtos.TaskUpdateDto;
import com.jaroso.apiejemplo2026.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskDto> findAll();
    List<TaskDto> findAllByOrderByTitle(String order);
    Optional<TaskDto> findById(Long id);
    Optional<TaskDto> findByTitle(String title);

    TaskDto saveTask(TaskCreateDto task);
    TaskDto updateTask(TaskUpdateDto task);

    List<TaskDto> buscarPorTitulo(String texto);



    void deleteTask(Long id);
    void deleteAll();


}
