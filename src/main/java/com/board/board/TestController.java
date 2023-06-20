package com.board.board;

import com.board.board.comment.Comment;
import com.board.board.comment.dto.CommentSaveDto;
import com.board.board.comment.dto.CommentViewDto;
import com.board.board.comment.repository.CommentRepository;
import com.board.board.post.Post;
import com.board.board.post.dto.PostsSaveDto;
import com.board.board.post.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final PostsRepository postsRepository;
    private final CommentRepository commentRepository;

    @GetMapping("/")
    @Transactional
    public List<CommentViewDto> abc(){
        PostsSaveDto postsSaveDto = new PostsSaveDto("abc", "내용", "공주");
        Post postResult = postsRepository.save(postsSaveDto.DtoToPosts());
        CommentSaveDto commentSaveDto=new CommentSaveDto("내용","고공",postResult);
        commentRepository.save(commentSaveDto.DtoToComment());
        commentRepository.save(commentSaveDto.DtoToComment());
        commentRepository.save(commentSaveDto.DtoToComment());

        PageRequest pageRequest=PageRequest.of(0,2);
        Page<Post> find = postsRepository.findAll(pageRequest);
        List<Post> content = find.getContent();
        for (Post post : content) {
            System.out.println("posts = " + post.getId());
        }
        Page<Comment> byPost = commentRepository.findByPost(postResult, pageRequest);
        List<Comment> comments = byPost.getContent();
        List<CommentViewDto> viewDto=new ArrayList<>();
        for (Comment comment : comments) {
            System.out.println("comment = " + comment.getId());

            viewDto.add(new CommentViewDto(comment));
        }


        return viewDto;
        //return postResult.getId().toString();
    }
    @GetMapping("/abc")
    @Transactional
    public String abcd(Long id,String title,String content){
        Optional<Post> byId = postsRepository.findById(id);
        if(byId.isPresent()){
            Post post = byId.get();
            post.updatePosts(title,content);
            return "yes";
        }
        return "no";

    }
}
