DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;
DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE users
(
  id INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled BOOLEAN DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS ( email );

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role VARCHAR(255),
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY ( user_id ) REFERENCES USERS ( id ) ON DELETE CASCADE
);
