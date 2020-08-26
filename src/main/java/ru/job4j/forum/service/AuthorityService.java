package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.AuthorityDataRepository;

@Service
public class AuthorityService {

    private final AuthorityDataRepository repository;

    public AuthorityService(AuthorityDataRepository repository) {
        this.repository = repository;
    }

    public Authority findByName(String name) {
        return repository.findByName(name);
    }
}
