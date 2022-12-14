/*
Скрипт для урока
49 Сохранение сущностей в БД
Настраиваем автоматическую генерацию
id с помощью самой базы данных.
Далее уже с помощью hibernate
добавим сюда сущности в классе App
*/

-- удаляем предыдущий вариант таблицы
drop table Person;

-- создаем новый вариант пустой таблицы
create table Person(
    id int primary key generated by default as identity,
    name varchar(100),
    age int
);

-- проверяем что получилось
select * from Person;

-- ...............................................
-- ...............................................

/*
 Другой вариант - это когда генерацией объекта
 занимается специальный объект - секвенция
 */

create table Person(
    id int primary key,
    name varchar(100),
    age int
);

/*
 После создания секвенции здесь, нужно
 соответствующим образом изменить Person
 и добавить
 @GeneratedValue(strategy = GenerationType.SEQUENCE)
 и другие аннотации там
 */
create sequence person_id_seq


