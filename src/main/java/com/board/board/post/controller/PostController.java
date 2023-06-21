package com.board.board.post.controller;

import com.board.board.comment.dto.CommentRequestDto;
import com.board.board.post.Post;
import com.board.board.post.dto.PostResponseDto;
import com.board.board.post.dto.PostRequestDto;
import com.board.board.post.service.PostService;
import com.board.board.util.Constant;
import com.board.board.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add/comment/{id}")
    public Long commentSave(@RequestBody CommentRequestDto requestDto,@PathVariable Long id){
        return postService.addComment(id, requestDto);
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
        //댓글삭제추가 or 엔티티 캐스케이드
    }
    @GetMapping("/posts")
    public Page<PostResponseDto> findAllPaging(int page){
        PageRequest pageRequest = PageRequest.of(page,Constant.POST_PAGE_SIZE,
                Sort.by(Constant.POST_UPDATE_TIME).descending());
        return postService.findPostsPaging(pageRequest);

    }
    @GetMapping("/posts/{title}")
    public Page<PostResponseDto> findAllContentPaging(int page,@PathVariable String title){
        PageRequest pageRequest = PageRequest.of(page, Constant.POST_PAGE_SIZE,
                Sort.by(Constant.POST_UPDATE_TIME).descending());

        return postService.findPostsTitlePaging(title,pageRequest);

    }
    //
}
