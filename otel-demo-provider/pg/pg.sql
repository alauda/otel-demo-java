CREATE TABLE IF NOT EXISTS students
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(16) COLLATE pg_catalog."default" NOT NULL,
    age smallint NOT NULL,
    CONSTRAINT students_pkey PRIMARY KEY (id)
);

INSERT INTO students (name, age) VALUES ('Tom', 20);
INSERT INTO students (name, age) VALUES ('Kate', 21);
COMMIT;
