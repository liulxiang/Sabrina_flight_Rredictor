drop database if exists xuetao;

/*==============================================================*/
/* Database: womiga                                             */
/*==============================================================*/
create database xuetao;

use xuetao;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/3/16 21:38:52                           */
/*==============================================================*/



drop table if exists Good_Comment;

drop table if exists Member;

drop table if exists category;

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   id                   int not null auto_increment,
   name                 varchar(100) not null comment '名称',
   parentId             int not null default 0 comment '父类id',
   remark               varchar(200) comment '备注',
   orderid				int(11) NOT NULL DEFAULT '0',
   statu                int not null default 0 comment '状态 0 有效 1删除 ',
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Good_Comment                                          */
/*==============================================================*/

create table Good_Comment
(
   id                   int not null auto_increment,
   member_id            int not null,
   good_id              int not null,
   content              text not null,
   statu                int not null default 0,
   create_time          timestamp not null,
   reply_member_id		int ,
   is_reply             int not null default 0,
   reply_content        text,
   reply_time          timestamp not null,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Member                                                */
/*==============================================================*/
create table Member
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   password             varchar(200) not null,
   update_time          timestamp,
   sex                  varchar(2),
   school_id            int not null,
   party_join_sum       int not null default 0 comment '参加的次数',
   photo                varchar(200),
   description          text,
   phone                varchar(20),
   points               int not null default 0,
   reputation           int not null default 0 comment '信誉',
   success_sum          int not null default 0 comment '交换成功次数',
   fail_sum             int not null default 0 comment '交换失败测试',
   party_create_sum     int not null default 0 comment '组织的次数',
   major                varchar(50) comment '专业',
   email                varchar(50) not null,
   create_time          timestamp not null,
   roleid               int not null default 0,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: auth                                                  */
/*==============================================================*/
create table auth
(
   authid               int(11) not null auto_increment,
   authcode             varchar(50) not null,
   primary key (authid)
)
ENGINE=InnoDB  DEFAULT CHARSET=utf8;



/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   roleid               int(11) not null auto_increment,
   name                 varchar(50) not null,
   statu                int(11) not null,
   primary key (roleid)
)
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: roleauth                                              */
/*==============================================================*/
create table roleauth
(
   id                   int(11) not null auto_increment,
   roleid               int(11) not null,
   authid               int(11) not null,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

