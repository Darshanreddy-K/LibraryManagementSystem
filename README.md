# Library Management System (Java)

A console-based **Library Management System** built in Java demonstrating core Object-Oriented Programming (OOP) principles—**abstraction, inheritance, polymorphism, encapsulation, and interfaces**—along with clean separation of concerns.

---

## Features

- **Book Management**
    - Supports distinct book categories (`TextBook` and `NovelBook`) extending a base `Book` abstraction.
    - Tracks core metadata (`ISBN`, `title`, `author`, availability status) alongside category-specific attributes (`subject`, `edition`, `genre`).
- **User Management**
    - Supports `Member` and `Librarian` roles with auto-generated unique IDs (`U-1`, `U-2`, etc.).
    - Provides role-specific dashboards and borrowing permissions.
- **Lending & Returning Workflow**
    - Validates book availability before checkout.
    - Enforces a maximum borrow limit (`MAX_BORROW_LIMIT = 2`) per library member.
    - Ensures only the current borrower can return a checked-out book.
- **Overloaded Search**
    - Search books by keyword (`title` or `author`, case-insensitive).
    - Filter search results by book category (`TextBook` or `NovelBook`).

---

## OOP Architecture

```text
Lendable (Interface)
   ▲
   │ implements
  Book (Abstract Class)
   ├── TextBook
   └── NovelBook

User (Abstract Class)
   ├── Member
   └── Librarian

LibraryManagementSystem (Service / Controller)
   └── Client (Entry Point)
```

| File | Type | Responsibility |
| :--- | :--- | :--- |
| `Lendable.java` | Interface | Defines the contract for borrowable items (`lend`, `returnItem`, `isAvailable`). |
| `Book.java` | Abstract Class | Implements `Lendable`; manages shared book fields, copy constructor, and borrow/return state. |
| `TextBook.java` | Concrete Class | Extends `Book`; adds `subject` and `edition` attributes. |
| `NovelBook.java` | Concrete Class | Extends `Book`; adds `genre` attribute. |
| `User.java` | Abstract Class | Handles user registration, unique ID generation (`U-X`), and abstract user contracts. |
| `Member.java` | Concrete Class | Extends `User`; tracks active borrowed count and enforces the 2-book limit. |
| `Librarian.java` | Concrete Class | Extends `User`; stores `employeeNumber` and defines librarian capabilities. |
| `LibraryManagementSystem.java` | Service Class | Coordinates book inventory, user registry, lending/returning rules, and search queries. |
| `Client.java` | Main Class | Demonstrates system workflows, edge cases (unavailable books, borrow limits), and search queries. |

---

## Project Structure

```text
LibraryManagementSystem/
├── src/
│   ├── Book.java
│   ├── Client.java
│   ├── Lendable.java
│   ├── Librarian.java
│   ├── LibraryManagementSystem.java
│   ├── Member.java
│   ├── NovelBook.java
│   ├── TextBook.java
│   └── User.java
└── README.md
```

---

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)** 17 or higher
- **IntelliJ IDEA** (or any Java IDE / terminal)

### Run in IntelliJ IDEA
1. Open the project folder in **IntelliJ IDEA**.
2. Verify that `src/` is marked as **Sources Root**.
3. Open `src/Client.java`.
4. Click the green **Run** button next to `main` (or press `Shift + F10` on Windows/Linux, `Ctrl + R` on macOS).

### Run via Terminal
```bash
cd src
javac *.java
java Client
```

---
g
## Sample Output

```text
--- Integrate Book and User Management ---
--- Library Book Inventory ---
isbn: 978-0123434434
Title: DSA
Author: Vikram
Subject: Computer Science
Edition: 10
Availability : true
-----------------------------------
...
--- Demonstrate Lending Functionality ---
Darshan can borrow books.Darshan borrowed successfully.
--- Test Scenario: Borrowing an already lended Book ---
Vikram can't borrow this book. Book unavailable.
--- Test Scenario: Exceeding borrow limit ---
Darshan can borrow books.Darshan borrowed successfully.
Darshan can't borrow this book. Limit reached.
```

---

## Code Notes & Future Enhancements

- **Fix Import in `Librarian.java`**: Remove `import java.awt.print.Book;` on line 1 so `addNewBook(Book)` and `removeBook(Book)` reference the project's `Book` class.
- **Complete Librarian Operations**: Wire `Librarian#addNewBook` and `Librarian#removeBook` to `LibraryManagementSystem`.
- **Naming Cleanup**: Rename `isAvaliable` in `Book.java` to `isAvailable` for spelling consistency.
- **Lending Support for Librarians**: Update `LibraryManagementSystem#lendBook` and `returnBook` to accept `User` (or handle `Librarian` borrowing) since `Librarian#canBorrowBooks()` returns `true`.