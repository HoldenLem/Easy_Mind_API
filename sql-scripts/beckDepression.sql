CREATE DATABASE  easy_mind;
\c easy_mind;


--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS beck_depression;

CREATE TABLE beck_depression (
  id SERIAL PRIMARY KEY NOT NULL,
  created_at TIMESTAMP  NOT NULL,
  question_one SMALLINT NOT NULL,
  question_two SMALLINT NOT NULL,
  question_three SMALLINT NOT NULL,
  question_four SMALLINT NOT NULL,
  question_five SMALLINT NOT NULL,
  question_six SMALLINT NOT NULL,
  question_seven SMALLINT NOT NULL,
  question_eight SMALLINT NOT NULL,
  question_nine SMALLINT NOT NULL,
  question_ten SMALLINT NOT NULL,
  question_eleven SMALLINT NOT NULL,
  question_twelve SMALLINT NOT NULL,
  question_thirteen SMALLINT NOT NULL,
  question_fourteen SMALLINT NOT NULL,
  question_fifteen SMALLINT NOT NULL,
  question_sixteen SMALLINT NOT NULL,
  question_seventeen SMALLINT NOT NULL,
  question_eighteen SMALLINT NOT NULL,
  question_nineteen SMALLINT NOT NULL,
  question_twenty SMALLINT NOT NULL,
  question_twenty_one SMALLINT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY (user_id)
        REFERENCES user_table (id)
);