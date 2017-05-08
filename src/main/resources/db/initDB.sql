DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS planes;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 300000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now(),
  enabled    BOOL DEFAULT TRUE
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE planes (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name          VARCHAR NOT NULL,
  type          VARCHAR NOT NULL,
  seat_econom   INTEGER DEFAULT 0 NOT NULL,
  seat_business INTEGER DEFAULT 0 NOT NULL
);
CREATE UNIQUE INDEX planes_unique_bortnumber_idx ON planes(name);

CREATE TABLE schedule (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date            TIMESTAMP DEFAULT now(),
  number          INTEGER DEFAULT 0 NOT NULL,
  region_date     TIMESTAMP DEFAULT now(),
  plan_start      TIMESTAMP DEFAULT now(),
  plan_finish     TIMESTAMP DEFAULT now(),
  airport_start   VARCHAR NOT NULL,
  airport_finish  VARCHAR NOT NULL,
  fact_start      TIMESTAMP DEFAULT now(),
  fact_finish     TIMESTAMP DEFAULT now(),
  fact_start_utc  TIMESTAMP DEFAULT now(),
  fact_finish_utc TIMESTAMP DEFAULT now(),
  airport_fact    VARCHAR NOT NULL,
  plane_id        INTEGER NOT NULL,
  pas_econom      INTEGER DEFAULT 0 NOT NULL,
  pas_business    INTEGER DEFAULT 0 NOT NULL,
  pilots          INTEGER DEFAULT 0 NOT NULL,
  strewards       INTEGER DEFAULT 0 NOT NULL,
  FOREIGN KEY (plane_id) REFERENCES planes (id) ON DELETE CASCADE
);
