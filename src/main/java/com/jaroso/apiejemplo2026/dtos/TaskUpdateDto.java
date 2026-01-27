package com.jaroso.apiejemplo2026.dtos;

import java.time.LocalDate;

public record TaskUpdateDto(Long id, String title , String description , LocalDate finishDate) {
}
