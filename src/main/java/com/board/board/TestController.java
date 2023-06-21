package com.board.board;

import com.board.board.comment.Comment;
import com.board.board.comment.dto.CommentRequestDto;
import com.board.board.comment.dto.CommentResponseDto;
import com.board.board.comment.repository.CommentRepository;
import com.board.board.post.Post;
import com.board.board.post.dto.PostRequestDto;
import com.board.board.post.repository.PostRepository;
import com.board.board.util.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final PostRepository postsRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/")
    @Transactional
    public Result< List<CommentResponseDto>> abc(){
        PostRequestDto postRequestDto = new PostRequestDto("abc", "내용", "공주");
        Post postResult = postsRepository.save(postRequestDto.DtoToPosts());
        CommentRequestDto commentRequestDto =new CommentRequestDto("내용","고공");
        Comment save1 = commentRepository.save(commentRequestDto.DtoToComment());
        Comment save2 = commentRepository.save(commentRequestDto.DtoToComment());
        Comment save3 = commentRepository.save(commentRequestDto.DtoToComment());
        postResult.addComment(save1);
        postResult.addComment(save2);
        postResult.addComment(save3);
        System.out.println("------ ");
        PageRequest pageRequest=PageRequest.of(0,2);
        Page<Post> find = postsRepository.findAll(pageRequest);
        List<Post> content = find.getContent();
        for (Post post : content) {
            System.out.println("posts = " + post.getId());
        }



        return new Result<>(null);
        //return postResult.getId().toString();
    }
    @GetMapping("/abc")
    @Transactional
    public String abcd(Long id,String title,String content){
        Optional<Post> byId = postsRepository.findById(id);
        if(byId.isPresent()){
            Post post = byId.get();
            post.updatePost(title,content);
            return "yes";
        }
        return "no";
    }
}
