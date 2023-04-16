package com.matchcraft.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matchcraft.domain.Comment;
import com.matchcraft.repository.CommentRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> sortCommentsByDate(List<Comment> comments) {

        Collections.sort(comments, new Comparator<Comment>(){
            @Override
            public int compare(Comment comment1, Comment comment2) {
                return comment2.getCreatedDate().compareTo(comment1.getCreatedDate());
            }
        });

        return comments;
    }

    public Optional<Comment> findCommentById(Long id) {

        return commentRepository.findById(id);
    }

    public Comment save(Comment comment) {

        return commentRepository.save(comment);
    }

}
