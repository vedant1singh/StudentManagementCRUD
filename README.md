To Create a Student Management System performing CRUD operation three instalations are required : - 
1) JAVA Development Kit
2) MYSQL Server or Database
3) MYSQL Connector / JDBC Driver

Some additional requirements are like :-
1) Classpath setup  :- When compiling/running Java code, add the connector JAR:
   javac -cp .:/usr/share/java/mysql-connector-java.jar MyProgram.java
   java  -cp .:/usr/share/java/mysql-connector-java.jar MyProgram
2) Create a Database and user in MySQL
   CREATE DATABASE testdb;
   CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'testpass';
   GRANT ALL PRIVILEGES ON testdb.* TO 'testuser'@'localhost';
   FLUSH PRIVILEGES;
3) Create a Table named students
   CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);
