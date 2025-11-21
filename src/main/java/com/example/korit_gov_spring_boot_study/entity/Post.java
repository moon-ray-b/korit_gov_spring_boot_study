package com.example.korit_gov_spring_boot_study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer postId;
    private String title;
    private String content;
}

/*
* 추가
* title 중복확인
* 조회
* 전체리스트 조회
* 단건 조호 (PostId)
* keyword 조회 (keyword = > title 포함여부
* */
