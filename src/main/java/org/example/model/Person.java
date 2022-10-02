package org.example.model;

import javax.persistence.*;
import java.util.List;

// К уроку 52
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Item> items;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
// Примечание
/*
Добавляем код для связи one-to-many
Эта сторона One

@OneToMany
private List<Item> items;
Добавляем поле список для хранения заказов данного Person
Добавляем геттеры и сеттеры

@JoinColumn нет необходимости указывать
т.к. эта информация есть в Item
mappedBy = "owner" - мы просто указываем на объект
в котором есть вся информауия о связи

 */

