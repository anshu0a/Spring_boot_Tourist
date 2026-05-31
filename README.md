# Tourist Management System

## Overview

Tourist Management System is a RESTful Spring Boot application developed to manage tourist information. The application provides APIs for creating, retrieving, updating, deleting, and filtering tourist records.

The project follows a layered architecture using Controller, Service, Repository, Entity, VO (Value Object), and Exception Handling components to ensure maintainability and scalability.

---

# Technology Stack

## Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate

## Database
- Oracle Database

## Build Tool
- Maven

## API Testing
- Postman

## Development Environment
- Eclipse / Spring Tool Suite (STS)
- IntelliJ IDEA

---

# Project Architecture

```text
Controller Layer
       ↓
Service Layer
       ↓
Repository Layer
       ↓
Oracle Database
```

### Controller Layer
Handles HTTP requests and responses.

### Service Layer
Contains business logic, validation, and data transformation.

### Repository Layer
Handles database operations using Spring Data JPA.

### Exception Layer
Handles application-specific exceptions and error messages.

---

# Features

- Add New Tourist
- Get Tourist By ID
- Get All Tourists
- Filter Tourists Using Query Parameters
- Update Tourist Details
- Delete Tourist Records
- Custom Exception Handling
- RESTful API Design

---

# Base URL

```text
http://localhost:8080/app/tourist
```

---

# API Endpoints

## 1. Get All Tourists

Retrieve all tourists or filter tourists using optional parameters.

### Endpoint

```http
GET /app/tourist
```

### Query Parameters

| Parameter | Required | Description |
|------------|----------|-------------|
| name | No | Tourist Name |
| addr | No | Tourist Address |
| fromLoc | No | Source Location |
| toLoc | No | Destination Location |

### Examples

Get All Tourists

```http
GET http://localhost:8080/app/tourist
```

Filter By Name

```http
GET http://localhost:8080/app/tourist?name=Anshu
```

Filter By Multiple Fields

```http
GET http://localhost:8080/app/tourist?name=Anshu&addr=Hyderabad
```

### Success Response

```http
200 OK
```

---

## 2. Get Tourist By ID

Retrieve a specific tourist using the tourist ID.

### Endpoint

```http
GET /app/tourist/get/{id}
```

### Example

```http
GET http://localhost:8080/app/tourist/get/1
```

### Success Response

```http
200 OK
```

### Error Response

```http
400 Bad Request
```

```text
Tourist not found
```

---

## 3. Add Tourist

Register a new tourist.

### Endpoint

```http
POST /app/tourist/add
```

### Request Body

```json
{
  "name": "Anshu",
  "addr": "Hyderabad",
  "fromLoc": "Patna",
  "toLoc": "Goa"
}
```

### Success Response

```http
200 OK
```

```text
Tourist registered successfully
```

### Error Response

```http
400 Bad Request
```

```text
Name is required
```

---

## 4. Update Tourist

Update tourist information by ID.

### Endpoint

```http
PATCH /app/tourist/update/{id}
```

### Example

```http
PATCH http://localhost:8080/app/tourist/update/1
```

### Request Body

```json
{
  "name": "Anshu Kumar",
  "addr": "Hyderabad",
  "fromLoc": "Patna",
  "toLoc": "Delhi"
}
```

### Success Response

```http
200 OK
```

```text
Tourist updated successfully
```

### Error Response

```http
400 Bad Request
```

```text
Tourist not found
```

---

## 5. Delete Tourist

Delete a tourist record using ID.

### Endpoint

```http
DELETE /app/tourist/delete/{id}
```

### Example

```http
DELETE http://localhost:8080/app/tourist/delete/1
```

### Success Response

```http
200 OK
```

```text
Tourist deleted successfully
```

### Error Response

```http
400 Bad Request
```

```text
Tourist not found
```

---

# Exception Handling

## MissingDataException

Thrown when required data is not provided during tourist registration.

### Example

```text
Name is required
```

---

## TouristNotFoundException

Thrown when a tourist record cannot be found for a specified ID.

### Example

```text
Tourist with given ID not found
```

---

# HTTP Status Codes Used

| Status Code | Description |
|-------------|-------------|
| 200 OK | Request completed successfully |
| 400 Bad Request | Invalid request, missing data, or tourist not found |

---

# Sample Project Structure

```text
src
└── main
    └── java
        └── com.an
            ├── rest
            │   └── TouristController.java
            │
            ├── svs
            │   ├── ITourtstService.java
            │   └── TouristServiceImpl.java
            │
            ├── repo
            │   └── TouristRepository.java
            │
            ├── entity
            │   └── Tourist.java
            │
            ├── vo
            │   └── Vo_Tourist.java
            │
            ├── exceptions
            │   ├── MissingDataException.java
            │   └── TouristNotFoundException.java
            │
            └── TouristManagementApplication.java
```

---

# How to Run the Application

## Clone Repository

```bash
git clone <repository-url>
```

## Navigate to Project Directory

```bash
cd TouristManagementSystem
```

## Configure Database

Update the following properties in:

```properties
src/main/resources/application.properties
```

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

## Run Application

Using Maven:

```bash
mvn spring-boot:run
```

Or

```bash
mvn clean install
java -jar target/project-name.jar
```

---

# Testing APIs

Use:

- Postman
- Thunder Client
- Swagger (Future Enhancement)

Example URL:

```text
http://localhost:8080/app/tourist
```

---

# Future Enhancements

- Global Exception Handling using @ControllerAdvice
- Swagger/OpenAPI Documentation
- Pagination and Sorting
- Authentication & Authorization
- JWT Security
- Docker Support
- Unit Testing
- Integration Testing
- Logging Framework Integration

---

# Author

Anshu Kumar

Java Developer | Spring Boot Developer