package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserMemRepository {

    private final Map<String, User> users = new HashMap<>();

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean save(User user) {
        String username = user.getUsername();
        if (users.containsKey(username)) {
            return false;
        }
        users.put(username, user);
        return true;
    }
}
