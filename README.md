# 📝 JournalApp

**JournalApp** is a simple RESTful API built with **Spring Boot** and **MongoDB** that allows users to perform CRUD operations on journal entries.

## ✅ Features

- Create, Read, Update, and Delete journal entries
- MongoDB integration for data persistence
- RESTful endpoints with JSON input/output
- Clean separation of Controller, Service, and Repository layers
- Uses Lombok for boilerplate reduction




## ⚙️ Technologies Used

- Java 21
- Spring Boot 3.5.0
- Spring Web
- Spring Data MongoDB
- Maven
- Lombok

---

## 📦 API Endpoints

| Method | Endpoint                | Description                     |
|--------|-------------------------|---------------------------------|
| GET    | `/api/all-entries`      | Get all journal entries         |
| GET    | `/api/id/{id}`          | Get journal entry by ID         |
| POST   | `/api`                  | Create a new journal entry      |
| PUT    | `/api/id/{id}`          | Update existing journal entry   |
| DELETE | `/api/delete/id/{id}`   | Delete a journal entry by ID    |

---

## 🧪 Sample JSON

### Create or Update Entry

```json
{
  "title": "My Day at the Beach",
  "content": "It was sunny and relaxing!"
}


