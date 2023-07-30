USE studentRepo;

CREATE TABLE authorities(
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL,

UNIQUE KEY authorities_idx_1 (username,authority),

CONSTRAINT authorities_ibfk_1 
FOREIGN KEY (username) 
REFERENCES users (username)

);

INSERT INTO authorities(username, authority) values
('Shubh','ROLE_STUDENT'),
('Shubh','ROLE_MANAGER'),
('Shubh','ROLE_ADMIN'),
('Nav','ROLE_STUDENT'),
('Nav','ROLE_MANAGER'),
('Jas','ROLE_STUDENT');
