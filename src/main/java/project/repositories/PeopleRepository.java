package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.Person;
import java.util.List;

//62 Кастомные запросы в Spring Data JPA
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);
    List<Person> findByNameOrderByAge(String name);
    List<Person> findByEmail(String email);
    List<Person> findByNameStartingWith(String startingWith);
    List<Person> findByNameOrEmail(String name, String email);


}

/** Примечания
Примеры кастомных запросов
findByName() - поиск Person по имени


Перечень возможных запросов указан здесь:
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

 */