DROP DATABASE messages;
CREATE DATABASE messages;

CREATE TABLE messages (
  id SERIAL PRIMARY KEY,
  messages VARCHAR(200)
);

