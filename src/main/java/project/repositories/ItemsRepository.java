package project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.models.Item;
import project.models.Person;

import java.util.List;

//62 Кастомные запросы в Spring Data JPA
@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByItemName(String itemName);
    List<Item> findByOwner(Person person);
}

//Примечания
/**
 List<Item> findByItemName(String itemName); -

 List<Item> findByOwner (Person person); - товары по владельцу
 это тоже самое, что и person.getItems()

 */