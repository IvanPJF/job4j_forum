drop table if exists authority cascade;
drop table if exists users cascade;
drop table if exists post cascade;
drop table if exists post_comment cascade;
drop table if exists user_authority cascade;

create table authority
(
    id   serial,
    name varchar(50) not null unique,
    primary key (id)
);

create table users
(
    id       serial,
    username varchar(100) not null unique,
    password varchar(255) not null,
    enabled  boolean      not null default true,
    primary key (id)
);

create table user_authority
(
    user_id      integer not null,
    authority_id integer not null,
    primary key (user_id, authority_id),
    foreign key (user_id) references users (id),
    foreign key (authority_id) references authority (id)
);

create table post
(
    id          serial,
    name        varchar(255) not null,
    description text,
    created     timestamp    not null default now(),
    user_id     integer      not null,
    primary key (id),
    foreign key (user_id) references users (id)
);

create table post_comment
(
    id          serial,
    description text,
    created     timestamp not null default now(),
    post_id     integer   not null,
    user_id     integer   not null,
    primary key (id),
    foreign key (post_id) references post (id),
    foreign key (user_id) references users (id)
);

insert into authority (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password)
values ('root', '$2a$10$UpPe7xvv6mNyg1aLNZYB8uwoYz4AfQqGo8im/CiYO7RxrsY09Pc3S');
-- password = root

insert into user_authority (user_id, authority_id)
values ((select u.id from users u where u.username = 'root'),
        (select a.id from authority a where a.name = 'ROLE_ADMIN'));

insert into post (name, description, user_id)
values ('Продается автомобиль Волга', 'Отличное состояние',
        (select u.id from users u where u.username = 'root'));

insert into post_comment (description, post_id, user_id)
values ('Возможен обмен на другой автомобиль',
        (select p.id from post p where p.name = 'Продается автомобиль Волга'),
        (select u.id from users u where u.username = 'root'));

