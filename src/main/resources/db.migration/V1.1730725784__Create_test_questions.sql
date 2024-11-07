CREATE TABLE IF NOT EXISTS  questionary (
    id BIGSERIAL PRIMARY KEY,
    language TEXT,
    name TEXT,
    questions jsonb NOT NULL
);