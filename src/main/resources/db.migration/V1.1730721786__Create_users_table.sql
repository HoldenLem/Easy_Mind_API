CREATE TABLE IF NOT EXISTS user_table  (
  id BIGSERIAL PRIMARY KEY NOT NULL,
  first_name TEXT,
  last_name TEXT,
  password TEXT,
  email TEXT UNIQUE NOT NULL
);