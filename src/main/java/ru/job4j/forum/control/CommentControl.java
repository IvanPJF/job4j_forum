package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.PostComment;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

@Controller
@RequestMapping("/post/comment")
public class CommentControl {

    private final UserService userService;
    private final PostService postService;

    public CommentControl(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/create")
    public String create(@RequestParam("post.id") Integer id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "post/comment/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute PostComment comment) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        comment.setUser(userService.findByUsername(principal.getUsername()));
        Post post = postService.findById(comment.getPost().getId());
        post.getComments().add(comment);
        return "redirect:/post?id=" + post.getId();
    }
}
