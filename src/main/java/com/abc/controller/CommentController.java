package com.abc.controller;

import com.abc.entity.Comment;
import com.abc.entity.Post;
import com.abc.repository.CommentRepository;
import com.abc.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    @PostMapping
    public String createComment(@RequestBody Comment comment, @RequestParam long postId){
        System.out.println(100);
        System.out.println(100);

        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        commentRepository.save(comment);
        return "comment created Successfully";
    }
}