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

![image](https://github.com/user-attachments/assets/02266635-0d18-4a1c-9760-034a22301ebe)

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

![image](https://github.com/user-attachments/assets/bd34c76c-db66-404b-a910-3ed49bad5f74)

| `GET /library/all` |
| ------------------ |

![image](https://github.com/user-attachments/assets/94fbe749-cd41-4e90-8797-bb30258d8ab3)

| ` book table` |
| ------------- |

![image](https://github.com/user-attachments/assets/d2957a46-0fd4-49ae-91b4-9b3c1ae0e760)

| `GET library/2` |
| --------------- |

![image](https://github.com/user-attachments/assets/70fe2ed4-99df-4983-93f6-e02c3732f2c9)

| `DELETE /library/3` |
| ------------------- |

![image](https://github.com/user-attachments/assets/c1aa0749-5db2-4fe5-b032-d1022b965864)

| ` book table` |
| ------------- |

![image](https://github.com/user-attachments/assets/b38da78e-4a5e-4b68-a186-88b3c92ebe4a)

| `PATCH /library/2/availability?available=false` |
| ----------------------------------------------- |

![image](https://github.com/user-attachments/assets/60cc0589-f200-430d-b2db-447be3befe15)

| ` book table` |
| ------------- |

![Image](https://github.com/user-attachments/assets/a0f61ad4-af36-4432-859c-5c9097ab41c7)

## 📄 License

This project is created for learning and educational purposes only. No commercial use intended.

---

Made with 💻 and 🎨 by **Nitish Saini**
