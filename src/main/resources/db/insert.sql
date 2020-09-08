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
