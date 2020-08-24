package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import java.util.Map;
import java.util.Set;

@Controller
public class IndexControl {

    private final PostService postService;
    private final UserService userService;

    public IndexControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
        filled();
    }

    private void filled() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("$2a$10$UpPe7xvv6mNyg1aLNZYB8uwoYz4AfQqGo8im/CiYO7RxrsY09Pc3S");
        user.setEnabled(true);
        user.setAuthorities(Set.of(Authority.of("ROLE_ADMIN")));
        userService.save(user);
        postService.save(Post.of("Продаю машину Лада", "Очень", user));
        postService.save(Post.of("Продаю грузовик Зил", "Не очень", user));
        postService.save(Post.of("Продаю мотоцикл Java", "Очень очень", user));
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAllAttributes(Map.of(
                "user", SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                "posts", postService.findAll()));
        return "index";
    }
}
