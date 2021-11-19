INSERT INTO tb_user (name, email, password) values ('bob', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) values ('ana', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) values ('ROLE_MEMBER');
INSERT INTO tb_role (authority) values ('ROLE_VISITOR');

INSERT INTO tb_user_role (user_id, role_id) values (1, 2);
INSERT INTO tb_user_role (user_id, role_id) values (2, 1);