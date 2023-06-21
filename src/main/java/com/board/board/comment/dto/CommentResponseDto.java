package com.board.board.comment.dto;

import com.board.board.comment.Comment;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommentResponseDto {
    private final String content;
    private final String writerId;

    public CommentResponseDto(String content, String writerId) {
        this.content = content;
        this.writerId = writerId;
    }
    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
        this.writerId = comment.getWriterId();
    }
}
