\echo 'Delete and recreate messages db?'
\prompt 'Return for yes or control-C to cancel > ' foo

DROP DATABASE messages;
CREATE DATABASE messages;
\connect messages

-- Execute psql commands from files
\i messages-schema.sql
\i messages-seed.sql

