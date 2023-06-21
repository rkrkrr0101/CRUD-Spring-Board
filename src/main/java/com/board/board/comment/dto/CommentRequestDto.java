package com.board.board.comment.dto;

import com.board.board.comment.Comment;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommentRequestDto {
    private final String content;
    private final String writerId;


    public CommentRequestDto(String content, String writerId) {
        this.content = content;
        this.writerId = writerId;

    }
    public CommentRequestDto(Comment comment) {
        this.content = comment.getContent();
        this.writerId = comment.getWriterId();
    }
    public Comment DtoToComment(){
        return new Comment(content,writerId);
    }

}
