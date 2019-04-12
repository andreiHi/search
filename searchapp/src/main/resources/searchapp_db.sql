DROP DATABASE IF exists searchapp;
DROP USER IF EXISTS searchapp_user;

create USER searchapp_user with encrypted password 'mypass';
create DATABASE searchapp CHARACTER SET utf8;
grant all privileges on database searchapp to searchapp_user;


CREATE TABLE topic(
id bigint not null
		constraint message_pkey
			primary key,
name VARCHAR (80) null DEFAULT null,
description varchar (5000) null DEFAULT null,
text_field1 varchar (5000) null DEFAULT null,
text_field2 varchar (5000) null DEFAULT null,
created TIMESTAMP null default CURRENT_TIMESTAMP
)

