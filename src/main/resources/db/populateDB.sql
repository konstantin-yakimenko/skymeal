DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- password
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '$2a$10$Sh0ZD2NFrzRRJJEKEWn8l.92ROEuzlVyzB9SV1AM8fdluPR0aC1ni');

-- admin
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', '$2a$10$WejOLxVuXRpOgr4IlzQJ.eT4UcukNqHlAiOVZj1P/nmc8WbpMkiju');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO planes (name, type, seat_econom, seat_business) VALUES
  ('VQ-BQW', 'A319-111', 144, 0),
  ('VP-BTU', 'A319-114', 144, 0),
  ('VP-BTV', 'A319-114', 144, 0),
  ('VP-BTW', 'A319-114', 144, 0),
  ('VP-BTN', 'A319-114', 144, 0),
  ('VP-BTP', 'A319-114', 144, 0),
  ('VP-BTS', 'A319-114', 144, 0),
  ('VP-BHG', 'A319-114', 144, 0),
  ('VP-BHJ', 'A319-114', 144, 0),
  ('VP-BHL', 'A319-114', 144, 0),
  ('VP-BHV', 'A319-114', 144, 0),
  ('VP-BHQ', 'A319-114', 144, 0),
  ('VP-BHP', 'A319-114', 144, 0),
  ('VP-BHK', 'A319-114', 144, 0),
  ('VP-BHI', 'A319-114', 144, 0),
  ('VP-BHF', 'A319-114', 144, 0),
  ('VP-BTX', 'A319-114', 144, 0),
  ('VP-BTQ', 'A319-114', 144, 0),
  ('VP-BTT', 'A319-114', 144, 0),
  ('VQ-BRG', 'A320-214', 150, 8),
  ('VQ-BPL', 'A320-214', 150, 8),
  ('VQ-BOA', 'A320-214', 150, 8),
  ('VP-BOJ', 'A320-214', 150, 8),
  ('VQ-BPN', 'A320-214', 150, 8),
  ('VP-BOG', 'A320-214', 150, 8),
  ('VQ-BRD', 'A320-214', 150, 8),
  ('VQ-BRC', 'A320-214', 150, 8),
  ('VQ-BES', 'A320-214', 150, 8),
  ('VQ-BET', 'A320-214', 150, 8),
  ('VP-BCZ', 'A320-214', 150, 8),
  ('VP-BCP', 'A320-214', 150, 8),
  ('VP-BCS', 'A320-214', 150, 8),
  ('VQ-BDE', 'A320-214', 150, 8),
  ('VQ-BDF', 'A320-214', 150, 8),
  ('VP-BDT', 'A320-214', 150, 8),
  ('VP-BOL', 'A320-214', 150, 8),
  ('VP-BOM', 'A320-214', 150, 8),
  ('VQ-BQH', 'A321-211', 189, 8),
  ('VQ-BQK', 'A321-211', 189, 8),
  ('VQ-BQI', 'A321-211', 189, 8),
  ('VQ-BQJ', 'A321-211', 189, 8),
  ('VP-BPC', 'A321-211', 190, 8),
  ('VP-BPO', 'A321-211', 190, 8),
  ('VP-BVH', 'B767-300ER', 222, 18),
  ('VQ-BBI', 'B767-300ER', 240, 12),
  ('VP-BQF', 'B737-83N', 166, 8),
  ('VP-BND', 'B737-83N', 168, 8),
  ('VP-BQD', 'B737-83N', 166, 8),
  ('VP-BNG', 'B737-83N', 168, 8),
  ('VP-BUG', 'B737-86J', 168, 8),
  ('VQ-BVM', 'B737-8GJ', 168, 8),
  ('VQ-BVK', 'B737-8GJ', 168, 8),
  ('VQ-BVL', 'B737-8GJ', 168, 8),
  ('VP-BUL', 'B737-8LP', 168, 8),
  ('VQ-BRR', 'B737-8LP', 168, 8),
  ('VQ-BRK', 'B737-8LP', 168, 8),
  ('VQ-BRP', 'B737-8LP', 168, 8),
  ('VQ-BRQ', 'B737-8LP', 168, 8),
  ('VQ-BMG', 'B737-8LP', 168, 8),
  ('VP-BDF', 'B737-8Q8', 168, 8),
  ('VP-BDH', 'B737-8Q8', 168, 8),
  ('VP-BDG', 'B737-8Q8', 168, 8),
  ('VQ-BKV', 'B737-8ZS', 168, 8),
  ('VQ-BKW', 'B737-8ZS', 168, 8);
