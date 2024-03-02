CREATE TABLE taskModels (
    id BIGINT NOT NULL auto_increment PRIMARY KEY,
    description varchar(255) not null,
    status varchar(255) not null,
    created datetime not null
);

CREATE TABLE entity_with_relation (
    id BIGINT NOT NULL auto_increment PRIMARY KEY,
    relatedEntityId BIGINT not null
);

CREATE TABLE projects (
    id BIGINT NOT NULL auto_increment PRIMARY KEY,
    name varchar(255) not null,
    description varchar(255) not null,
    createdDate date not null
);

CREATE TABLE users (
    id BIGINT NOT NULL auto_increment PRIMARY KEY,
    username varchar(255) not null,
    password varchar(255) not null,
    email varchar(255) not null,
    role varchar(255) not null
);

CREATE TABLE users_projects (
    projectId BIGINT NOT NULL,
    userId BIGINT NOT NULL
);