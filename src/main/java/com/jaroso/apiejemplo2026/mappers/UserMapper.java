package com.jaroso.apiejemplo2026.mappers;

import com.jaroso.apiejemplo2026.dtos.*;
import com.jaroso.apiejemplo2026.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);
    User toEntity(UserCreateDto userDto);

}
