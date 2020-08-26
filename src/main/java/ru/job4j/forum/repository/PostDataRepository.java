package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.Optional;

public interface PostDataRepository extends CrudRepository<Post, Integer> {

    @EntityGraph(Post.POST_ALL_FIELDS)
    Collection<Post> findAll();

    @EntityGraph(Post.POST_ALL_FIELDS)
    Optional<Post> findById(Integer id);
}
