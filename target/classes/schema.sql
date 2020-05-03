DROP SCHEMA IF EXISTS public CASCADE;
CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.user_dictionary (
  id          SERIAL PRIMARY KEY,
  user_name   VARCHAR NOT NULL,
  first_name  VARCHAR NOT NULL,
  email VARCHAR NOT NULL
  );
CREATE TABLE IF NOT EXISTS public.question (
  id    SERIAL PRIMARY KEY,
  message  VARCHAR NOT NULL,
  category VARCHAR NOT NULL,
  id_student INT NOT NULL,
  CONSTRAINT "FK_id_student" FOREIGN KEY ("id_student")
          REFERENCES "user_dictionary" ("id")
 );

 CREATE TABLE IF NOT EXISTS public.answer (
    id SERIAL PRIMARY KEY,
    message VARCHAR NOT NULL,
    point INT,
    id_mentor INT NOT NULL,
    id_question INT NOT NULL,
    CONSTRAINT "FK_id_mentor" FOREIGN KEY ("id_mentor")
        REFERENCES "user_dictionary" ("id"),
    CONSTRAINT "FK_id_question" FOREIGN KEY ("id_question")
            REFERENCES "question" ("id")
 );