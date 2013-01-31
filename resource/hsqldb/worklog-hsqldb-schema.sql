drop table if exists users;
drop table if exists role;
drop table if exists project;
drop table if exists project_plan;
drop table if exists schedule;

create table users 
(
   id int not null,
   user_name varchar(20) null,
   passwd varchar(20) null,
   real_name varchar(20) null,
   role int null,
   lastLogin date null,
   status int null,
   del_flg char null,
   constraint PK_USERS primary key (id)
);

create table role 
(
   id int not null,
   name varchar(20) null,
   status int null,
   del_flg char null,
   constraint PK_ROLE primary key (id)
);

create table project 
(
   id int not null,
   project_name varchar(20) null,
   project_manager int null,
   status int null,
   del_flg char null,
   constraint PK_PROJECT primary key  (id)
);


create table project_plan 
(
   id int not null,
   project  int null,
   s_time   date  null,
   e_time   date  null,
   milestone   varchar(30)  null,
   comment   varchar(100) null,
   constraint PK_PROJECT_PLAN primary key (id)
);

create table schedule 
(
   id int not null,
   name  varchar(20) null,
   comment  varchar(100) null,
   project_plan   int null,
   coder int null,
   tester   int null,
   p_s_time date  null,
   p_e_time date  null,
   a_s_time date  null,
   a_e_time date  null,
   constraint PK_SCHEDULE primary key (id)
);