# Grievance Cell Online Application

## User Registration, User Login and Authorization process.

## Configure Spring Datasource, JPA, App properties
```
-Install MySql
-Create Database called "grievanceCell"
-Install Java 8 or 11
-Install IntelliJ IDEA
-Run Application From Main Application class
```

```
## Run Spring Boot application
```
mvn spring-boot:run
```

## Run following SQL insert statements
```
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO roles(name) VALUES('ROLE_EMPLOYEE');
INSERT INTO roles(name) VALUES('ROLE_USER');
```
## Technology Stack
Spring Boot
Spring Web (Rest Controller)
Spring Security
Spring Hibernate
OpenJDK 8
MySQL


## Create User API
POST: http://localhost:80821/api/signup

RequestBody 
{
    "username" : "testUser",
    "email"  : "test@gmail.com",
    "role" : ["admin"],
    "password"   : "Test@123",
    "mobileNumber" : "12345677"
}

## Login API

POST: http://localhost:8081/api/signin
Request Body
{
    "username" : "testUser",
    "password" : "Test@123"
}

## Add an issue or Complaint
POST: http://localhost:8082/api/addComplaint
Request Body
{
    "issueName" : "Jira",
    "description" : "demo ticket",
    "imageUrl : "https://en.wikipedia.org/wiki/Image#/media/File:Image_created_with_a_mobile_phone.png"
}

Header: Authorization:Bearer 

## Get All Complaint
GET: http://localhost:8081/api/getAll
