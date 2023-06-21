package com.board.board.post.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostViewDto {
    private String title;
    private String content;

    private String writerId;
    private Long viewCount=0L;
}
