
insert into users(username, password, enabled, created_date) values ('admin', 'admin', true, now());
insert into users(username, password, enabled, created_date) values ('dba', 'dba', true, now());
insert into users(username, password, enabled, created_date) values ('developer', 'developer', true, now());
insert into users(username, password, enabled, created_date) values ('tester', 'tester', true, now());
insert into users(username, password, enabled, created_date) values ('deployer', 'deployer', true, now());

insert into authorities(username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities(username, authority) values ('admin', 'ROLE_DBA');
insert into authorities(username, authority) values ('dba', 'ROLE_DBA');
insert into authorities(username, authority) values ('developer', 'ROLE_USER');
insert into authorities(username, authority) values ('tester', 'ROLE_USER');
insert into authorities(username, authority) values ('deployer', 'ROLE_USER');
