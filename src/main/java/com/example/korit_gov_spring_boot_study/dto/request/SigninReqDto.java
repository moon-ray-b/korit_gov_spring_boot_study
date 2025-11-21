package com.example.korit_gov_spring_boot_study.dto.request;

import com.example.korit_gov_spring_boot_study.entity.User;
import lombok.Data;

@Data
public class SigninReqDto {
    private String username;
    private String password;
    private String email;

}
