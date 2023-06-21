package com.board.board.post;
import com.board.board.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//게시글번호(id),제목,내용,날짜,글쓴이,조회수
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;
    private String writerId;
    private Long viewCount;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="POST_ID")
    @BatchSize(size=20)
    private List<Comment> comments=new ArrayList<>();



    public Post(String title, String content, String writerId, Long viewCount) {
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.viewCount = viewCount;
    }

    public Long plusViewCount(){
        viewCount++;
        return viewCount;
    }
    public Long updatePost(String title, String content){
        this.title=title;
        this.content=content;
        return id;
    }
    public int addComment(Comment comment){
        this.comments.add(comment);
        return this.comments.size();
    }
}
