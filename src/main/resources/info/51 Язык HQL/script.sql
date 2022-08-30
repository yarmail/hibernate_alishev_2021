/*
Скрипт для урока
51 Язык HQL
Добавляем нескольких пользователей
чтобы на них проверить запросы HQL
*/

-- зачищаем таблицу
truncate table Person;

-- добавляем несколько значений
insert into Person (name, age) values
    ('Tom', 20),
    ('Test1', 30),
    ('Mike', 35),
    ('John', 50),
    ('Katy', 18 );


-- проверяем что получилось
select * from Person;

