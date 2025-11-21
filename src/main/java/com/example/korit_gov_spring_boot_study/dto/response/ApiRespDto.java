package com.example.korit_gov_spring_boot_study.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiRespDto {
    private String status;
    private String message;
}
