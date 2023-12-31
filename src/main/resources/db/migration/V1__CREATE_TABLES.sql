create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );


CREATE TABLE user (
    id bigint NOT NULL AUTO_INCREMENT,
    password varchar(64) not null,
    username varchar(64) not null unique,
    PRIMARY KEY (id)
)engine=MyISAM;

CREATE TABLE todo (
    id bigint NOT NULL AUTO_INCREMENT,
    title varchar(64) not null,
    completed BOOLEAN not null,
    PRIMARY KEY (id)
)engine=MyISAM;