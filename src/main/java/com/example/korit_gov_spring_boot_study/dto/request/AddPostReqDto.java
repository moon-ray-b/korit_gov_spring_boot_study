package com.example.korit_gov_spring_boot_study.dto.request;

import com.example.korit_gov_spring_boot_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddPostReqDto {
    private String title;
    private String content;

    public Post toEntity(){
        return Post.builder()
                .content(content)
                .title(title)
                .build();
    }
}
