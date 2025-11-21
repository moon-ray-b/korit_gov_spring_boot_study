package com.example.korit_gov_spring_boot_study.service;

import com.example.korit_gov_spring_boot_study.dto.request.AddPostReqDto;

import com.example.korit_gov_spring_boot_study.dto.response.AddPostRespDto;
import com.example.korit_gov_spring_boot_study.dto.response.GetPostAllRespDto;
import com.example.korit_gov_spring_boot_study.dto.response.GetPostByPostIdRespDto;
import com.example.korit_gov_spring_boot_study.dto.response.GetPostListByKeywordRespDto;
import com.example.korit_gov_spring_boot_study.entity.Post;
import com.example.korit_gov_spring_boot_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    public AddPostRespDto addpostup(AddPostReqDto addpostReqDto){
        if (postRepository.findPostByTitle(addpostReqDto.getTitle()) != null){
            AddPostRespDto addPostRespDto = new AddPostRespDto("failed", "사용중인 title입니다");
            return addPostRespDto;
        }
        postRepository.addPost(addpostReqDto.toEntity());
        return new AddPostRespDto("success", "게시물이 등록되었습니다");
    }
    public GetPostAllRespDto getPostAll(){
        return new GetPostAllRespDto("success", "전체조회를 완료했습니다.", postRepository.getPostAll());
    }

    public GetPostByPostIdRespDto getPostByPostId(Integer postId){
        Post foundPost = postRepository.findPostByPostId(postId);
        if (foundPost == null){
            return new GetPostByPostIdRespDto("failed", "조회된 결과가 없습니다.",null);
        }
        return new GetPostByPostIdRespDto("success", "단건조회를 완료했습니다", foundPost);
    }
    public GetPostListByKeywordRespDto getPostListByKeyword(String keyword){
        return new GetPostListByKeywordRespDto("success", "키워드 조회를 완료했습니다", postRepository.findPostByKeyword(keyword));
    }

}
