-- Database: fabricaweb

-- DROP DATABASE fabricaweb;

CREATE DATABASE fabricaweb
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
create table usuario (
	id serial not null,
    nome character VARYING(55),
    login character varying(20),
    senha character varying(32),
    constraint usuario_pkey primary key (id)
)
with (
oids = false
);
alter table usuario owner to postgres;