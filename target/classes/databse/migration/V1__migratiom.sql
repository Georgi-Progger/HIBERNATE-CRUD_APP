CREATE TABLE skills (
  id  int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  status int(4) NOT NULL,
  PRIMARY KEY (id)
)


CREATE TABLE specialties (
  id  int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  status int(4) NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE DEVELOPER_SKILLS (
DEVELOPER_ID INT NOT NULL,
SKILL_ID INT NOT NULL,
PRIMARY KEY (DEVELOPER_ID, SKILL_ID)
);

CREATE TABLE DEVELOPERS(
   ID INT NOT NULL AUTO_INCREMENT ,
   FIRST_NAME VARCHAR(50) DEFAULT NULL,
   LAST_NAME VARCHAR(50) DEFAULT NULL,
   status int(4) NOT NULL,
   SPECIALTY INT NOT NULL,
   PRIMARY KEY(ID)
);