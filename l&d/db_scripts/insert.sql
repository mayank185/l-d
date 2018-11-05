-- MASTER TABLES

INSERT INTO goal_level(level, last_modified_by) VALUES ('Beginner', 1);
INSERT INTO goal_level(level, last_modified_by) VALUES ('Intermediate', 1);
INSERT INTO goal_level(level, last_modified_by) VALUES ('Advanced', 1);
INSERT INTO goal_level(level, last_modified_by) VALUES ('Expert', 1);

INSERT INTO goal_classification(classification, last_modified_by) VALUES ('Conceptual', 1);
INSERT INTO goal_classification(classification, last_modified_by) VALUES ('Platform', 1);
INSERT INTO goal_classification(classification, last_modified_by) VALUES ('Certification', 1);
INSERT INTO goal_classification(classification, last_modified_by) VALUES ('Inhouse', 1);
INSERT INTO goal_classification(classification, last_modified_by) VALUES ('Online Course', 1);

INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2018, 'Q1', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2018, 'Q2', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2018, 'Q3', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2018, 'Q4', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2017, 'Q1', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2017, 'Q2', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2017, 'Q3', 1);
INSERT INTO goal_quarter(year, quarter, last_modified_by) VALUES (2017, 'Q4', 1);


INSERT INTO credit_point(points, last_modified_by) VALUES (12.5, 1);
INSERT INTO credit_point(points, last_modified_by) VALUES (25, 1);
INSERT INTO credit_point(points, last_modified_by) VALUES (50, 1);

INSERT INTO assignment_quality(quality, last_modified_by) VALUES ('Normal', 1);
INSERT INTO assignment_quality(quality, last_modified_by) VALUES ('Not Challenging', 1);
INSERT INTO assignment_quality(quality, last_modified_by) VALUES ('Not Applicable', 1);
INSERT INTO assignment_quality(quality, last_modified_by) VALUES ('Challenging', 1);



-- insert queries for org_user table-----


INSERT INTO org_user(name,email,created_by,last_modified_by) values('dummy user1', 'dummy@dummy.com',1,1);
INSERT INTO org_user(name,email,created_by,last_modified_by) values('dummy user2', 'dummy2@dummy2.com',1,1);
INSERT INTO org_user(name,email,created_by,last_modified_by) values('dummy user3', 'dummy3@dummy3.com',1,1);
INSERT INTO org_user(name,email,created_by,last_modified_by) values('dummy user4', 'dummy4@dummy4.com',1,1);
INSERT INTO org_user(name,email,created_by,last_modified_by) values('dummy user5', 'dummy5@dummy.com',1,1);

--insert query for user_role table---
select * from user_role;
INSERT INTO user_role(user_id,role,created_by,last_modified_by) values(1,'ADMIN',1,1);
INSERT INTO user_role(user_id,role,created_by,last_modified_by) values(2,'STACK_OWNER',1,1);
INSERT INTO user_role(user_id,role,created_by,last_modified_by) values(3,'STACK_OWNER',1,1);
INSERT INTO user_role(user_id,created_by,last_modified_by) values(4,1,1);
INSERT INTO user_role(user_id,created_by,last_modified_by) values(5,1,1);

---insert queries for stack_owner table---
select * from tech_stack;

INSERT INTO tech_stack(org_id,name,description,owner_id,status,created_by,last_modified_by) VALUES(1,'JAVA','JAVA JAVA JAVA',1,'Active',1,1);
INSERT INTO tech_stack(org_id,name,description,owner_id,status,created_by,last_modified_by) VALUES(1,'DOT NET','DOT NET JAVA JAVA',2,'Draft',1,1);
INSERT INTO tech_stack(org_id,name,description,owner_id,status,created_by,last_modified_by) VALUES(1,'HTML','JAVA JAVA JAVA',3,'Draft',1,1);
INSERT INTO tech_stack(org_id,name,description,owner_id,status,created_by,last_modified_by) VALUES(1,'CSS','JAVA JAVA JAVA',4,'Active',1,1);
INSERT INTO tech_stack(org_id,name,description,owner_id,status,created_by,last_modified_by) VALUES(1,'SALESFORCE','JAVA JAVA JAVA',5,'Active',1,1);




--Insert query for Goal table--

INSERT INTO goal(org_id  , tech_stack_id , goal_id , version , name , description , status , level_id , is_deleted , credit_point_id , tags , goal_classification_id , other_prerequisite , esimated_effort, created_by, last_modified_by)
VALUES(1 , 1 , 'JAVA.Basics.Intermediate.1' , 1 , 'Basics' , 'Basics of java' , 'Ready' , 1 , false , 1 , 'java' ,  1 ,'java java java' , 10.2, 1, 1);

INSERT INTO goal(org_id  , tech_stack_id , goal_id , version , name , description , status , level_id , is_deleted , credit_point_id , tags , goal_classification_id , other_prerequisite , esimated_effort, created_by, last_modified_by )
VALUES(1 , 1 , 'JAVA.Advanced.Advanced.1' , 1 ,'Advanced' , 'Advanced Java' , 'In Review' , 1 , false , 1 , 'Advanced' ,  1 ,'java java java' , 12, 1, 1  );

INSERT INTO goal(org_id  , tech_stack_id , goal_id , version , name , description , status , level_id , is_deleted , credit_point_id , tags , goal_classification_id , other_prerequisite , esimated_effort, created_by, last_modified_by )
VALUES(1 , 2 , 'HTML.html.Beginner.1' , 1 , 'html' , 'Html tutorials' , 'In Review' , 1 , false , 1 , 'html',  1 , 'java java java' , 12, 1, 1  );

--Insert query for Goal member--

INSERT INTO goal_member(goal_id  , user_id , role , created_by  , last_modified_by ) VALUES( 1 , 1 , 'COORDINATOR' , 1 , 1);
INSERT INTO goal_member(goal_id  , user_id , role , created_by  , last_modified_by ) VALUES( 2 , 1 , 'EVALUATOR' , 1 , 1);
INSERT INTO goal_member(goal_id  , user_id , role , created_by  , last_modified_by ) VALUES( 3 , 2 , 'COORDINATOR' , 1 , 1);
INSERT INTO goal_member(goal_id  , user_id , role , created_by  , last_modified_by ) VALUES( 3 , 1 , 'COORDINATOR' , 1 , 1);



--Insert query for Goal prerequisite--

INSERT INTO goal_prerequisite(goal_id , prerequisite_goal_id , created_by , last_modified_by ) VALUES( 2 , 1 , 2 , 2);

--Insert query for Goal Chapter--

INSERT INTO goal_chapter(goal_id , name , credits , content_link , chapter_sequence , created_by , last_modified_by) VALUES
(1 , 'Basics Of JAVA' , 10 , '{"link": "https://www.tutorialspoint.com/java/java_basic_syntax.htm"}' , 1 , 1 , 1);

INSERT INTO goal_chapter(goal_id , name , credits , content_link , chapter_sequence , created_by , last_modified_by) VALUES
(1 , 'Datatypes in JAVA' , 5 , '{"link": "https://www.tutorialspoint.com/java/java_basic_datatypes.htm"}' , 2 , 1 , 2);

INSERT INTO goal_chapter(goal_id , name , credits , content_link , chapter_sequence , created_by , last_modified_by) VALUES
(3 , 'Basic HTML' , 5 , '{"link": "https://www.w3schools.com/html/"}' , 1 , 2 , 2);

--Insert query for User Goal--

INSERT INTO user_goal(goal_id , user_id , quarter_id , status , is_deleted , approved_by , created_by , last_modified_by) VALUES
(1 , 4 , 1 , 'Approved' , false , 3 , 1 , 1);

INSERT INTO user_goal(goal_id , user_id , quarter_id , status , is_deleted , approved_by , created_by , last_modified_by) VALUES
(2 , 3 , 1 , 'InProgress' , false , 2 , 2 , 2);

INSERT INTO user_goal(goal_id , user_id , quarter_id , status , is_deleted , approved_by , created_by , last_modified_by) VALUES
(2 , 4 , 2 , 'Rejected' , true , 2 , 2 , 2);




