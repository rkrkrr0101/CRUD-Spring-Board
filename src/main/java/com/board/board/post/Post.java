package com.board.board.post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//게시글번호(id),제목,내용,날짜,글쓴이,조회수
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;
    private String writerId;
    private Long viewCount;



    public Post(String title, String content, String writerId, Long viewCount) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.viewCount = viewCount;
    }

    public Long PlusViewCount(){
        viewCount++;
        return viewCount;
    }
    public Long updatePosts(String title,String content){
        this.title=title;
        this.content=content;
        return id;
    }
}
