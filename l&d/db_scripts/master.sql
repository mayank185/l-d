-- createuser -U postgres -s developer
-- createdb -U developer learning_and_development
-- psql -U developer -f psql.sql learning_and_development

DROP TABLE IF EXISTS credit_point;
DROP TABLE IF EXISTS assignment_quality;
DROP TABLE IF EXISTS goal_quarter;
DROP TABLE IF EXISTS goal_classification;
DROP TABLE IF EXISTS goal_level;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE goal_level
(
   id BIGSERIAL NOT NULL PRIMARY KEY,
    uuid UUID DEFAULT uuid_generate_v4() NOT NULL,
   level VARCHAR(50) NOT NULL,
    last_modified_by BIGINT NOT NULL,           --FK WRS--
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active boolean DEFAULT FALSE NOT NULL
);

CREATE TABLE goal_classification
(
   id BIGSERIAL NOT NULL PRIMARY KEY,
   uuid UUID DEFAULT uuid_generate_v4() NOT NULL,
   classification VARCHAR(50) NOT NULL,
    last_modified_by BIGINT NOT NULL,           --FK WRS--
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active boolean DEFAULT FALSE NOT NULL
);

CREATE TABLE goal_quarter
(
   id BIGSERIAL NOT NULL PRIMARY KEY,
   uuid UUID DEFAULT uuid_generate_v4() NOT NULL,
   year BIGINT NOT NULL,
   quarter VARCHAR(50) NOT NULL,
    last_modified_by BIGINT NOT NULL,           --FK WRS--
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active boolean DEFAULT FALSE NOT NULL,
    CONSTRAINT unique_quarter UNIQUE (year, quarter)
);

CREATE TABLE credit_point
(
   id BIGSERIAL NOT NULL PRIMARY KEY,
   uuid UUID DEFAULT uuid_generate_v4() NOT NULL,
   points FLOAT NOT NULL,
    last_modified_by BIGINT NOT NULL,           --FK WRS--
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active boolean DEFAULT FALSE NOT NULL
);

CREATE TABLE assignment_quality
(
   id BIGSERIAL NOT NULL PRIMARY KEY,
   uuid UUID DEFAULT uuid_generate_v4() NOT NULL,
   quality VARCHAR(50) NOT NULL,
    last_modified_by BIGINT NOT NULL,           --FK WRS--
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    is_active boolean DEFAULT FALSE NOT NULL
);




