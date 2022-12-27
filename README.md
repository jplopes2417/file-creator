## Requirements
- JDK 17
- MYSQL
- Gradle

## About the project
Project to create files with spring batch

## How It works?
The Spring Batch application will read the transactions tables and will create a csv file with these transactions. 

## How to run?
First, run the docker-compose file with docker to create a mysql container.
After that, run the scripts in the file [Script Database - Data](https://github.com/jplopes2417/file-creator/blob/main/Script%20Database%20-%20Data.sql) which will create procedures and the tables to work with the application.