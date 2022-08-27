package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Person person = session.get(Person.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getAge());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
/** Configuration
В конфигурацию подключаем наш класс-сущность Person,
который помечен аннотацией @Entity - то есть
есть и класс и таблица

Кроме того, конфигурация автоматически
(по-умолчанию, если мы специально не указываем?)
подключает конфигурацию из файла
hibernate.properties папки resources

Примечание
Импорт нужен именно из
import org.hibernate.cfg.Configuration;



 */
/** SessionFactory
Пока точно не понятно, но вероятно мы к нашей фабрики сессий
подключаем нашу конфигурацию configuration
 */
/** Session
У фабрики сессий запрашиваем и включаем новую сессию
 */
/** session.beginTransaction();
здесь мы начинаем наши операции - транзакции
 */
/** session.get
В текущей сесси мы запрашиваем у БД данные по сущности Person
и получаем их в объект Person
Все преобразования из базы производятся автоматически.
В далее, для проверки выводим полученные данные в консоль
 */
/** session.getTransaction().commit()
Закрываем транзакцию методом .commit
- утверждаем транзакцию
Как я понимаю должен быть ещё метод
rollback - откатить транзакцию
*/
/** sessionFactory.close()
После выполнения всех транзакций
закрываем фабрику сессий обязательно.
Помещаем её в блок finally,
чтобы даже в случае каких-то проблем
и ошибок сессия была закрыта в любом случае
 */
/** Что дальше
Запускаем main
Видим много красных строк - это норм
и где-то в конце
Запрос Hibernate типа:
Hibernate: select p1_0.id,p1_0.age,p1_0.name from Person p1_0 where p1_0.id=?
И наш вывод имени и возраста Person
 */