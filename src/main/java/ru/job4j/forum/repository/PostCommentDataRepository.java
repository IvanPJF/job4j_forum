package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.PostComment;

public interface PostCommentDataRepository extends CrudRepository<PostComment, Integer> {
}
