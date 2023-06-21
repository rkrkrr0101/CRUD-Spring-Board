package com.board.board.post.controller;

import com.board.board.post.Post;
import com.board.board.post.dto.PostResponseDto;
import com.board.board.post.dto.PostRequestDto;
import com.board.board.post.service.PostService;
import com.board.board.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping("/{id}")
    public Result< PostResponseDto> findPost(@PathVariable("id") Long id){
        Post post = postService.findPost(id);
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return new Result<>(postResponseDto);
    }
    @PostMapping("/save")
    public Long save(@RequestBody PostRequestDto requestDto){
        return postService.save(requestDto);
    }
    @PostMapping("/plus/viewcount/{id}")
    public Long plusViewCount(@PathVariable Long id){
        return postService.plusViewCount(id);
    }
    @PatchMapping("/{id}")
    public Long update(@RequestBody PostRequestDto requestDto, @PathVariable Long id){
        return postService.updatePost(id, requestDto.getTitle(), requestDto.getContent());
    }
    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return postService.deletePost(id);
    }
    //
}
