-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler  version: 0.9.0-alpha1
-- PostgreSQL version: 9.6
-- Project Site: pgmodeler.com.br
-- Model Author: ---

-- Database creation must be done outside an multicommand file.
-- These commands were put in this file only for convenience.
-- -- object: testerest_oauth | type: DATABASE --
-- -- Banco de Controle de Client das API --
-- -- DROP DATABASE IF EXISTS testerest_oauth;
-- CREATE DATABASE testerest_oauth
-- 	ENCODING = 'UTF8'
-- 	LC_COLLATE = 'Portuguese_Brazil.1252'
-- 	LC_CTYPE = 'Portuguese_Brazil.1252'
-- 	TABLESPACE = pg_default
-- 	OWNER = postgres
-- ;
-- -- ddl-end --
-- 

-- object: public.oauth_client_details | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth_client_details CASCADE;
CREATE TABLE public.oauth_client_details(
	client_id character varying(256) NOT NULL,
	resource_ids character varying(256),
	client_secret character varying(256),
	scope character varying(256),
	authorized_grant_types character varying(256),
	web_server_redirect_uri character varying(256),
	authorities character varying(256),
	access_token_validity integer,
	refresh_token_validity integer,
	additional_information character varying(4096),
	autoapprove character varying(256),
	CONSTRAINT oauth_client_details_pkey PRIMARY KEY (client_id)

);
-- ddl-end --
ALTER TABLE public.oauth_client_details OWNER TO postgres;
-- ddl-end --

-- object: public.oauth_client_token | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth_client_token CASCADE;
CREATE TABLE public.oauth_client_token(
	token_id character varying(256),
	token bytea,
	authentication_id character varying(256),
	user_name character varying(256),
	client_id character varying(256)
);
-- ddl-end --
ALTER TABLE public.oauth_client_token OWNER TO postgres;
-- ddl-end --

-- object: public.oauth_access_token | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth_access_token CASCADE;
CREATE TABLE public.oauth_access_token(
	token_id character varying(256),
	token bytea,
	authentication_id character varying(256),
	user_name character varying(256),
	client_id character varying(256),
	authentication bytea,
	refresh_token character varying(256)
);
-- ddl-end --
ALTER TABLE public.oauth_access_token OWNER TO postgres;
-- ddl-end --

-- object: public.oauth_refresh_token | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth_refresh_token CASCADE;
CREATE TABLE public.oauth_refresh_token(
	token_id character varying(256),
	token bytea,
	authentication bytea
);
-- ddl-end --
ALTER TABLE public.oauth_refresh_token OWNER TO postgres;
-- ddl-end --

-- object: public.oauth_code | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth_code CASCADE;
CREATE TABLE public.oauth_code(
	code character varying(256),
	authentication bytea
);
-- ddl-end --
ALTER TABLE public.oauth_code OWNER TO postgres;
-- ddl-end --

-- object: public.oauth_approvals | type: TABLE --
-- DROP TABLE IF EXISTS public.oauth_approvals CASCADE;
CREATE TABLE public.oauth_approvals(
	userid character varying(256),
	clientid character varying(256),
	scope character varying(256),
	status character varying(10),
	expiresat timestamp,
	lastmodifiedat timestamp
);
-- ddl-end --
ALTER TABLE public.oauth_approvals OWNER TO postgres;
-- ddl-end --


