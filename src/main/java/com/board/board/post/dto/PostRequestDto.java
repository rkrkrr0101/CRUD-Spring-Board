package com.board.board.post.dto;

import com.board.board.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PostRequestDto {

    private String title;
    private String content;

    private String writerId;
    private Long viewCount=0L;

    public PostRequestDto(String title, String content, String writerId) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }
    public PostRequestDto(String title, String content, String writerId, Long viewCount) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.viewCount=viewCount;
    }

    public PostRequestDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writerId = post.getWriterId();
        this.viewCount= post.getViewCount();
    }
    public Post DtoToPosts(){
        return new Post(this.title,this.content,this.writerId,this.viewCount);
    }
}
