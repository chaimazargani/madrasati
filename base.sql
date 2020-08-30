--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-08-30 03:35:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 16499)
-- Name: act; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act (
    idactivite integer NOT NULL,
    nomactivite character varying(100),
    datedebut time(6) with time zone,
    datefin time(6) with time zone,
    idenseignant integer
);


ALTER TABLE public.act OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16397)
-- Name: classe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.classe (
    idclasse integer NOT NULL,
    nomclasse character varying(100) NOT NULL,
    nombreeleve integer NOT NULL,
    idniveau integer NOT NULL
);


ALTER TABLE public.classe OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 65575)
-- Name: color_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.color_id_seq
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999
    CACHE 1;


ALTER TABLE public.color_id_seq OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16400)
-- Name: eleve; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eleve (
    idclasse integer,
    ideleve integer NOT NULL,
    nomeleve character varying(50)
);


ALTER TABLE public.eleve OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 49194)
-- Name: elevenotedto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.elevenotedto (
    "nomNote" character varying(50),
    "valeurNote" integer
);


ALTER TABLE public.elevenotedto OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16403)
-- Name: enseignant; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enseignant (
    idenseignant integer NOT NULL
);


ALTER TABLE public.enseignant OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 24584)
-- Name: etat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.etat (
    idetat integer,
    nometat character varying(100)
);


ALTER TABLE public.etat OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 73774)
-- Name: event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event (
    allow character varying(100),
    backgroundcolor character varying(100),
    bordercolor character varying(100),
    classnames integer,
    groupid character varying(100),
    id integer NOT NULL,
    rendering character varying(100),
    textcolor character varying(100),
    title character varying(100),
    allday boolean,
    "end" timestamp without time zone,
    start timestamp without time zone,
    idclasse integer,
    nomclasse character varying(100),
    "constraint" character varying,
    durationeditable character varying,
    overlap character varying,
    url character varying,
    starteditable character varying,
    editable boolean,
    color character varying(100),
    "textColor" character varying(100)
);


ALTER TABLE public.event OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 81966)
-- Name: eventeleve; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.eventeleve (
    id integer NOT NULL,
    allday boolean,
    allow character varying(100),
    backgroundcolor character varying(100),
    bordercolor character varying(100),
    classnames integer,
    "end" timestamp without time zone,
    groupid character varying(100),
    rendering character varying(100),
    start timestamp without time zone,
    textcolor character varying(100),
    title character varying(100),
    ideleve integer,
    nomeleve character varying(100)
);


ALTER TABLE public.eventeleve OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16406)
-- Name: examen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.examen (
    idexamen integer NOT NULL,
    nomexamen character varying(50),
    coefficeint integer
);


ALTER TABLE public.examen OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16409)
-- Name: matier; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matier (
    idmatier integer NOT NULL,
    nommatier character varying(100),
    idenseignant integer,
    coefficeint integer
);


ALTER TABLE public.matier OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16412)
-- Name: matierenseignantclasse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.matierenseignantclasse (
    idmatier integer NOT NULL,
    idenseignant integer NOT NULL,
    idclasse integer NOT NULL,
    nommatier character varying,
    nomclasse character varying
);


ALTER TABLE public.matierenseignantclasse OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 32797)
-- Name: niveau; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.niveau (
    idniveau integer,
    nomniveau character(100)
);


ALTER TABLE public.niveau OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16415)
-- Name: note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.note (
    valeurnote integer,
    ideleve integer NOT NULL,
    idmatier integer NOT NULL,
    idexamen integer NOT NULL
);


ALTER TABLE public.note OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 49191)
-- Name: notedt; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.notedt (
    nomeleve character varying(50),
    notecontrole1 integer,
    notecontrole2 integer,
    noteorale integer,
    " notesynthese " integer
);


ALTER TABLE public.notedt OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 24602)
-- Name: registre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.registre (
    ideleve integer,
    idetat integer,
    datepresence timestamp without time zone
);


ALTER TABLE public.registre OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16418)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    idrole integer NOT NULL,
    " nomRole" character varying(100)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 57383)
-- Name: sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sequence OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16421)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    idutilisateur integer NOT NULL,
    nom character varying(100),
    prenom character varying(100),
    cin integer,
    numtel integer,
    datenaissance date,
    adresse character varying(100),
    emaill character varying(100),
    login character varying(100),
    motdepasse character varying(100)
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 2917 (class 0 OID 16499)
-- Dependencies: 211
-- Data for Name: act; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.act (idactivite, nomactivite, datedebut, datefin, idenseignant) FROM stdin;
1	sport	10:00:00+00	11:00:00+00	1
11	musique	09:00:00+00	10:00:00+00	1
\.


--
-- TOC entry 2908 (class 0 OID 16397)
-- Dependencies: 202
-- Data for Name: classe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.classe (idclasse, nomclasse, nombreeleve, idniveau) FROM stdin;
1	9 éme année B3	23	3
47	4VD	40	4
48	7éme année B1	25	1
45	7éme année B4	25	1
52	7éme année B5	24	1
46	7éme année B6	25	1
\.


--
-- TOC entry 2909 (class 0 OID 16400)
-- Dependencies: 203
-- Data for Name: eleve; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.eleve (idclasse, ideleve, nomeleve) FROM stdin;
1	1	Hamza
1	2	Chaima
1	3	Mariem
1	4	Zaineb
1	5	ikram
1	6	asma
1	23	sinda
\.


--
-- TOC entry 2922 (class 0 OID 49194)
-- Dependencies: 216
-- Data for Name: elevenotedto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.elevenotedto ("nomNote", "valeurNote") FROM stdin;
\.


--
-- TOC entry 2910 (class 0 OID 16403)
-- Dependencies: 204
-- Data for Name: enseignant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.enseignant (idenseignant) FROM stdin;
6
7
8
\.


--
-- TOC entry 2918 (class 0 OID 24584)
-- Dependencies: 212
-- Data for Name: etat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.etat (idetat, nometat) FROM stdin;
1	absent
3	Exclu
2	Present(e)
\.


--
-- TOC entry 2925 (class 0 OID 73774)
-- Dependencies: 219
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event (allow, backgroundcolor, bordercolor, classnames, groupid, id, rendering, textcolor, title, allday, "end", start, idclasse, nomclasse, "constraint", durationeditable, overlap, url, starteditable, editable, color, "textColor") FROM stdin;
\N	\N	\N	\N	\N	2	\N	\N	musique	f	2017-02-01 09:00:00	2017-02-01 08:00:00	48	7éme année B1	\N	\N	\N		\N	t	red	bleu
\N	\N	\N	\N	\N	1	\N	\N	peinture	f	2017-02-01 10:00:00	2017-02-01 09:00:00	48	7éme année B1	\N	\N	\N		\N	t	bleu	bleu
\N	\N	\N	\N	\N	3	\N	\N	sport	f	2017-02-01 11:00:00	2017-02-01 10:00:00	48	7éme année B1	\N	\N	\N		\N	t	red	bleu
\N	\N	\N	\N	\N	4	\N	\N	math	f	2017-03-02 13:00:00	2017-03-02 12:00:00	48	7éme année B1	\N	\N	\N		\N	t	red	bleu
\N	\N	\N	\N	\N	5	\N	\N	science	f	2020-03-01 16:00:00	2020-03-01 15:00:00	45	7éme année B4	\N	\N	\N		\N	t	yellow	red
\.


--
-- TOC entry 2926 (class 0 OID 81966)
-- Dependencies: 220
-- Data for Name: eventeleve; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.eventeleve (id, allday, allow, backgroundcolor, bordercolor, classnames, "end", groupid, rendering, start, textcolor, title, ideleve, nomeleve) FROM stdin;
1	t	abc	bleu	rouge	2	2020-03-01 09:00:00	nnn	vv	2020-03-01 08:00:00	blanc	musique	1	Hamza
2	t	abc	bleu	rouge	3	2020-03-01 10:00:00	nnn	vv	2020-03-01 09:00:00	blanc	peinture	1	Hamza
3	t	abc	bleu	rouge	5	2020-03-01 11:00:00	nnn	vv	2020-03-01 10:00:00	blanc	sport	1	Hamza
4	t	abc	bleu	rouge	4	2020-03-01 13:00:00	nnn	vv	2020-03-11 12:00:00	blanc	math	1	Hamza
5	t	abc	bleu	rouge	1	2020-03-01 13:00:00	nnn	vv	2020-03-11 12:00:00	blanc	homeWork	1	Hamza
\.


--
-- TOC entry 2911 (class 0 OID 16406)
-- Dependencies: 205
-- Data for Name: examen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.examen (idexamen, nomexamen, coefficeint) FROM stdin;
4	controle2	1
1	controle1	1
2	orale	2
\.


--
-- TOC entry 2912 (class 0 OID 16409)
-- Dependencies: 206
-- Data for Name: matier; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matier (idmatier, nommatier, idenseignant, coefficeint) FROM stdin;
4	math	8	2
3	science	7	2
53	phisique	\N	1
\.


--
-- TOC entry 2913 (class 0 OID 16412)
-- Dependencies: 207
-- Data for Name: matierenseignantclasse; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.matierenseignantclasse (idmatier, idenseignant, idclasse, nommatier, nomclasse) FROM stdin;
4	8	1	math	9 éme année B3
3	7	1	science	9 éme année B3
\.


--
-- TOC entry 2920 (class 0 OID 32797)
-- Dependencies: 214
-- Data for Name: niveau; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.niveau (idniveau, nomniveau) FROM stdin;
2	niveau 2                                                                                            
3	niveau 3                                                                                            
4	niveau 4                                                                                            
5	niveau 5                                                                                            
6	niveau 6                                                                                            
1	niveau 1                                                                                            
\.


--
-- TOC entry 2914 (class 0 OID 16415)
-- Dependencies: 208
-- Data for Name: note; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.note (valeurnote, ideleve, idmatier, idexamen) FROM stdin;
14	1	4	1
15	2	4	1
16	3	4	1
18	4	4	1
18	1	4	4
16	2	4	4
17	3	4	4
10	4	4	4
13	1	4	3
15	2	4	3
12	3	4	3
18	4	4	3
18	1	4	2
14	2	4	2
\.


--
-- TOC entry 2921 (class 0 OID 49191)
-- Dependencies: 215
-- Data for Name: notedt; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.notedt (nomeleve, notecontrole1, notecontrole2, noteorale, " notesynthese ") FROM stdin;
\.


--
-- TOC entry 2919 (class 0 OID 24602)
-- Dependencies: 213
-- Data for Name: registre; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.registre (ideleve, idetat, datepresence) FROM stdin;
1	1	2020-03-01 07:00:00
1	1	2020-03-01 09:00:00
1	3	2020-03-01 10:00:00
2	1	2020-10-19 09:00:00
2	3	2020-10-19 10:00:00
2	1	2020-10-19 11:00:00
2	1	2020-10-19 12:00:00
3	1	2020-10-19 09:00:00
4	1	2020-10-19 08:00:00
4	3	2020-10-19 09:00:00
3	2	2020-10-19 08:00:00
3	1	2020-10-20 08:00:00
1	1	2020-10-20 08:00:00
2	1	2020-10-20 08:00:00
\.


--
-- TOC entry 2915 (class 0 OID 16418)
-- Dependencies: 209
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (idrole, " nomRole") FROM stdin;
\.


--
-- TOC entry 2916 (class 0 OID 16421)
-- Dependencies: 210
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (idutilisateur, nom, prenom, cin, numtel, datenaissance, adresse, emaill, login, motdepasse) FROM stdin;
4	chaima	zargani	5499542	22095557	1994-12-06	rue medglenza	zarganichaima@gmaail.com	chaima	123456
5	mariem	bouali	5499542	22095557	1994-12-06	rue medglenza	boualimariem@gmaail.com	chaima	123456
3	salah	mejri	5499542	22095557	1994-12-06	rue medglenza	salahmejri@gmaail.com	salah	123456
6	yassin	bouali	3666555	22555888	1980-02-06	rue bacha	yassin@hotmail.fr	yassin	yassin123
7	Nesrine	touijer	5884258	22025444	1981-08-05	rue bbb	Nesrine touijer	Nesrine	nesrine123
8	mahdi	riahi	5996325	24558669	1988-08-02	rue nnn	mahdi@gmail.com	Mahdi	mahdi123
30	ali	Sofien	3	656880338	2020-06-17	\N	Zainousofi@yahoo.fr	w	\N
1	ahmed	mersni	5447889	22589664	1988-12-06	rue abc	Ahmedaa@gmail.com	ahmed	1234
2	amal	agrbi	2558596	23669887	1111-01-02	rue bcg	amal@gmail.com	amal	3214
\.


--
-- TOC entry 2932 (class 0 OID 0)
-- Dependencies: 218
-- Name: color_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.color_id_seq', 67, true);


--
-- TOC entry 2933 (class 0 OID 0)
-- Dependencies: 217
-- Name: sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence', 0, false);


--
-- TOC entry 2761 (class 2606 OID 16443)
-- Name: eleve  eleve_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eleve
    ADD CONSTRAINT " eleve_pkey" PRIMARY KEY (ideleve);


--
-- TOC entry 2777 (class 2606 OID 16503)
-- Name: act act_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act
    ADD CONSTRAINT act_pkey PRIMARY KEY (idactivite);


--
-- TOC entry 2759 (class 2606 OID 16445)
-- Name: classe classe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.classe
    ADD CONSTRAINT classe_pkey PRIMARY KEY (idclasse);


--
-- TOC entry 2763 (class 2606 OID 16441)
-- Name: enseignant enseignant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enseignant
    ADD CONSTRAINT enseignant_pkey PRIMARY KEY (idenseignant);


--
-- TOC entry 2779 (class 2606 OID 73835)
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);


--
-- TOC entry 2781 (class 2606 OID 81973)
-- Name: eventeleve eventeleve_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.eventeleve
    ADD CONSTRAINT eventeleve_pkey PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 16439)
-- Name: examen examen_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.examen
    ADD CONSTRAINT examen_pkey PRIMARY KEY (idexamen);


--
-- TOC entry 2769 (class 2606 OID 16455)
-- Name: matierenseignantclasse matier_classe_enseignant_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matierenseignantclasse
    ADD CONSTRAINT matier_classe_enseignant_pkey PRIMARY KEY (idmatier, idenseignant, idclasse);


--
-- TOC entry 2767 (class 2606 OID 16453)
-- Name: matier matier_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.matier
    ADD CONSTRAINT matier_pkey PRIMARY KEY (idmatier);


--
-- TOC entry 2771 (class 2606 OID 24608)
-- Name: note note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (ideleve, idmatier, idexamen);


--
-- TOC entry 2773 (class 2606 OID 16465)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (idrole);


--
-- TOC entry 2775 (class 2606 OID 16497)
-- Name: utilisateur utilisateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (idutilisateur);


-- Completed on 2020-08-30 03:35:12

--
-- PostgreSQL database dump complete
--

