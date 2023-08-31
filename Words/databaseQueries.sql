-- to connect with database psql -h localhost -p 5432 -d testdb 
CREATE TABLE words (
  id SERIAL PRIMARY KEY,
  englishWord VARCHAR(200) NOT NULL,
  germanWord VARCHAR(200) NOT NULL,
  level VARCHAR(2) CHECK (level IN ('A1', 'A2', 'B1', 'B2', 'C1', 'C2'))
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    pass VARCHAR(255) NOT NULL
);

CREATE TABLE user_words (
  id SERIAL PRIMARY KEY,
  user_id INT REFERENCES users(id),
  word_id INT REFERENCES words(id),
  UNIQUE (user_id, word_id)
);

-- sample data
INSERT INTO words (englishWord, germanWord, level)
VALUES
  ('apple', 'Apfel', 'A1'),
  ('banana', 'Banane', 'A2'),
  ('car', 'Auto', 'B1'),
  ('house', 'Haus', 'B2'),
  ('computer', 'Computer', 'C1');

INSERT INTO users (name, email, pass) VALUES
  ('Alice', 'alice@example.com', 'hashed_password_1'),
  ('Bob', 'bob@example.com', 'hashed_password_2'),
  ('Charlie', 'charlie@example.com', 'hashed_password_3');

-- Alice learns words
INSERT INTO user_words (user_id, word_id) VALUES
  (1, 5), -- User 1 (Alice) learns word 5
  (1, 10), -- User 1 (Alice) learns word 10
  (1, 25); -- User 1 (Alice) learns word 25

-- Bob learns words
INSERT INTO user_words (user_id, word_id) VALUES
  (2, 8), -- User 2 (Bob) learns word 8
  (2, 15), -- User 2 (Bob) learns word 15
  (2, 30); -- User 2 (Bob) learns word 30

-- Charlie learns words
INSERT INTO user_words (user_id, word_id) VALUES
  (3, 20), -- User 3 (Charlie) learns word 20
  (3, 35), -- User 3 (Charlie) learns word 35
  (3, 40); -- User 3 (Charlie) learns word 40


CREATE TABLE questions (
  id SERIAL PRIMARY KEY,
  question TEXT NOT NULL,
  option1 TEXT NOT NULL,
  option2 TEXT NOT NULL,
  option3 TEXT NOT NULL,
  option4 TEXT NOT NULL,
  correct_answer TEXT NOT NULL,
  category VARCHAR(50) NOT NULL,
  difficulty VARCHAR(10) CHECK (difficulty IN ('easy', 'medium', 'hard'))
);

-- sample data
INSERT INTO questions (question, option1, option2, option3, option4, correct_answer, category, difficulty)
VALUES
  ('What is the capital of France?', 'Berlin', 'London', 'Paris', 'Madrid', 'Paris', 'Geography', 'easy'),
  ('Who painted the Mona Lisa?', 'Vincent van Gogh', 'Pablo Picasso', 'Leonardo da Vinci', 'Claude Monet', 'Leonardo da Vinci', 'Art', 'medium'),
  ('What is the largest planet in our solar system?', 'Earth', 'Venus', 'Jupiter', 'Mars', 'Jupiter', 'Science', 'easy'),
  ('In which year did World War II end?', '1939', '1945', '1918', '1941', '1945', 'History', 'medium'),
  ('What is the chemical symbol for water?', 'O2', 'H2O', 'CO2', 'NaCl', 'H2O', 'Science', 'easy');


CREATE TABLE quiz (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description TEXT,
);

-- Create the junction table "QuizQuestions" to establish the many-to-many relationship
CREATE TABLE quiz_questions (
  quiz_id INTEGER REFERENCES quiz(id) ON DELETE CASCADE,
  question_id INTEGER REFERENCES questions(id) ON DELETE CASCADE,
  PRIMARY KEY (quiz_id, question_id)
);