CREATE TABLE updates (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    affected_team VARCHAR(50) NOT NULL,
    description VARCHAR NOT NULL,
    submited_by VARCHAR(25) NOT NULL
);


{
    "title": "thanksgiving news",
    "affected_team":"marketing",
    "description": "As you might have expected, every single one of the big banks will be closed on Thanksgiving. You can expect smaller, local banks to be closed as well",
    "submited_by":"furgielicious"
}