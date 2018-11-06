DROP TABLE IF EXISTS user_goal_evaluation;
DROP TABLE IF EXISTS user_goal_claim;
DROP TABLE IF EXISTS goal_prerequisite;
DROP TABLE IF EXISTS goal_chapter;
DROP TABLE IF EXISTS goal_member;
DROP TABLE IF EXISTS user_goal;
DROP TABLE IF EXISTS goal;
DROP TABLE IF EXISTS tech_stack;
DROP TABLE IF EXISTS user_role;

DROP TYPE IF EXISTS role_enum ;
DROP TYPE IF EXISTS tech_stack_status;
DROP TYPE IF EXISTS goal_role ;
DROP TYPE IF EXISTS goal_status ;
DROP TYPE IF EXISTS user_goal_status_enum ;
DROP TABLE IF EXISTS org_user;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

/** dummy table for user detail**/
CREATE TABLE org_user (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL,
	created_by BIGINT NOT NULL,
	last_modified_by BIGINT NOT NULL,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active boolean DEFAULT true
);

CREATE TYPE role_enum AS ENUM ('STACK_OWNER','ADMIN');

/** dummy table  for user role **/
CREATE TABLE user_role(
	id BIGSERIAL NOT NULL PRIMARY KEY,
	user_id BIGINT NOT NULL,
	role role_enum ,
	created_by BIGINT NOT NULL,
	last_modified_by BIGINT NOT NULL,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active boolean DEFAULT true,
	FOREIGN KEY(user_id) REFERENCES org_user(id) /*@ManyToMany*/
);


CREATE TYPE tech_stack_status AS ENUM
    ('Active', 'Draft', 'inActive');


/** tect_stack table  **/
CREATE TABLE tech_stack(
id BIGSERIAL NOT NULL PRIMARY KEY,
    uuid UUID NOT NULL DEFAULT uuid_generate_v4(),
    org_id BIGINT NOT NULL,
    name VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255)  NOT NULL,
    owner_id bigint NOT NULL,				--FK WRS--
	status tech_stack_status,
    created_by bigint NOT NULL,				--FK WRS--
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by bigint NOT NULL,			--FK WRS--
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
	is_active boolean DEFAULT FALSE NOT NULL
);

/* goal status enum */
CREATE TYPE goal_status AS ENUM
    ('Ready','In Review', 'Draft', 'In Active');

/* goal table */
CREATE TABLE goal
(
   id BIGSERIAL NOT NULL PRIMARY KEY,
   uuid UUID NOT NULL DEFAULT uuid_generate_v4(),
   org_id BIGINT NOT NULL,
   tech_stack_id BIGINT NOT NULL,
   goal_id VARCHAR(255) UNIQUE NOT NULL,
   version VARCHAR(50) NOT NULL,
   name VARCHAR(50) UNIQUE NOT NULL,
   description VARCHAR(255) NOT NULL,
   status goal_status NOT NULL,
   level_id BIGINT NOT NULL,
   is_deleted boolean NOT NULL,
   credit_point_id BIGINT NOT NULL,
   tags VARCHAR(255) NOT NULL,
   goal_classification_id BIGINT NOT NULL,
   activation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   inactivation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   other_prerequisite VARCHAR(255) NOT NULL,
   esimated_effort FLOAT NOT NULL,
   created_by bigint NOT NULL,				--FK WRS--
   created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   last_modified_by bigint NOT NULL,			--FK WRS--
   last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
   is_active boolean DEFAULT FALSE NOT NULL,
   course_cost double precision DEFAULT NULL,
   course_link varchar(255) DEFAULT NULL,
   FOREIGN KEY (tech_stack_id) REFERENCES tech_stack(id) /*@ManyToOne*/,
   FOREIGN KEY (level_id) REFERENCES goal_level(id) /*@ManyToOne*/,
   FOREIGN KEY (credit_point_id) REFERENCES credit_point(id) /*@ManyToOne*/,
   FOREIGN KEY (goal_classification_id) REFERENCES goal_classification(id) /*@ManyToOne*/
);

/** Goal role enum **/
CREATE TYPE goal_role AS ENUM ('COORDINATOR','EVALUATOR');

/** Goal member table**/
CREATE TABLE goal_member(
	id BIGSERIAL PRIMARY KEY,
	goal_id BIGINT NOT NULL,
	user_id BIGINT NOT NULL,	--FK WRS--
	role goal_role NOT NULL,
	created_by BIGINT NOT NULL,
	last_modified_by BIGINT NOT NULL,
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active boolean DEFAULT true,
	UNIQUE (goal_id, user_id),
	FOREIGN KEY (goal_id) REFERENCES goal(id) /*@ManyToMany(org_user, user_id)*/
);


/*  Goal prerequisite */
CREATE TABLE goal_prerequisite(
 	id BIGSERIAL NOT NULL PRIMARY KEY ,
	goal_id BIGINT NOT NULL,
	prerequisite_goal_id BIGINT NOT NULL,
	created_by BIGINT NULL ,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, /*default value*/
	last_modified_by BIGINT , 
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active BOOLEAN DEFAULT true,
	UNIQUE (goal_id, prerequisite_goal_id),
	FOREIGN KEY (goal_id) REFERENCES goal(id) /*@ManyToMany*/,
	FOREIGN KEY (prerequisite_goal_id) REFERENCES goal(id) /*@ManyToMany(goal, goal_id)*/
);


/*Goal chapter*/
CREATE TABLE goal_chapter(
 	id BIGSERIAL NOT NULL PRIMARY KEY ,
	goal_id BIGINT NOT NULL,
	name VARCHAR(255),
	credits FLOAT,
	content_link JSON,
	chapter_sequence INT,
	additional_link JSON,
	created_by BIGINT NOT NULL ,--FK WRS--
	created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	last_modified_by BIGINT NOT NULL, --FK WRS--
	last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active BOOLEAN DEFAULT true,
	FOREIGN KEY (goal_id) REFERENCES goal(id) /*@ManyToOne*/
);


CREATE TYPE user_goal_status_enum AS ENUM
   ('PendingApproval', 'InProgress', 'Claimed', 'Approved', 'Rejected');

CREATE TABLE user_goal
(
   id BIGSERIAL PRIMARY KEY,
   uuid UUID NOT NULL DEFAULT uuid_generate_v4(),
   goal_id bigint NOT NULL,
   user_id bigint NOT NULL,	--FK WRS--
   quarter_id bigint NOT NULL,
   status user_goal_status_enum NOT NULL,
   is_deleted boolean NOT NULL,
   approved_by bigint NOT NULL,	--FK WRS--
   created_by bigint NOT NULL, --FK WRS--
   creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,  /*default value */
   last_modified_by bigint, --FK WRS--
   last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT unique_entry UNIQUE (goal_id, user_id),
   FOREIGN KEY (goal_id) REFERENCES goal(id) /*@ManyToMany*/,
   FOREIGN KEY (quarter_id) REFERENCES goal_quarter(id) /*@ManyToOne*/
);

   
              
/* Goal claim table*/       

CREATE TABLE user_goal_claim
(
   id BIGSERIAL PRIMARY KEY,
   uuid UUID NOT NULL DEFAULT uuid_generate_v4(),
   user_goal_id bigint NOT NULL,
   claimed_credits double precision NOT NULL,
   chapters_completed json NOT NULL,
   assignment_link varchar(500) NOT NULL,
   time_spent_mins double precision NOT NULL,
   assignment_quality_id bigint NOT NULL,
   comment varchar(255),
   feedback varchar(255),
   created_by bigint NOT NULL, --FK WRS--
   creation_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, /*default value */
   last_modified_by bigint, --FK WRS--
   last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active boolean NOT NULL,
   CONSTRAINT unique_user_goal UNIQUE (user_goal_id),
   FOREIGN KEY (user_goal_id) REFERENCES user_goal(id) /*@OneToOne*/,
   FOREIGN KEY (assignment_quality_id) REFERENCES assignment_quality(id) /*@ManyToOne*/

);
   
              
/* user goal evaluation */  
CREATE TABLE user_goal_evaluation(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    user_goal_claimed_id bigint NOT NULL, 
    approved_credit double precision NOT NULL,
    feedback varchar(255) ,
    evaluated_by bigint NOT NULL,           --FK WRS--
    created_by bigint NOT NULL,             --FK WRS--
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_by bigint NOT NULL,            --FK WRS--
    last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	is_active boolean NOT NULL,
	 FOREIGN KEY (user_goal_claimed_id) REFERENCES user_goal_claim(id) /*@OneToOne*/
);