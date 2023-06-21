package com.board.board.post.service;

import com.board.board.comment.Comment;
import com.board.board.comment.dto.CommentSaveDto;
import com.board.board.post.Post;
import com.board.board.post.dto.PostSaveDto;
import com.board.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long save(PostSaveDto postSaveDto){
        Post res = postRepository.save(postSaveDto.DtoToPosts());
        return res.getId();
    }
    public Long addComment(Long postId, CommentSaveDto commentSaveDto){
        Post post = presentPost(postId);
        Comment comment = commentSaveDto.DtoToComment();
        post.addComment(comment);
        return postId;
    }
    public Long plusViewCount(Long postId){
        Post post = presentPost(postId);
        post.plusViewCount();
        return postId;
    }
    public Long updatePost(Long postId,String title,String content){
        Post post = presentPost(postId);
        post.updatePost(title,content);
        return postId;
    }
    public Post findPost(Long postId){
        return presentPost(postId);
    }
    public List<Post> findPostPaging(){

    }

    private Post presentPost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }
        throw new IllegalArgumentException("post 없음");
    }
    //public List<>

}
