package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person() {
    }

    public Person(int id, String name, int age) {
        this.id = id;
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
}

/**@Entity - сущность
Этой аннотацией помечаем те классы,
которые связаны с базой данных, например
В java - класс Person,
в БД - таблица Person
мы как бы связываем эти объекты

Примечания
В более старых версиях импортировалось
import javax.persistence.Entity;
в более новых
import jakarta.persistence.Entity;

Все классы с этой аннотацией должны содержать
пустой конструктор и поле id (первичного ключа)

Также каждому полю класса мы должны
сопоставить колонку из таблицы
*/
/**@Table - с какой таблицей связано
Не всегда необходимо использовать
эту аннотацию, т.к. название класса совпадает
с именем таблицы, Hibernate может автоматически
сопоставить эти названия
Данную аннотацию лучше использовать, для наглядности
и однозначной привязки таблицы к классу
 */
/** @Column - столбец для сопоставления
Каждому полю класса мы должны
сопоставить соответствующую колонку из таблицы
Если колонка называеся по-другому, например,
person_id, то здесь так и можно написать
@Column(name = "person_id")
*/
/** @Id - специально отмечаем id
Обязательная аннотация специально указывает поле Id,
первичный ключ
 */
/** Далее
Далеее обычный набор конструкторов, геттеров и сеттеров,
после чего можно переходить к пользованию
этой сущности в классе App
 */
