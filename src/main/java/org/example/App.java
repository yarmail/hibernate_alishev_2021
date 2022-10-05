package org.example;

import org.example.model.Actor;
import org.example.model.Movie;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//56 Отношение many-to-many в Hibernate

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            /*
            Привяжем актеров к фильмам
             */
            /*
            Movie movie = new Movie("Pulp fiction", 1994);
            Actor actor1 = new Actor("Harvey Keitel", 81);
            Actor actor2 = new Actor("Samuel L. Jackson", 72);
            movie.setActors(new ArrayList<>(List.of(actor1, actor2)));
            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));
            session.save(movie);
            session.save(actor1);
            session.save(actor2);
            */
            /*----------------------
            Выведем список актеров фильма
            Потом попробовать вывести список фильмов актера
             */
            /*
            Movie movie = session.get(Movie.class, 1);
            System.out.println(movie.getActors());
            */
            /* -----------------------------
            Добавить фильм для существующего актера
             */
            /*
            Movie movie = new Movie("Reservoir Dogs", 1992);
            Actor actor = session.get(Actor.class, 1);
            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
            actor.getMovies().add(movie);
            session.save(movie);
             */
            /* --------------
            Удалить фильм у актера
             */
            Actor actor = session.get(Actor.class, 2);
            System.out.println(actor.getMovies());
            Movie movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(0);
            movieToRemove.getActors().remove(actor);

            session.getTransaction().commit();

        }
    }
}
// Примечания
/*
Вместо try - finally будем использовать
try with resources (try с ресурсами)

Arrays.asList - изменяемый список меняем
на List.of - неизменяемый

Каскадирование мы не настраивали поэтому сохраняем
и 1 и 2 объекты
 */