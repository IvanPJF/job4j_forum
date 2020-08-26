package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Authority;

public interface AuthorityDataRepository extends CrudRepository<Authority, Integer> {

    Authority findByName(String name);
}
