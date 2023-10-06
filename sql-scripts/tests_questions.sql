\c easy_mind;

CREATE TABLE tests_questions (
    id serial PRIMARY KEY,
    language varchar(3),
    name varchar(50),
    questions jsonb
);