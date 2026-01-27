package com.jaroso.apiejemplo2026.repositories;

import com.jaroso.apiejemplo2026.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task , Long> {
      Optional<Task> findByTitle(String title);
      List<Task> findAllByOrderByTitleAsc();
      List<Task> findAllByOrderByTitleDesc();

      @Query("Select t from tasks t where t.title LIKE %:texto%")
      List<Task> buscarPorTitulo(@Param("texto") String texto);
}
