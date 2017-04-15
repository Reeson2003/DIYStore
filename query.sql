drop TABLE IF EXISTS users;
CREATE TABLE users (
  id        BIGINT AUTO_INCREMENT,
  user_name VARCHAR(256) NOT NULL,
  password VARCHAR(32) NOT NULL
);
INSERT INTO users (user_name, password) VALUES ('user1','12345');
INSERT INTO users (user_name, password) VALUES ('user2', '54321');