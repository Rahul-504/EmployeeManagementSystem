# Employee Management System

A Java application with MySQL database for managing employee records.

## Features
- Add new employees
- View all employees
- Update employee details
- Delete employees

## Requirements
- Java JDK 8+
- MySQL Server

## Setup
1. Create database: `mysql -u root -p < sql/setup.sql`
2. Compile: `javac -cp ".;lib/mysql-connector-j-x.x.xx.jar" src/*.java -d bin`
3. Run: `java -cp "bin;lib/mysql-connector-j-x.x.xx.jar" MainApp`