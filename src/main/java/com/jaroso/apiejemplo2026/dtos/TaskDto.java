package com.jaroso.apiejemplo2026.dtos;

import java.time.LocalDate;

public record TaskDto(Long id , String title , LocalDate finishDate) {
}
