package com.matchcraft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matchcraft.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
