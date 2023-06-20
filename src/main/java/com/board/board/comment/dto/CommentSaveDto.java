package com.board.board.comment.dto;

import com.board.board.comment.Comment;
import com.board.board.post.Post;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class CommentSaveDto {
    private final String content;
    private final String writerId;
    private Post post;

    public CommentSaveDto(String content, String writerId, Post post) {
        this.content = content;
        this.writerId = writerId;
        this.post = post;
    }
    public CommentSaveDto(Comment comment) {
        this.content = comment.getContent();
        this.writerId = comment.getWriterId();
    }
    public Comment DtoToComment(){
        return new Comment(content,writerId,post);
    }

}
