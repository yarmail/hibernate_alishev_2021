package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.models.Person;
import project.repositories.PeopleRepository;
import java.util.List;

// 61 Spring Data JPA
@Service
@Transactional (readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
}

//Примечания
/**
В папке services создаем новый сервис PeopleService
Помечаем аннотацией @Service. Здесь должна лежать вся
бизнес логика Также этот класс берет на себя работу с транзакциями
@Transactional (readOnly = true)

Если над классом стоит такая транзакция, то все методы
её выполняют. Если над методом стоит аннотация @Transactional
(без readonly)  то можно ещё и записывать. Местная аннотация
важнее общеклассовой

Внедряем репозиторий и пользуемся его методами.
Реализуем стандартные методы

findAll() - вывести список всех
работает общеклассовая аннотация @Transactional (readOnly = true)

findOne(int id) - найти по id (возвращает Optional)
работает общеклассовая аннотация @Transactional (readOnly = true)

save() - сохраняет данные нового человека
работает @Transactional местный без readOnly
Также этот метод используется для update()

update() - обовление данных человека
метод save используется для update()
он видит, что передается человек с id,
который уже есть в таблице и обновит
данные у существующего человека
для этого мы используем в методе
updatedPerson.setId(id);
Мы могли бы в скрытой форме с формы передавать и id
тогда не нужно было бы делать setId

delete() - удалить пользователя
 */