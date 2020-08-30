PGDMP     ,    /                x        	   madrasati    12.2    12.2 6    q           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            r           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            s           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            t           1262    16393 	   madrasati    DATABASE     �   CREATE DATABASE madrasati WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';
    DROP DATABASE madrasati;
                postgres    false            �            1259    16499    act    TABLE     �   CREATE TABLE public.act (
    idactivite integer NOT NULL,
    nomactivite character varying(100),
    datedebut time(6) with time zone,
    datefin time(6) with time zone,
    idenseignant integer
);
    DROP TABLE public.act;
       public         heap    postgres    false            �            1259    16397    classe    TABLE     �   CREATE TABLE public.classe (
    idclasse integer NOT NULL,
    nomclasse character varying(100) NOT NULL,
    nombreeleve integer NOT NULL,
    idniveau integer NOT NULL
);
    DROP TABLE public.classe;
       public         heap    postgres    false            �            1259    65575    color_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.color_id_seq
    START WITH 10
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999
    CACHE 1;
 #   DROP SEQUENCE public.color_id_seq;
       public          postgres    false            �            1259    16400    eleve    TABLE     v   CREATE TABLE public.eleve (
    idclasse integer,
    ideleve integer NOT NULL,
    nomeleve character varying(50)
);
    DROP TABLE public.eleve;
       public         heap    postgres    false            �            1259    49194    elevenotedto    TABLE     d   CREATE TABLE public.elevenotedto (
    "nomNote" character varying(50),
    "valeurNote" integer
);
     DROP TABLE public.elevenotedto;
       public         heap    postgres    false            �            1259    16403 
   enseignant    TABLE     F   CREATE TABLE public.enseignant (
    idenseignant integer NOT NULL
);
    DROP TABLE public.enseignant;
       public         heap    postgres    false            �            1259    24584    etat    TABLE     U   CREATE TABLE public.etat (
    idetat integer,
    nometat character varying(100)
);
    DROP TABLE public.etat;
       public         heap    postgres    false            �            1259    73774    event    TABLE        CREATE TABLE public.event (
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
    DROP TABLE public.event;
       public         heap    postgres    false            �            1259    81966 
   eventeleve    TABLE     �  CREATE TABLE public.eventeleve (
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
    DROP TABLE public.eventeleve;
       public         heap    postgres    false            �            1259    16406    examen    TABLE     |   CREATE TABLE public.examen (
    idexamen integer NOT NULL,
    nomexamen character varying(50),
    coefficeint integer
);
    DROP TABLE public.examen;
       public         heap    postgres    false            �            1259    16409    matier    TABLE     �   CREATE TABLE public.matier (
    idmatier integer NOT NULL,
    nommatier character varying(100),
    idenseignant integer,
    coefficeint integer
);
    DROP TABLE public.matier;
       public         heap    postgres    false            �            1259    16412    matierenseignantclasse    TABLE     �   CREATE TABLE public.matierenseignantclasse (
    idmatier integer NOT NULL,
    idenseignant integer NOT NULL,
    idclasse integer NOT NULL,
    nommatier character varying,
    nomclasse character varying
);
 *   DROP TABLE public.matierenseignantclasse;
       public         heap    postgres    false            �            1259    32797    niveau    TABLE     S   CREATE TABLE public.niveau (
    idniveau integer,
    nomniveau character(100)
);
    DROP TABLE public.niveau;
       public         heap    postgres    false            �            1259    16415    note    TABLE     �   CREATE TABLE public.note (
    valeurnote integer,
    ideleve integer NOT NULL,
    idmatier integer NOT NULL,
    idexamen integer NOT NULL
);
    DROP TABLE public.note;
       public         heap    postgres    false            �            1259    49191    notedt    TABLE     �   CREATE TABLE public.notedt (
    nomeleve character varying(50),
    notecontrole1 integer,
    notecontrole2 integer,
    noteorale integer,
    " notesynthese " integer
);
    DROP TABLE public.notedt;
       public         heap    postgres    false            �            1259    24602    registre    TABLE     x   CREATE TABLE public.registre (
    ideleve integer,
    idetat integer,
    datepresence timestamp without time zone
);
    DROP TABLE public.registre;
       public         heap    postgres    false            �            1259    16418    role    TABLE     a   CREATE TABLE public.role (
    idrole integer NOT NULL,
    " nomRole" character varying(100)
);
    DROP TABLE public.role;
       public         heap    postgres    false            �            1259    57383    sequence    SEQUENCE     r   CREATE SEQUENCE public.sequence
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    MAXVALUE 1000
    CACHE 1;
    DROP SEQUENCE public.sequence;
       public          postgres    false            �            1259    16421    utilisateur    TABLE     X  CREATE TABLE public.utilisateur (
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
    DROP TABLE public.utilisateur;
       public         heap    postgres    false            e          0    16499    act 
   TABLE DATA           X   COPY public.act (idactivite, nomactivite, datedebut, datefin, idenseignant) FROM stdin;
    public          postgres    false    211   c=       \          0    16397    classe 
   TABLE DATA           L   COPY public.classe (idclasse, nomclasse, nombreeleve, idniveau) FROM stdin;
    public          postgres    false    202   �=       ]          0    16400    eleve 
   TABLE DATA           <   COPY public.eleve (idclasse, ideleve, nomeleve) FROM stdin;
    public          postgres    false    203   >       j          0    49194    elevenotedto 
   TABLE DATA           ?   COPY public.elevenotedto ("nomNote", "valeurNote") FROM stdin;
    public          postgres    false    216   i>       ^          0    16403 
   enseignant 
   TABLE DATA           2   COPY public.enseignant (idenseignant) FROM stdin;
    public          postgres    false    204   �>       f          0    24584    etat 
   TABLE DATA           /   COPY public.etat (idetat, nometat) FROM stdin;
    public          postgres    false    212   �>       m          0    73774    event 
   TABLE DATA              COPY public.event (allow, backgroundcolor, bordercolor, classnames, groupid, id, rendering, textcolor, title, allday, "end", start, idclasse, nomclasse, "constraint", durationeditable, overlap, url, starteditable, editable, color, "textColor") FROM stdin;
    public          postgres    false    219   �>       n          0    81966 
   eventeleve 
   TABLE DATA           �   COPY public.eventeleve (id, allday, allow, backgroundcolor, bordercolor, classnames, "end", groupid, rendering, start, textcolor, title, ideleve, nomeleve) FROM stdin;
    public          postgres    false    220   �?       _          0    16406    examen 
   TABLE DATA           B   COPY public.examen (idexamen, nomexamen, coefficeint) FROM stdin;
    public          postgres    false    205   b@       `          0    16409    matier 
   TABLE DATA           P   COPY public.matier (idmatier, nommatier, idenseignant, coefficeint) FROM stdin;
    public          postgres    false    206   �@       a          0    16412    matierenseignantclasse 
   TABLE DATA           h   COPY public.matierenseignantclasse (idmatier, idenseignant, idclasse, nommatier, nomclasse) FROM stdin;
    public          postgres    false    207   �@       h          0    32797    niveau 
   TABLE DATA           5   COPY public.niveau (idniveau, nomniveau) FROM stdin;
    public          postgres    false    214   (A       b          0    16415    note 
   TABLE DATA           G   COPY public.note (valeurnote, ideleve, idmatier, idexamen) FROM stdin;
    public          postgres    false    208   tA       i          0    49191    notedt 
   TABLE DATA           e   COPY public.notedt (nomeleve, notecontrole1, notecontrole2, noteorale, " notesynthese ") FROM stdin;
    public          postgres    false    215   �A       g          0    24602    registre 
   TABLE DATA           A   COPY public.registre (ideleve, idetat, datepresence) FROM stdin;
    public          postgres    false    213   �A       c          0    16418    role 
   TABLE DATA           2   COPY public.role (idrole, " nomRole") FROM stdin;
    public          postgres    false    209   UB       d          0    16421    utilisateur 
   TABLE DATA           �   COPY public.utilisateur (idutilisateur, nom, prenom, cin, numtel, datenaissance, adresse, emaill, login, motdepasse) FROM stdin;
    public          postgres    false    210   rB       u           0    0    color_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.color_id_seq', 67, true);
          public          postgres    false    218            v           0    0    sequence    SEQUENCE SET     7   SELECT pg_catalog.setval('public.sequence', 0, false);
          public          postgres    false    217            �
           2606    16443    eleve  eleve_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.eleve
    ADD CONSTRAINT " eleve_pkey" PRIMARY KEY (ideleve);
 =   ALTER TABLE ONLY public.eleve DROP CONSTRAINT " eleve_pkey";
       public            postgres    false    203            �
           2606    16503    act act_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.act
    ADD CONSTRAINT act_pkey PRIMARY KEY (idactivite);
 6   ALTER TABLE ONLY public.act DROP CONSTRAINT act_pkey;
       public            postgres    false    211            �
           2606    16445    classe classe_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.classe
    ADD CONSTRAINT classe_pkey PRIMARY KEY (idclasse);
 <   ALTER TABLE ONLY public.classe DROP CONSTRAINT classe_pkey;
       public            postgres    false    202            �
           2606    16441    enseignant enseignant_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.enseignant
    ADD CONSTRAINT enseignant_pkey PRIMARY KEY (idenseignant);
 D   ALTER TABLE ONLY public.enseignant DROP CONSTRAINT enseignant_pkey;
       public            postgres    false    204            �
           2606    73835    event event_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.event DROP CONSTRAINT event_pkey;
       public            postgres    false    219            �
           2606    81973    eventeleve eventeleve_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.eventeleve
    ADD CONSTRAINT eventeleve_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.eventeleve DROP CONSTRAINT eventeleve_pkey;
       public            postgres    false    220            �
           2606    16439    examen examen_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.examen
    ADD CONSTRAINT examen_pkey PRIMARY KEY (idexamen);
 <   ALTER TABLE ONLY public.examen DROP CONSTRAINT examen_pkey;
       public            postgres    false    205            �
           2606    16455 4   matierenseignantclasse matier_classe_enseignant_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.matierenseignantclasse
    ADD CONSTRAINT matier_classe_enseignant_pkey PRIMARY KEY (idmatier, idenseignant, idclasse);
 ^   ALTER TABLE ONLY public.matierenseignantclasse DROP CONSTRAINT matier_classe_enseignant_pkey;
       public            postgres    false    207    207    207            �
           2606    16453    matier matier_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.matier
    ADD CONSTRAINT matier_pkey PRIMARY KEY (idmatier);
 <   ALTER TABLE ONLY public.matier DROP CONSTRAINT matier_pkey;
       public            postgres    false    206            �
           2606    24608    note note_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (ideleve, idmatier, idexamen);
 8   ALTER TABLE ONLY public.note DROP CONSTRAINT note_pkey;
       public            postgres    false    208    208    208            �
           2606    16465    role role_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (idrole);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    209            �
           2606    16497    utilisateur utilisateur_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pkey PRIMARY KEY (idutilisateur);
 F   ALTER TABLE ONLY public.utilisateur DROP CONSTRAINT utilisateur_pkey;
       public            postgres    false    210            e   5   x�3�,.�/*�44�2 !mNCC$6��!gniqfai*��%���=... ���      \   U   x�3�T8�27U!1/���T'cN#cNc.sN�0NN.Ns5��F���\&�h�&qS#4qSN#�z34q3��=... ��'d      ]   L   x�3�4��H̭J�2�4�t�H��1�9}�2Ss�LΨ�̼�$ Ӕ33�($hƙXVhd�Y��������� ��      j      x������ � �      ^      x�3�2������� 	�l      f   )   x�3�LL*N�+�2�t�H�)�2�(J�h�jr��qqq � 	�      m   �   x���K�0�u{�^ 3- ��x�n�H���H���	���h2M�?�|��G"�Jwf��f�\� 8 �v{��Y8d^H��ΐEJ55���vG��䔢�ri�L�6��rXAw_�����]y�-���7~��w���m���g�o�G�Tq�W���@�ɜ34}��l�i��;����	����      n   �   x���A
�0���^�2��`=�7p�&)����I�ނ�av��>A �:P���]�j���c��B�a{D\���,YtxGj����5��yH�KY|�	��6�'=���%�d4m�i�Eϓ�!�u��YY�vi�x���6%K���3���-ї=c�	Ȗq{      _   *   x�3�L��+)��I5�4�2���<#���ĜTN#�=... j      `   5   x�3��M,���4�2�,N�L�KN�4�L�922�3KS9c�8�b���� ��      a   7   x�3��4��M,��T8�27U!1/���T'c.cNs�\qrfj^r*�t� w�u      h   <   x�3���,KM,U0R�!�2�YcLSkL`֘��S�5�4��f�M�1�YcHSkb����  �Xu      b   I   x�5���0C�s<"q
��s�&�P�I�������E�26}?v�����F`5�!���pv����Rw�      i      x������ � �      g   [   x�u��	�0C��x�.�"م6���ϑ@�"Ġ��E
E�E���e��Sw�����gY���w�'����_�?�m����b8WǿSD2:h      c      x������ � �      d   w  x���Mn�0�דSp� ��;z���b3�Ŏ�*8}�1�l� �XJ�}y�^$z�Ꭹ��AIk���9�J�4�ʺ�5Ӑ�nܱ\�?E���և1,Ć�t� `�.@;^qx�EP���L8`���;�Y5�^م�@k��4��XZk�����V�'�E���l��2��J9�]m`�䣃�x�g��p�+�}s%���f�f���vѬ���`Ca�G�cOaX�'���jm3��P>Cc�e>'��s��O3P0ț�'�"�JÄ ����n6���7�8^'�ްǼ����)��4Ϳ��cs��j-���~�=�G ��*��J��]j=PFY��!�MW͚e����㯨����~]U�/��G     