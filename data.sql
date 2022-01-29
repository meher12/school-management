CREATE DATABASE school;

create table if not exists persistent_logins ( 
  username varchar(100) not null, 
  series varchar(64) primary key, 
  token varchar(64) not null, 
  last_used timestamp not null
);

delete from  user_role;
delete from  roles;
delete from  users;


INSERT INTO roles (id, name) VALUES 
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ACTUATOR'),
(3, 'ROLE_USER');

INSERT INTO users (id, email, first_name, password) VALUES 
(1, 'admin@gmail.com', 'Admin', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS'),
(2, 'teacher@gmail.com', 'User', '$2a$14$3sRUboxViYWYA54q/UpbKOOoWo.D2OmrlQfB7a/Xeg0eqfv3gM7j6'),
(3, 'student@gmail.com', 'User2', '$2a$14$Qe2wWEpGGkU3MXy6zp4oYO.QjGr.5o20.M0aG.dCEkqb.tLpG2nl2');


insert into users_roles(user_id, role_id) values
(1,1),
(2,2),
(3,3);
