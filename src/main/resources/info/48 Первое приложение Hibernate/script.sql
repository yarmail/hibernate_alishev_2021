/*
Скрипт для проверки работоспосбности настроек
подключения к БД
В данном случае генерация id происходит вручную,
без привлечения возможностей БД
*/
create table Person(
    id int primary key,
    name varchar(100),
    age int
);

insert into Person(id, name, age)
values (1, 'Test person', 20);

select * from Person;