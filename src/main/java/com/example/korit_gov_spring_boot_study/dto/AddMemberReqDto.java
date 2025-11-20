package com.example.korit_gov_spring_boot_study.dto;

import com.example.korit_gov_spring_boot_study.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddMemberReqDto {
    private String name;
    private int age;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }
}
