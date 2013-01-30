if exists table users then drop table users end
if exists table role then drop table role end
if exists table project then drop table project end
if exists table project_plan then drop table project_plan end
if exists table shedule then drop table shedule end

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users 
(
   id                   bigint                        not null,
   user_name[用户名]       varchar(20)                    null,
   passwd[密码]           varchar(20)                    null,
   real_name            varchar(20)                    null,
   role                 bigint                         null,
   lastLogin[最近登录]      datetime                       null,
   status               smallint                       null,
   del_flg              char                           null,
   constraint PK_USERS primary key ()
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role 
(
   id                   bigint                         not null,
   name                 varchar(20)                    null,
   status               smallint                       null,
   del_flg              char                           null,
   constraint PK_ROLE primary key clustered (id)
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project 
(
   id                   bigint                         not null,
   project_name         varchar(20)                    null,
   project_manager[项目经理] bigint                         null,
   status               smallint                       null,
   del_flg              char                           null,
   constraint PK_PROJECT primary key clustered (id)
);


/*==============================================================*/
/* Table: project_plan                                          */
/*==============================================================*/
create table project_plan 
(
   id                   bigint                         not null,
   project              bigint                         null,
   s_time               datetime                       null,
   e_time               datetime                       null,
   milestone            varchar(30)                    null,
   "comment"            varchar(100)                   null,
   constraint PK_PROJECT_PLAN primary key clustered (id)
);

/*==============================================================*/
/* Table: shedule                                               */
/*==============================================================*/
create table shedule 
(
   id                   bigint                         not null,
   name                 varchar(20)                    null,
   comment              varchar(100)                   null,
   project_plan         bigint                         null,
   coder                bigint                         null,
   tester               bigint                         null,
   p_s_time             datetime                       null,
   p_e_time             datetime                       null,
   a_s_time             datetime                       null,
   a_e_time             datetime                       null,
   constraint PK_SHEDULE primary key clustered (id)
);