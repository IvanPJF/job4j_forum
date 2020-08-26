package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostDataRepository;

import java.util.Collection;
import java.util.Objects;

@Service
public class PostService {

    private final PostDataRepository repository;

    public PostService(PostDataRepository repository) {
        this.repository = repository;
    }

    public void save(Post post) {
        repository.save(post);
    }

    public Collection<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return repository.findById(id).orElse(null);
    }
}
