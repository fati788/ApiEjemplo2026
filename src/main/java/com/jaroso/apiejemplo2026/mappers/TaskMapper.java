package com.jaroso.apiejemplo2026.mappers;

import com.jaroso.apiejemplo2026.dtos.TaskCreateDto;
import com.jaroso.apiejemplo2026.dtos.TaskDto;
import com.jaroso.apiejemplo2026.dtos.TaskUpdateDto;
import com.jaroso.apiejemplo2026.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);
    Task toEntity(TaskCreateDto taskDto);
    Task updateToEntity(TaskUpdateDto taskUpdateDto);

}
