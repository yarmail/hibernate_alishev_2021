package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.Person;

// 61 Spring Data JPA
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}

/** Примечания
 Далее создаем репозитории в виде интерфейса в папке
 project/repositories Названия репозиториев
 как и контроллеры обрабатывают сущности,
 поэтому называется PeopleRepository.
 Наследуется от JpaRepository
 Имеет соотв. аннотацию

 extends JpaRepository<Person, Integer>
 В наследовании мы указываем модель (сущность) которую
 будет обрабатывать репозиторий и тип ID (в данном случае int)

 Автоматически включает в себя все основные методы,
 которые используются в сервисе PeopleService
 */