package com.matchcraft.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matchcraft.domain.Post;
import com.matchcraft.domain.User;
import com.matchcraft.service.HobbyService;
import com.matchcraft.service.PostService;
import com.matchcraft.service.UserService;

@RestController
@RequestMapping("/hobbies/{hobbyId}/post/api")
public class PostRESTController {

    @Autowired
    private UserService userService;

    @Autowired
    private HobbyService hobbyService;
    
    @Autowired
    private PostService postService;

    @GetMapping("/isliked/{postId}")
    public boolean islikedPost (@AuthenticationPrincipal User user, @PathVariable Long postId, @PathVariable Long hobbyId) {

        Optional<Post> postOpt = postService.findPostById(postId);
        Long userId = user.getId();
        boolean hasLiked = false;

        if(postOpt.isPresent()) {

            Post post = postOpt.get();
            Set<User> usersId = post.getUsersVoted();

            for (Iterator<User> it = usersId.iterator(); it.hasNext(); ) {

                Long id = (it.next()).getId();

                if(id.equals(userId)) {
                    hasLiked = true;
                }
            }
        }
        
        return hasLiked;
    }
}
