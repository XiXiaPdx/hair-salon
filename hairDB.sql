--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: macbook
--

CREATE TABLE clients (
    id integer NOT NULL,
    c_name character varying,
    client_stylist_id integer
);


ALTER TABLE clients OWNER TO macbook;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: macbook
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO macbook;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: macbook
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: macbook
--

CREATE TABLE stylists (
    id integer NOT NULL,
    s_name character varying
);


ALTER TABLE stylists OWNER TO macbook;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: macbook
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO macbook;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: macbook
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: macbook
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE users OWNER TO macbook;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: macbook
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO macbook;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: macbook
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: macbook
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: macbook
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: macbook
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: macbook
--

COPY clients (id, c_name, client_stylist_id) FROM stdin;
1	cvxvcx	-1
2	Blob	-1
4	Ramsel	-1
3	fdsfs	-1
7	Perry	5
6	Huron	7
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: macbook
--

SELECT pg_catalog.setval('clients_id_seq', 7, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: macbook
--

COPY stylists (id, s_name) FROM stdin;
5	Xia
7	Horatio
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: macbook
--

SELECT pg_catalog.setval('stylists_id_seq', 7, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: macbook
--

COPY users (id, name) FROM stdin;
1	Perry
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: macbook
--

SELECT pg_catalog.setval('users_id_seq', 1, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: macbook
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: macbook
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: macbook
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

