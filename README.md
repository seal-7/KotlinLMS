# 📚 Library Book Management System

This project is a **Library Book Management System** built with **Kotlin** and **Spring Boot**. The system allows managing books, users, and tracking book borrowing using an **in-memory database**.

## 📝 Problem Statement

Design and implement a **Library Book Management System** that provides REST APIs to perform CRUD operations on books and users while allowing book borrowing and returning.

## 📌 Features

### 1. Book Management
- Add a new book with the following fields:
    - Title (String)
    - Author (String)
    - ISBN (String)
    - Publication Year (Int)
- Edit book details.
- Delete a book.
- View all books.
- Search books by title, author, or ISBN.

### 2. User Management
- Register a new user with the following fields:
    - Name (String)
    - Email (String)
- View all registered users.

### 3. Borrowing System
- Allow a user to borrow a book:
    - Each book can be borrowed by **one user** at a time.
    - A user can borrow a **maximum of 5 books**.
- Allow a user to return a book.
- View a list of all currently borrowed books with borrower details.

## 📊 API Endpoints

### Book APIs
- `POST /books` – Add a new book
- `GET /books` – Get a list of all books (supports search by title, author, or ISBN)
- `PUT /books/{id}` – Update book details
- `DELETE /books/{id}` – Delete a book

### User APIs
- `POST /users` – Register a new user
- `GET /users` – Get a list of all users

### Borrowing APIs
- `POST /borrow` – Borrow a book (requires `userId` and `bookId`)
- `POST /return` – Return a book (requires `userId` and `bookId`)
- `GET /borrowed` – List all borrowed books with borrower details

## ✅ Constraints
- A user can borrow **up to 5 books**.
- A book can be borrowed by **only one user** at a time.

## 🚀 Bonus Features (Optional)
- Implement pagination for book listings.
- Add input validation (e.g., ISBN format, user limits).
- Track borrowing history (who borrowed what and when).

## 📦 Tech Stack
- **Kotlin** (Language)
- **Spring Boot** (Framework)
- **In-memory Database** (e.g., H2, or a simple Kotlin collection)

## 📖 How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/your-repo/library-management.git
cd library-management
```

2. Build and run the Spring Boot application:

```bash
./gradlew bootRun
```

3. Access the APIs at `http://localhost:8080`

## 🛠️ Future Improvements
- Implement user authentication.
- Add book reservation features.
- Export data to CSV/JSON.
