
insert into user(username, password, enabled, created_date) values ('admin', 'admin', true, now());
insert into user(username, password, enabled, created_date) values ('dba', 'dba', true, now());
insert into user(username, password, enabled, created_date) values ('developer', 'developer', true, now());
insert into user(username, password, enabled, created_date) values ('tester', 'tester', true, now());
insert into user(username, password, enabled, created_date) values ('deployer', 'deployer', true, now());

insert into authority(username, authority) values ('admin', 'ROLE_ADMIN');
insert into authority(username, authority) values ('dba', 'ROLE_DBA');
insert into authority(username, authority) values ('developer', 'ROLE_USER');
insert into authority(username, authority) values ('tester', 'ROLE_USER');
insert into authority(username, authority) values ('deployer', 'ROLE_USER');
