package org.example;

import org.example.model.Passport;
import org.example.model.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// 55 Отношение one-to-one в Hibernate
/*
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            /*
            Создаем человека и добавляем ему паспорт
             */
            /*
            Person person = new Person("Test person", 50);
            Passport passport = new Passport(12345);
            person.setPassport(passport);
            session.save(person);
            */
            /* -----------------------------------
            Прочитаем человека и получим его паспорт
            Прочитаем паспорт и получим человека
             */
            //Person person = session.get(Person.class, 2);
            //System.out.println(person.getPassport().getPassportNumber());
            /*
            Passport passport = session.get(Passport.class, 2);
            System.out.println(passport.getPerson().getName());
            */
            /* ------------------------
            Изменим номер паспорта у какого-то человека
             */
            /*
            Person person = session.get(Person.class, 2);
            person.getPassport().setPassportNumber(77777);
            */
            /* -------------------
            Удаление человека
             */
            Person person = session.get(Person.class, 2);
            session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
// Примечания
/*
После модернизации класса Person,
добавлении "двусторонней связи" в метод
setPassport() мы

 */