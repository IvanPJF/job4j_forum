package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.PostComment;
import ru.job4j.forum.repository.PostCommentDataRepository;

@Service
public class PostCommentService {

    private final PostCommentDataRepository repository;

    public PostCommentService(PostCommentDataRepository repository) {
        this.repository = repository;
    }

    public void save(PostComment postComment) {
        repository.save(postComment);
    }
}
