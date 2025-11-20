package com.example.korit_gov_spring_boot_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Integer memberId;
    private String name;
    private int age;
}
