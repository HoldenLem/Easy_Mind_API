CREATE TABLE IF NOT EXISTS result_answers (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP,
    answers jsonb,
    user_id BIGINT NOT NULL,
    tests_id BIGINT NOT NULL,
    FOREIGN KEY (user_id)
    REFERENCES user_table(id) ,
    FOREIGN KEY (tests_id)
    REFERENCES questionary(id)
);