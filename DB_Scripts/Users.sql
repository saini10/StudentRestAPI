USE studentrepo;

CREATE TABLE users(
username VARCHAR(55) NOT NULL,
password VARCHAR(68) NOT NULL,
enabled TINYINT NOT NULL,

PRIMARY KEY(username)

);

INSERT INTO users (username, password, enabled) values 
('Shubh','{bcrypt}$2a$10$Srtxu7O5kia/b3/RmUNTduP3Q.UXmmmCic8m6e.3zTgsylv.ma4v6',1),
('Nav','{bcrypt}$2a$10$o2d4hlrerxcJsDbOXPGpAeyllNJd81gIyxDyjnCwc2lRE7NT0OWWK',1),
('Jas','{bcrypt}$2a$10$1AvW2Q7pBoIzyrJjjbf6wuqrxzw.1Rak1UAfhER2oAYgbo2m./q4y',1);


-- Password of user is username as it is plus 123 as suffix, for ex password for Shubh is Shubh123