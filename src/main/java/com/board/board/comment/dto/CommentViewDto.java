package com.board.board.comment.dto;

import com.board.board.comment.Comment;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CommentViewDto {
    private final String content;
    private final String writerId;

    public CommentViewDto(String content, String writerId) {
        this.content = content;
        this.writerId = writerId;
    }
    public CommentViewDto(Comment comment) {
        this.content = comment.getContent();
        this.writerId = comment.getWriterId();
    }
}
