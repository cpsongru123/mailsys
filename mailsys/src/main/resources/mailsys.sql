create database if not exists mailsys default charset utf8;
use mailsys;
create table mail
(
	id int auto_increment
		primary key,
	mail_acc varchar(20) not null,
	mail_auth varchar(20) not null,
	username varchar(20) not null,
	mail_host_name varchar(20) not null
)
;

create index fuck_t_mail_host_host_name_fk
	on mail (mail_host_name)
;

create index fuck_t_user_username_fk
	on mail (username)
;

create table mail_host
(
	id int auto_increment
		primary key,
	host_name varchar(20) not null,
	smtp_host varchar(20) null,
	smtp_host_port varchar(5) not null,
	pop3_host varchar(20) not null,
	pop3_host_port varchar(5) not null,
	constraint t_mail_host_host_name_uindex
		unique (host_name)
)
;

alter table mail
	add constraint fuck_t_mail_host_host_name_fk
		foreign key (mail_host_name) references mail_host (host_name)
;

create table user
(
	id int auto_increment
		primary key,
	username varchar(20) not null,
	nickname varchar(20) not null,
	password varchar(20) not null,
	user_pic varchar(50) null,
	user_info varchar(100) null,
	constraint t_user_username_uindex
		unique (username)
)
;

alter table mail
	add constraint fuck_t_user_username_fk
		foreign key (username) references user (username)
;

