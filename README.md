# Event Management API (Spring Boot + DevOps)

## Overview

A production-style RESTful API built using Spring Boot to manage events and registrations with full CRUD operations.
This project also includes a complete DevOps workflow with CI/CD, containerization, infrastructure provisioning, and deployment automation.

---

## Features

### Application Features

* Create events
* View all events
* Update events
* Delete events
* Search events
* Register users for events
* Cancel registrations
* View attendees
* Global exception handling
* Swagger API documentation
* MySQL database integration

### DevOps Features

* Bash automation scripts
* Docker containerization
* Docker Compose multi-service setup
* Jenkins CI/CD pipeline
* Terraform AWS infrastructure provisioning
* Ansible deployment automation
* Health check monitoring
* Deployment logs

---

## Tech Stack

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven

### DevOps

* Linux
* Bash
* Docker
* Docker Compose
* Jenkins
* Terraform
* Ansible
* Amazon Web Services

---

## Project Structure

```text
event-management-system-api/
│
├── src/
├── scripts/
│   ├── setup.sh
│   ├── build.sh
│   ├── run.sh
│   ├── deploy.sh
│   └── health-check.sh
│
├── Dockerfile
├── docker-compose.yml
│
├── ansible/
│   ├── inventory.yml
│   └── playbook.yml
│
├── terraform/
│   ├── main.tf
│   ├── variables.tf
│   ├── outputs.tf
│   └── terraform.tfvars
│
├── Jenkinsfile
├── Jenkinsfile-ansible
└── README.md
```

---

## ▶ Run Locally

### Standard Run

```bash
mvnw.cmd spring-boot:run
```

### Maven Build

```bash
mvn clean package
```

---

## Docker Run

### Build Image

```bash
docker build -t event-api .
```

### Run Container

```bash
docker run -p 8080:8080 event-api
```

### Docker Compose

```bash
docker compose up -d --build
```

---

## Configuration

Copy example config:

```bash
cp src/main/resources/application-example.properties src/main/resources/application-dev.properties
```

Update DB credentials before running.

---

## API Endpoints

| Method | Endpoint               |
| ------ | ---------------------- |
| GET    | /events                |
| POST   | /events                |
| PUT    | /events/{id}           |
| DELETE | /events/{id}           |
| POST   | /registrations         |
| DELETE | /registrations/{id}    |
| GET    | /events/{id}/attendees |

---

## Swagger UI

```text
http://localhost:8080/swagger-ui.html
```

---

## Jenkins CI/CD

This project includes automated pipelines for:

* Build application
* Docker deployment
* Health checks
* Ansible deployment to EC2

Pipeline files:

```text
Jenkinsfile
Jenkinsfile-ansible
```

---

## Terraform Infrastructure

Provision AWS resources using:

```bash
cd terraform
terraform init
terraform plan
terraform apply
```

Creates:

* EC2 instance
* Security group
* Open ports for SSH / App / Jenkins

---

## Ansible Deployment

Deploy application automatically:

```bash
cd ansible
ansible-playbook -i inventory.yml playbook.yml
```

Tasks include:

* Install Docker
* Clone repository
* Start containers
* Deploy application

---

## 🩺 Health Check

```text
http://localhost:8080/actuator/health
```

---

## Future Improvements

* Kubernetes deployment
* Nginx reverse proxy
* Monitoring with Prometheus + Grafana
* HTTPS domain setup

---

## 👨‍💻 Author

Vasanthan
