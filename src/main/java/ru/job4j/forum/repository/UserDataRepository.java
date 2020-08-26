package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

public interface UserDataRepository extends CrudRepository<User, Integer> {

    @EntityGraph(User.USER_ALL_FIELDS)
    User findByUsername(String username);
}
