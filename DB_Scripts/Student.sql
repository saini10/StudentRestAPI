DROP DATABASE IF EXISTS studentRepo;

CREATE DATABASE studentRepo;

USE studentRepo;

CREATE TABlE student(

id INT NOT NULL AUTO_INCREMENT,
firstName VARCHAR(25) NOT NULL,
lastName VARCHAR(25),
email VARCHAR(40) NOT NULL,

PRIMARY KEY(id),
UNIQUE(email)
);

INSERT INTO student (firstName,lastName,email) values 
('Shubhpreet','saini','sainishubhpreet@gmail.com'),
('Sanchit','sharma','sharma56@gmail.com'),
('Narendra','modi','modi@congress.com'),
('Rahul','Gandhi','rahul@bjp.com'),
('Osam','Laden','laden@taliban.com');