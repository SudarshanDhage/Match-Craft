package com.matchcraft.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matchcraft.domain.Comment;
import com.matchcraft.domain.Hobby;
import com.matchcraft.domain.Post;
import com.matchcraft.domain.User;
import com.matchcraft.service.CommentService;
import com.matchcraft.service.PostService;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @PostMapping("/hobbies/{hobbyId}/posts/{postId}")
	public String postComment(@AuthenticationPrincipal User user, @PathVariable Long hobbyId, @PathVariable Long postId, Comment comment) {

        Optional<Post> postOpt = postService.findPostById(postId);

        comment.setUserId(user.getId());
        comment.setCreatedDate(new Date());
        comment.setPost(postOpt.get());
        Comment savedComment = commentService.save(comment);

        (postOpt.get()).getComments().add(savedComment);
        postService.save(postOpt.get());

		return "redirect:/hobbies/"+hobbyId+"/post/"+postId;
	}

} 