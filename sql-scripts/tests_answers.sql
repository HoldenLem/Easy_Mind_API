\c easy_mind;

CREATE TABLE tests_answers (
    id serial PRIMARY KEY NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP,
    answers jsonb,
    user_id INT NOT NULL,
    tests_id INT NOT NULL,
    FOREIGN KEY (user_id)
    REFERENCES user_table(id) ,
    FOREIGN KEY (tests_id)
    REFERENCES tests_questions(id)
);