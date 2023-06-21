package com.board.board.post.dto;

import com.board.board.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class PostResponseDto {
    private  String title;
    private  String content;
    private  String writerId;
    private  Long viewCount;

    public PostResponseDto(Post post) {
        this.title= post.getTitle();
        this.content= post.getContent();
        this.writerId= post.getWriterId();
        this.viewCount= post.getViewCount();
    }
}
