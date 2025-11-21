package com.example.korit_gov_spring_boot_study.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninRespDto {
    private String status;
    private String message;
}
