package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserMemRepository;

@Service
public class UserService {

    private final UserMemRepository repository;

    public UserService(UserMemRepository repository) {
        this.repository = repository;
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public boolean save(User user) {
        return repository.save(user);
    }
}
