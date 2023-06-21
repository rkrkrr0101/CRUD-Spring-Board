package com.board.board.post.dto;

import com.board.board.post.Post;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PostSaveDto {

    private String title;
    private String content;

    private String writerId;
    private Long viewCount=0L;

    public PostSaveDto(String title, String content, String writerId) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
    }
    public PostSaveDto(String title, String content, String writerId, Long viewCount) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.viewCount=viewCount;
    }

    public PostSaveDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writerId = post.getWriterId();
        this.viewCount= post.getViewCount();
    }
    public Post DtoToPosts(){
        return new Post(this.title,this.content,this.writerId,this.viewCount);
    }
}
