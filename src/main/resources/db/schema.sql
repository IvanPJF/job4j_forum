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
