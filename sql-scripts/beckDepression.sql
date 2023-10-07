CREATE DATABASE  easy_mind;
\c easy_mind;


CREATE TABLE beck_depression (
  id SERIAL PRIMARY KEY NOT NULL,
  created_at TIMESTAMP  NOT NULL,
  sadness SMALLINT NOT NULL,
  concerns SMALLINT NOT NULL,
  selfEsteem SMALLINT NOT NULL,
  pleasure SMALLINT NOT NULL,
  fault SMALLINT NOT NULL,
  punishment SMALLINT NOT NULL,
  selfLove SMALLINT NOT NULL,
  selfCriticism SMALLINT NOT NULL,
  suicide SMALLINT NOT NULL,
  weep SMALLINT NOT NULL,
  irritability SMALLINT NOT NULL,
  interestInPeople SMALLINT NOT NULL,
  determination SMALLINT NOT NULL,
  appearance SMALLINT NOT NULL,
  workAbility SMALLINT NOT NULL,
  sleep SMALLINT NOT NULL,
  fatigue SMALLINT NOT NULL,
  appetite SMALLINT NOT NULL,
  weight SMALLINT NOT NULL,
  heals SMALLINT NOT NULL,
  libido SMALLINT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id)
        REFERENCES user_table (id)
);