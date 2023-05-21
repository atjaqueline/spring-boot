CREATE TABLE updates (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    affected_team VARCHAR(50) NOT NULL,
    description VARCHAR NOT NULL,
    submited_by VARCHAR(25) NOT NULL
);