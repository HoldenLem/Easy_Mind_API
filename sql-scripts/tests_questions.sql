\c easy_mind;

CREATE TABLE tests_questions (
    id serial PRIMARY KEY,
    language varchar(3) NOT NULL,
    name varchar(50) NOT NULL,
    questions jsonb NOT NULL
);