package com.jaroso.apiejemplo2026.controllers;

import com.jaroso.apiejemplo2026.dtos.TaskCreateDto;
import com.jaroso.apiejemplo2026.dtos.TaskDto;
import com.jaroso.apiejemplo2026.dtos.TaskUpdateDto;
import com.jaroso.apiejemplo2026.entities.Task;
import com.jaroso.apiejemplo2026.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        return ResponseEntity.ok(taskService.findAll());
    }
    @GetMapping("/tasks/order/{order}")
   public ResponseEntity<List<TaskDto>> getAllTaskOrder(@PathVariable String order){
       return ResponseEntity.ok(taskService.findAllByOrderByTitle(order));
   }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable Long id){
        Optional<TaskDto> task = taskService.findById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/tasks/title/{title}")
    public ResponseEntity<TaskDto> getTaskByTitle(@PathVariable String title){
        Optional<TaskDto> task = taskService.findByTitle(title);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskCreateDto task){
        //return ResponseEntity.ok(taskService.saveTask(task));
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));
    }
    @PutMapping("/tasks")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskUpdateDto task){
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> delete(@PathVariable Long id){
        Optional<TaskDto> task = taskService.findById(id);
        if (task.isPresent()) {
            //Si el id es válido lo borramos y devolvemos 204
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } else {
            //Si el id no es de una tarea válida
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/tasks")
    public ResponseEntity<Void> deleteAll(){
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/search/{texto}")
    public ResponseEntity<List<TaskDto>> buscarPorTitulo(@PathVariable String texto){
        return ResponseEntity.ok(taskService.buscarPorTitulo(texto));
    }

}
