package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMemRepository {

    private final Map<Integer, Post> posts = new HashMap<>();
    private final AtomicInteger index = new AtomicInteger(1);

    public void save(Post post) {
        if (Objects.isNull(post.getId())) {
            post.setId(index.getAndIncrement());
        }
        posts.put(post.getId(), post);
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findById(Integer id) {
        return posts.get(id);
    }
}
