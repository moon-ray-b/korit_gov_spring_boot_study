package com.example.korit_gov_spring_boot_study.dto.response;

import com.example.korit_gov_spring_boot_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetPostByPostIdRespDto {
    private String status;
    private String message;
    private Post data;
}
