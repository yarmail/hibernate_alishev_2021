package org.example.model;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/**@Entity - сущность
Этой аннотацией помечаем те классы,
которые связаны с базой данных, например
В java - класс Person,
в БД - таблица Person
мы как бы связываем эти объекты

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
/** @GeneratedValue - генерацией id занимается БД
strategy = GenerationType.IDENTITY
Эта стратегия подразумевает автоматическую
генерацию id базой данных
В этом случае можно убрать id из конструктора

strategy = GenerationType.SEQUENCE
Генерацией ID занимается специальный объект Sequence
базы данных
В этом случае мы должны указать дополнительную аннотацию
@SequenceGenerator в которой следующие параметры
name= указываем имя в Java
sequenceName= указываем уже существующее имя в БД
(связываем)
allocationSize = размер шага приращения, должен быть
такой же ка и в БД

strategy = GenerationType.Table
Используется в том случае, если id занимается друга таблица


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
