-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.0-alpha1
-- PostgreSQL version: 9.6
-- Project Site: pgmodeler.com.br
-- Model Author: ---


-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: teste_rest | type: DATABASE --
-- -- Base de teste --
-- -- DROP DATABASE IF EXISTS teste_rest;
-- CREATE DATABASE teste_rest
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'Portuguese_Brazil.1252'
-- 	LC_CTYPE = 'Portuguese_Brazil.1252'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public.seq_categoria | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.seq_categoria CASCADE;
CREATE SEQUENCE public.seq_categoria
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.seq_categoria OWNER TO postgres;
-- ddl-end --

-- object: public.categoria | type: TABLE --
-- DROP TABLE IF EXISTS public.categoria CASCADE;
CREATE TABLE public.categoria(
	categoria_id bigint NOT NULL DEFAULT nextval('public.seq_categoria'::regclass),
	descricao character varying(100),
	data_cadastro timestamp,
	data_alteracao timestamp,
	CONSTRAINT pk_categoria_id PRIMARY KEY (categoria_id),
	CONSTRAINT unique_categoria_descricao UNIQUE (descricao)

);
-- ddl-end --
ALTER TABLE public.categoria OWNER TO postgres;
-- ddl-end --

-- object: public.seq_usuario_id | type: SEQUENCE --
-- DROP SEQUENCE IF EXISTS public.seq_usuario_id CASCADE;
CREATE SEQUENCE public.seq_usuario_id
	INCREMENT BY 1
	MINVALUE 0
	MAXVALUE 2147483647
	START WITH 1
	CACHE 1
	NO CYCLE
	OWNED BY NONE;
-- ddl-end --
ALTER SEQUENCE public.seq_usuario_id OWNER TO postgres;
-- ddl-end --

-- object: public.usuario | type: TABLE --
-- DROP TABLE IF EXISTS public.usuario CASCADE;
CREATE TABLE public.usuario(
	usuario_id bigint NOT NULL DEFAULT nextval('public.seq_usuario_id'::regclass),
	nome character varying(150) NOT NULL,
	email character varying(150) NOT NULL,
	senha character varying(200),
	data_cadastro timestamp,
	data_alteracao timestamp,
	CONSTRAINT pk_usuario_id PRIMARY KEY (usuario_id),
	CONSTRAINT unique_usuario_email UNIQUE (email)

);
-- ddl-end --
ALTER TABLE public.usuario OWNER TO postgres;
-- ddl-end --


