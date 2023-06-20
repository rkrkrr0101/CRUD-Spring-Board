package com.board.board.post.repository;

import com.board.board.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post,Long> {
    Page<Post> findByTitleContaining(String title, Pageable pageable);


}
