
\c easy_mind;



DROP TABLE IF EXISTS user_table;

CREATE TABLE user_table (
  id SERIAL PRIMARY KEY NOT NULL,
  first_name VARCHAR ( 50 ) NOT NULL,
  last_name VARCHAR ( 50 ) NOT NULL,
  password VARCHAR ( 50 ) NOT NULL,
  email VARCHAR ( 255 ) UNIQUE NOT NULL
);