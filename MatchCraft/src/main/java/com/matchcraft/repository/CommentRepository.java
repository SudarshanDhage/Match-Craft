package com.matchcraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matchcraft.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
