CREATE TABLE IF NOT EXISTS tests_answers (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP,
    answers jsonb,
    user_id DECIMAL NOT NULL,
    tests_id DECIMAL NOT NULL,
    FOREIGN KEY (user_id)
    REFERENCES user_table(id) ,
    FOREIGN KEY (tests_id)
    REFERENCES tests_questions(id)
);