INSERT INTO authority (id, name) VALUES (777, 'ROLE_ADMIN');
INSERT INTO authority (id, name) VALUES (001, 'ROLE_USER');

INSERT INTO user_authority (user_id, authority_id) VALUES (2, 777);
INSERT INTO user_authority (user_id, authority_id) VALUES (9, 001);
