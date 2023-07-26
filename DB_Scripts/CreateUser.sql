DROP USER if exists 'student'@'localhost';

CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';

GRANT ALL PRIVILEGES ON studentRepo.*  TO 'student'@'localhost';