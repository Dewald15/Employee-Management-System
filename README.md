# Spring Boot WebFlux with MongoDB Documentation

## Overview

This project is a Spring Boot application that uses Spring WebFlux for reactive web programming and MongoDB as the database. The application manages employee data and supports CRUD operations through a RESTful API. MongoDB is containerized using Docker.

## Table of Contents

1. [Project Structure](#project-structure)
2. [Setting Up the Project](#setting-up-the-project)
4. [API Endpoints](#api-endpoints)
5. [Creating the MongoDB Docker Container](#creating-the-mongodb-docker-container)
6. [Conclusion](#conclusion)

## Project Structure

```bash
src
└── main
    ├── java
    │   └── net
    │       └── dee
    │           └── springboot
    │               ├── SpringbootWebfluxApplication.java
    │               ├── controller
    │               │   └── EmployeeController.java
    │               ├── dto
    │               │   └── EmployeeDto.java
    │               ├── entity
    │               │   └── Employee.java
    │               ├── mapper
    │               │   └── EmployeeMapper.java
    │               ├── repository
    │               │   └── EmployeeRepository.java
    │               ├── service
    │               │   ├── EmployeeService.java
    │               │   └── impl
    │               │       └── EmployeeServiceImpl.java
    └── resources
        └── application.properties
pom.xml
```

## Setting Up the Project

1. Clone the repository or download the source code.
2. Import the project into your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure you have Java and Maven installed.
4. Update the application.properties file with your MongoDB connection details if needed:
```properties
spring.application.name=springboot-webflux
spring.data.mongodb.uri=mongodb://localhost:27017/ems
```
5. Run the application using the `SpringbootWebfluxApplication` class.
6. The application will start on port 8080 by default. You can access the API at [http://localhost:8080/api/employees](http://localhost:8080/api/employees).

## API Endpoints

### Create an Employee:

- **URL**: `/api/employees`
- **Method**: `POST`
- **Request Body**:

```json
{
    "firstName": "string",
    "lastName": "string",
    "email": "string"
}
```
- **Response**: `200 OK`

### Get an Employee by ID:

- **URL**: `/api/employees/{id}`
- **Method**: `GET`
- **Response**: `200 OK`

```json
{
  "id": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string"
}
```

### Get all Employees:

- **URL**: `/api/employees`
- **Method**: `GET`
- **Response**: `200 OK`

```json
[
    {
      "id": "string",
      "firstName": "string",
      "lastName": "string",
      "email": "string"
    }
]
```

### Update an Employee:

- **URL**: `/api/employees/{id}`
- **Method**: `PUT`
- **Request Body**:

```json
{
  "firstName": "string",
  "lastName": "string",
  "email": "string"
}
```
- **Response**: `200 OK`

### Delete an Employee:

- **URL**: `/api/employees/{id}`
- **Method**: `DELETE`
- **Response**: `204 No Content`

## Creating the MongoDB Docker Container

Install the Docker desktop application.
To run MongoDB in a Docker container, follow these steps:

### Pull the MongoDB Docker image:

```bash
docker pull mongo
```
### Run the MongoDB container:
```bash
docker run -p 27017:27017 --name mongodb_container -d mongo
```

This is the Docker command to run the Mongo Docker image in a Docker container. 
This command will return the docker ID which can be used to track the Docker container.

### Verify that MongoDB is running:
``` bash
docker ps
```
You should see the MongoDB container listed and running.

### Access the MongoDB shell from the Docker container:
```bash
docker exec -it 1234 bash
```
Note that the '1234' is the first four characters of the docker ID.
Now we have access to the Docker container using `root` user.

To access the MongoDB shell, run the following command:
```bash
mongosh
```
View databases:
```bash
show dbs
```
You should see an `ems` database (after creating an employee), which is specified in `application.properties`: `spring.data.mongodb.uri=mongodb://localhost:27017/ems`

Use ems database:
```bash
use ems
```
View 'employees' collection (after creating an employee):
```bash
db.employees.find();
```

## Conclusion
You have successfully set up, built, and run a Spring Boot WebFlux application with MongoDB. You can now develop, test, and deploy this application easily across different environments.

For further enhancements and scaling, consider exploring Kubernetes for orchestration and additional cloud-native tools.