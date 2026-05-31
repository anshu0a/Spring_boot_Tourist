# 🌍 Tourist Management System

A robust Spring Boot REST API application for managing tourist information. The project demonstrates real-world backend development concepts such as RESTful APIs, layered architecture, exception handling, validation, and cloud deployment.

## 🚀 Live Demo

🔗 https://springboot-tourist.onrender.com/app/tourist

---

## 📖 Introduction

The Tourist Management System is a backend application built using Spring Boot that allows users to perform CRUD (Create, Read, Update, Delete) operations on tourist records.

This project is ideal for learning:

- Spring Boot
- REST API Development
- Layered Architecture
- Exception Handling
- Validation
- Maven Build System
- Cloud Deployment

---

## ✨ Features

### Tourist Management
- Add new tourists
- View all tourists
- Search tourist by ID
- Update tourist details
- Delete tourist records

### REST API Features
- RESTful endpoint design
- JSON request/response support
- Proper HTTP status codes
- Clean URL structure

### Exception Handling
- Custom exceptions
- Global exception handler
- User-friendly error responses

### Validation
- Request validation
- Input verification
- Error handling for invalid data

### Architecture
- Controller Layer
- Service Layer
- Repository Layer
- Entity Layer

### Deployment
- Maven Build Support
- Render Cloud Deployment
- Production Ready Configuration

---

## 🛠️ Technology Stack

| Technology | Purpose |
|------------|----------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring MVC | REST APIs |
| Spring Data JPA | Database Operations |
| Maven | Dependency Management |
| REST API | Communication Layer |
| Git | Version Control |
| GitHub | Source Code Hosting |
| Render | Cloud Deployment |

---

## 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com
│   │       └── tourist
│   │           ├── controller
│   │           ├── service
│   │           ├── repository
│   │           ├── entity
│   │           ├── exception
│   │           └── TouristApplication.java
│   │
│   └── resources
│       ├── application.properties
│       └── static
│
└── test
```

---

## 🏗️ Architecture

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
Database
```

---

## 🔥 API Endpoints

### Get All Tourists

```http
GET /app/tourist
```

### Get Tourist By ID

```http
GET /app/tourist/{id}
```

Example:

```http
GET /app/tourist/1
```

### Add Tourist

```http
POST /app/tourist
```

Request Body:

```json
{
  "name": "Anshu Kumar",
  "country": "India",
  "budget": 50000
}
```

### Update Tourist

```http
PUT /app/tourist/{id}
```

Request Body:

```json
{
  "name": "Anshu Kumar Gupta",
  "country": "India",
  "budget": 70000
}
```

### Delete Tourist

```http
DELETE /app/tourist/{id}
```

---

## 📦 Build Project

Clean project:

```bash
mvn clean
```

Compile project:

```bash
mvn compile
```

Package application:

```bash
mvn package
```

Build without tests:

```bash
mvn clean package -DskipTests
```

---

## ▶️ Run Locally

### Using Maven

```bash
mvn spring-boot:run
```

### Using WAR File

```bash
java -jar target/*.war
```

Application URL:

```text
http://localhost:8080
```

---

## ☁️ Deployment

The application is deployed on Render.

Production URL:

```text
https://springboot-tourist.onrender.com/app/tourist
```

---

## 🎯 Learning Concepts Covered

- Spring Boot Fundamentals
- Dependency Injection (IoC)
- REST API Development
- Request Mapping
- ResponseEntity
- Exception Handling
- Validation
- Layered Architecture
- Maven Build Lifecycle
- Cloud Deployment
- Git & GitHub Workflow

---

## 👨‍💻 Author

**Anshu Kumar Gupta**

- Java Full Stack Developer
- Spring Boot Developer
- Oracle Developer

---

## ⭐ Support

If you found this project useful, consider giving it a star ⭐ on GitHub.

---

## 📜 License

This project is licensed under the MIT License.
