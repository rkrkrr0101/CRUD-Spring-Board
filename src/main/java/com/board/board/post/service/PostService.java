package com.board.board.post.service;

import com.board.board.comment.Comment;
import com.board.board.comment.dto.CommentRequestDto;
import com.board.board.post.Post;
import com.board.board.post.dto.PostRequestDto;
import com.board.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    @Transactional
    public Long save(PostRequestDto postRequestDto){
        Post res = postRepository.save(postRequestDto.DtoToPosts());
        return res.getId();
    }
    @Transactional
    public Long addComment(Long postId, CommentRequestDto commentRequestDto){
        Post post = presentPost(postId);
        Comment comment = commentRequestDto.DtoToComment();
        post.addComment(comment);
        return postId;
    }//이건 좀 생각해보자 여기있는게 맞는지 모르겠다
    @Transactional
    public Long plusViewCount(Long postId){
        Post post = presentPost(postId);
        return post.plusViewCount();

    }
    @Transactional
    public Long updatePost(Long postId,String title,String content){
        Post post = presentPost(postId);
        post.updatePost(title,content);
        return postId;
    }
    @Transactional
    public Long deletePost(Long postId){
        Post post = presentPost(postId);
        postRepository.delete(post);
        return postId;
    }
    public Post findPost(Long postId){
        return presentPost(postId);
    }
//    public List<Post> findPostPaging(){
//
//    }

    private Post presentPost(Long postId){
        Optional<Post> optionalPost = postRepository.findById(postId);
        return optionalPost.orElseThrow(()->new IllegalArgumentException("post 없음"));
       // return optionalPost.orElse(null);
    }
    //public List<>

}
