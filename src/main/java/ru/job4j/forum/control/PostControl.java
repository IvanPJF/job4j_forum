package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.Objects;

@Controller
public class PostControl {

    private final PostService postService;
    private final UserService userService;

    public PostControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        post.setUser(userService.findByUsername(principal.getUsername()));
        Integer id = post.getId();
        if (Objects.nonNull(id)) {
            Post oldPost = postService.findById(id);
            post.setCreated(oldPost.getCreated());
            post.setComments(oldPost.getComments());
        }
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(required = false) Integer id, Model model) {
        model.addAttribute("post", getExistPostOrEmptyPost(id));
        return "post/edit";
    }

    @GetMapping("/post")
    public String post(@RequestParam Integer id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/post";
    }

    private Post getExistPostOrEmptyPost(Integer id) {
        Post post = postService.findById(id);
        return Objects.nonNull(post) ? post
                : new Post();
    }
}
