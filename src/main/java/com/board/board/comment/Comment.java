package com.board.board.comment;

import com.board.board.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//댓글 id,글쓴이,생성날짜,수정날짜,내용,게시글 id(외래키)
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;
    private String writerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    public Comment(String content, String writerId, Post post) {
        this.content = content;
        this.writerId = writerId;
        this.post = post;
    }
}
