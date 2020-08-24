package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostMemRepository;

import java.util.Collection;

@Service
public class PostService {

    private final PostMemRepository repository;

    public PostService(PostMemRepository repository) {
        this.repository = repository;
    }

    public void save(Post post) {
        repository.save(post);
    }

    public Collection<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(Integer id) {
        return repository.findById(id);
    }
}
