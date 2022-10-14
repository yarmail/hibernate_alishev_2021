-- 62 Кастомные запросы в Spring Data JPA


create table if not exists Person(
    id int generated by default as identity primary key,
    name varchar,
    age int,
    email varchar
);

create table if not exists Item (
    id int primary key generated by default as identity,
    person_id int references Person(id) on delete set null,
    item_name varchar(100) not null
);

insert into Person(name, age, email) values
    ('Иванов Иван Иванович', 15, 'email1@mail.com'),
    ('Петров Петр Петрович', 20, 'email2@mail.com'),
    ('Филимонов Сергей Григорьевич', 25, 'email2@mail.com');

insert into Item (person_id, item_name) values
    (1, 'Airpods'),
    (1, 'Playstation'),
    (1, 'TV')