package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserDataRepository;

@Service
public class UserService {

    private final UserDataRepository repository;

    public UserService(UserDataRepository repository) {
        this.repository = repository;
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public void save(User user) {
        repository.save(user);
    }
}
