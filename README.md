# 📚 Library Book Catalog REST API

This project is a **Spring Boot-based RESTful API** designed to manage a simple library catalog. It provides endpoints for adding, retrieving, updating, and deleting books, with validation and exception handling implemented.

---

## 🚀 Features

- Add a new book with validation
- View all books
- Get a book by its ID
- Delete a book
- Update the availability of a book
- Duplicate ISBN protection

---

## 📦 Techology stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Hibernate Validator
- MySQL / H2 (any JPA-compatible DB)
- Maven

---

## Project structure

<img width="447" height="852" alt="image" src="https://github.com/user-attachments/assets/d29046cd-b8bc-402e-9154-3b24704051fa" />

## How to Run the Project

1. Clone the repo
   ```bash
   git clone https://github.com/Nitish-AI/Library-API.git
   cd Library-API
   ```
2. Configure your database in application.properties

   ```bash
   spring.application.name=Library
   server.port = 8080

   #database configuration:mysql
   spring.datasource.name=test
   spring.datasource.url=jdbc:mysql://localhost:3306/library
   spring.datasource.username=root
   spring.datasource.password=Nitish@123
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   #hibernate configuration
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

3. Build and Run the application
   ```bash
   mvn spring-boot:run
   ```
4. Visit: http://localhost:8080/library/all

## 🧾 Book Model

Each book includes the following fields:

| Field       | Type    | Validation          |
| ----------- | ------- | ------------------- |
| `id`        | Integer | Auto-generated      |
| `title`     | String  | `@NotBlank`         |
| `author`    | String  | `@NotBlank`         |
| `isbn`      | String  | `@NotBlank`, unique |
| `available` | Boolean | `@NotNull`          |

---

## API Endpoints

| Method   | Endpoint                                          | Description              |
| -------- | ------------------------------------------------- | ------------------------ |
| `POST`   | `/library/add`                                    | Add a new book           |
| `GET`    | `/library/all`                                    | Get all books            |
| `GET`    | `/library/{id}`                                   | Get book by ID           |
| `DELETE` | `/library/{id}`                                   | Delete book by ID        |
| `PATCH`  | `/library/{id}/availability?available=true/false` | Update book availability |

---

## Sample JSON for Adding a Book

```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "available": true
}
```

### Postman screenshots

| `POST /library/add` |
| ------------------- |

![image](https://github.com/user-attachments/assets/4ec67178-3a82-40d9-8997-a8e66098ed89)

| `GET /library/all` |
| ------------------ |

![image](https://github.com/user-attachments/assets/86dde048-c342-4b69-bc93-6e9fb609bc66)

| ` book table` |
| ------------- |

![image](https://github.com/user-attachments/assets/697d3bf9-1a47-48ca-bf40-fbbe4c5d56dd)

| `GET library/2` |
| --------------- |

![image](https://github.com/user-attachments/assets/22d25f8d-835a-4fa6-acec-e1afa17c52e6)

| `DELETE /library/3` |
| ------------------- |

![image](https://github.com/user-attachments/assets/c1aa0749-5db2-4fe5-b032-d1022b965864)

| ` book table` |
| ------------- |

![image](https://github.com/user-attachments/assets/8aa3980b-d772-4414-affa-00ec6ceb0cd4)

| `PATCH /library/2/availability?available=false` |
| ----------------------------------------------- |

![image](https://github.com/user-attachments/assets/969c21bd-d9b7-4359-ae54-41e9644d32f4)

| ` book table` |
| ------------- |

![Image](https://github.com/user-attachments/assets/f6262f86-b410-41c8-b4b8-ec5db5077c1e)

## 📄 License

This project is created for learning and educational purposes only. No commercial use intended.

---

Made with 💻 and 🎨 by **Nitish Saini**
