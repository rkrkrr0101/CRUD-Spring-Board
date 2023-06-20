package com.board.board.comment.repository;

import com.board.board.comment.Comment;
import com.board.board.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Page<Comment> findByPost(Post post, Pageable pageable);
}
