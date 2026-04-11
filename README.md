#  Event Management System (Spring Boot)

##  Overview

A RESTful API built using Spring Boot to manage events and user registrations.

---

##  Features

* Create events
* Update events
* Delete events
* View all events
* Register users for events
* Cancel registrations
* View attendees

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Swagger (OpenAPI)

---

## ▶️ Run Locally

```bash
mvnw.cmd spring-boot:run
```

---

## 🔐 Configuration

Copy example config:

```bash
cp src/main/resources/application-example.properties src/main/resources/application-dev.properties
```

Update values before running.

---

## 📡 API Endpoints (Sample)

| Method | Endpoint     |
| ------ | ------------ |
| GET    | /events      |
| POST   | /events      |
| PUT    | /events/{id} |
| DELETE | /events/{id} |

---

## 📄 Swagger UI

After running the application locally:

http://localhost:8080/swagger-ui.html

---

## 👨‍💻 Author

Vasanthan
