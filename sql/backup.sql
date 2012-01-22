--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

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
-- Name: benutzer; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE benutzer (
    id integer NOT NULL,
    benutzername character varying(255) NOT NULL,
    password_hash character varying(255),
    password_salt character varying(255),
    aktiv boolean DEFAULT false NOT NULL,
    personal_nummer character varying(255),
    titel character varying(255),
    vorname character varying(255),
    nachname character varying(255) NOT NULL,
    ist_mitarbeiter boolean DEFAULT false NOT NULL,
    ist_verwaltung boolean DEFAULT false NOT NULL,
    ist_gast boolean DEFAULT false NOT NULL
);


ALTER TABLE public.benutzer OWNER TO postgres;

--
-- Name: benutzer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE benutzer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.benutzer_id_seq OWNER TO postgres;

--
-- Name: benutzer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE benutzer_id_seq OWNED BY benutzer.id;


--
-- Name: benutzer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('benutzer_id_seq', 1, false);


--
-- Name: bestellung; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bestellung (
    id integer NOT NULL,
    kosumationszeitpunkt timestamp without time zone NOT NULL,
    ausgabezeitpunkt timestamp without time zone,
    ausgabepreis numeric(10,2),
    storniert boolean DEFAULT false NOT NULL,
    "bestätigt" boolean DEFAULT false NOT NULL,
    benutzer_id integer NOT NULL,
    speise_id integer NOT NULL
);


ALTER TABLE public.bestellung OWNER TO postgres;

--
-- Name: bestellung_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE bestellung_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bestellung_id_seq OWNER TO postgres;

--
-- Name: bestellung_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE bestellung_id_seq OWNED BY bestellung.id;


--
-- Name: bestellung_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('bestellung_id_seq', 1, false);


--
-- Name: bild; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bild (
    id integer NOT NULL,
    data bytea NOT NULL,
    filename character varying(255) NOT NULL
);


ALTER TABLE public.bild OWNER TO postgres;

--
-- Name: bild_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE bild_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bild_id_seq OWNER TO postgres;

--
-- Name: bild_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE bild_id_seq OWNED BY bild.id;


--
-- Name: bild_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('bild_id_seq', 1, false);


--
-- Name: speise; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE speise (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    beschreibung character varying(2048),
    art character varying(255) NOT NULL,
    bild_id integer,
    im_sortiment_ab date NOT NULL,
    im_sortiment_bis date NOT NULL,
    preis numeric(10,2) NOT NULL,
    lagerstand integer DEFAULT 0 NOT NULL,
    CONSTRAINT speise_art_check CHECK (((art)::text = ANY ((ARRAY['Vorspeise'::character varying, 'Hauptspeise'::character varying, 'Nachspeise'::character varying])::text[])))
);


ALTER TABLE public.speise OWNER TO postgres;

--
-- Name: speise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE speise_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.speise_id_seq OWNER TO postgres;

--
-- Name: speise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE speise_id_seq OWNED BY speise.id;


--
-- Name: speise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('speise_id_seq', 1, false);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE benutzer ALTER COLUMN id SET DEFAULT nextval('benutzer_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE bestellung ALTER COLUMN id SET DEFAULT nextval('bestellung_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE bild ALTER COLUMN id SET DEFAULT nextval('bild_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE speise ALTER COLUMN id SET DEFAULT nextval('speise_id_seq'::regclass);


--
-- Data for Name: benutzer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY benutzer (id, benutzername, password_hash, password_salt, aktiv, personal_nummer, titel, vorname, nachname, ist_mitarbeiter, ist_verwaltung, ist_gast) FROM stdin;
\.


--
-- Data for Name: bestellung; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bestellung (id, kosumationszeitpunkt, ausgabezeitpunkt, ausgabepreis, storniert, "bestätigt", benutzer_id, speise_id) FROM stdin;
\.


--
-- Data for Name: bild; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bild (id, data, filename) FROM stdin;
\.


--
-- Data for Name: speise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY speise (id, name, beschreibung, art, bild_id, im_sortiment_ab, im_sortiment_bis, preis, lagerstand) FROM stdin;
\.


--
-- Name: benutzer_benutzername_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY benutzer
    ADD CONSTRAINT benutzer_benutzername_key UNIQUE (benutzername);


--
-- Name: benutzer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY benutzer
    ADD CONSTRAINT benutzer_pkey PRIMARY KEY (id);


--
-- Name: bestellung_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bestellung
    ADD CONSTRAINT bestellung_pkey PRIMARY KEY (id);


--
-- Name: bild_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bild
    ADD CONSTRAINT bild_pkey PRIMARY KEY (id);


--
-- Name: speise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY speise
    ADD CONSTRAINT speise_pkey PRIMARY KEY (id);


--
-- Name: benutzer_nachname_index; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX benutzer_nachname_index ON benutzer USING btree (lower((nachname)::text));


--
-- Name: benutzer_personal_nummer_index; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX benutzer_personal_nummer_index ON benutzer USING btree (lower((personal_nummer)::text));


--
-- Name: bestellung_benutzer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bestellung
    ADD CONSTRAINT bestellung_benutzer_id_fkey FOREIGN KEY (benutzer_id) REFERENCES benutzer(id);


--
-- Name: bestellung_speise_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bestellung
    ADD CONSTRAINT bestellung_speise_id_fkey FOREIGN KEY (speise_id) REFERENCES speise(id);


--
-- Name: speise_bild_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY speise
    ADD CONSTRAINT speise_bild_id_fkey FOREIGN KEY (bild_id) REFERENCES bild(id) ON DELETE SET NULL;


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

