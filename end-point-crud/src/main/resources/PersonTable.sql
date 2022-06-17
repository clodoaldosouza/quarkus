-- create table Person (id bigint not null, age integer not null, name varchar(255), primary key (id));
--
insert into person(id, name, age) values (nextval('hibernate_sequence'),'Fulano', 22);
insert into person(id, name, age) values (nextval('hibernate_sequence'), 'Beltrano', 45);
insert into person(id, name, age) values (nextval('hibernate_sequence'), 'Junior', 18);
insert into person(id ,name, age) values (nextval('hibernate_sequence'), 'Ciclano', 36);