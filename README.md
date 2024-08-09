*This library system website mainly uses Java, Spring Boot, PostgreSQL and REST APIs.*

**To Run the project:** 
1- Ensure you have Java installed and set up.
2- Run the BackendApplication class (path: backend\src\main\java\com\library\backend\BackendApplication.java).  
3- The application will be accessible at `http://localhost:8080/api/books`.

**PostgreSQL database relations:** 
- books(one-to-many)Borrows.
- patrons(one-to-many)Borrows.

**Postman API testing**\
**Books**\
*Creating a Book*\
1- Successfully Create a book:
![image](https://github.com/user-attachments/assets/09a59c40-b961-404f-a077-6a72e4bb17ba)
2- Trying to create an already existing book:
![image](https://github.com/user-attachments/assets/fb06e498-8636-43db-b524-1c1fe97ab18a)
3- Trying to create a book with missing main attributes:
![image](https://github.com/user-attachments/assets/5331fbfd-5a71-4265-bbcd-b653ad112202)
4- Entering a non-unique ISBN:
![image](https://github.com/user-attachments/assets/10eb8444-72cc-4285-a65b-daa4e119e448)

*Retrieve details of a specific book by ID*\
1- Successfully finding the book:
![image](https://github.com/user-attachments/assets/85aa9a77-9da3-4462-a0f5-cf134df2a4b2)
2- Searching for a book with an id that does not exist:
![image](https://github.com/user-attachments/assets/d612459f-f37e-48b5-8306-98c453be2730)

*Retrieve all books*\
1- Successful retrieve:
![image](https://github.com/user-attachments/assets/922dddc4-1306-4951-b97d-f813da067351)

*Delete a book*\
1- Succesful Delete:
![image](https://github.com/user-attachments/assets/1e474e40-a760-4c08-978b-58b6cbfc2391)
2- Deleting a non-existing book:
![image](https://github.com/user-attachments/assets/0e61829f-b083-4b42-b915-f82bfcca93aa)

*Update a book*\
1- Succesful update:
![image](https://github.com/user-attachments/assets/1b300d7c-14ac-40b6-9564-2e58b44b2a3a)
2- Updating with invalid input (ex: not a unique Isbn):
![image](https://github.com/user-attachments/assets/2f65ea8c-bdef-43f3-8a9a-397244d39b36)
3- Updating a non-existing book:
![image](https://github.com/user-attachments/assets/bf7ad82f-4290-40cd-b17b-3cb9e9230565)

**Patron**

*Creating a patron*\
1- Successfully Create:
![image](https://github.com/user-attachments/assets/5e982c10-2890-4261-8b4c-9bd4a8312a3c)
2- Trying to create an already existing one:
![image](https://github.com/user-attachments/assets/39a16906-ac5e-4496-a79c-0dec835a9789)
3- Trying to create with missing attributes:
![image](https://github.com/user-attachments/assets/0e68b6bb-974f-404f-9289-76be955684c2)
4- Entering a non-unique email:
![image](https://github.com/user-attachments/assets/eb2b4865-153b-4322-84bf-62a516262ad4)
5- not including a body:
![image](https://github.com/user-attachments/assets/1f71130a-f589-464f-ab27-43ed9f39b611)

*Retrieve details of a specific patron by ID*\
1- Successfully finding the patron:
![image](https://github.com/user-attachments/assets/c2137eaa-8ace-4615-aa10-88a1501fe499)
2- Searching for a patron with an ID that does not exist:
![image](https://github.com/user-attachments/assets/c2f6376a-2dbd-4134-a782-590e60333e61)

*Retrieve all patrons*\
1- Successful retrieve:
![image](https://github.com/user-attachments/assets/008a8347-cb4c-43e9-a479-a73575b58774)

*Delete a patron*\
1- Succesful Delete:
![image](https://github.com/user-attachments/assets/0447baeb-203c-48aa-a1eb-c742814a67e5)
2- Deleting a non-existing patron:
![image](https://github.com/user-attachments/assets/ea45a128-5cb2-429a-ac5d-445cc9c11bae)

*Update a patron*\
1- Succesful update:
![image](https://github.com/user-attachments/assets/5448ead0-46a8-40d5-a395-aad697cdd213)
2- Updating with invalid input (ex: not a unique phone number):
![image](https://github.com/user-attachments/assets/fc021af5-9451-475c-aadc-59c462c15100)
3- Updating a non-existing patron:
![image](https://github.com/user-attachments/assets/480ad246-79ca-46f2-854a-55f2d7242286)

**Borrowing**\

1- A patron borrows a book:
![image](https://github.com/user-attachments/assets/80470f1d-7414-47ef-b64a-fcd631075020)
2- Borrowing with a non-existing patron ID:
![image](https://github.com/user-attachments/assets/a9cd4f20-9049-472d-9481-f15aa7ac27c6)
3- Borrowing with a non-existing book ID:
![image](https://github.com/user-attachments/assets/bb92fc15-8b30-47a0-aa10-8676d6e93008)
4- Borrow an already Borrowed book:
![image](https://github.com/user-attachments/assets/0f7205c0-f189-4412-a363-cad09345836d)
5- Return a book:
![image](https://github.com/user-attachments/assets/ed8e5512-5076-4c14-b3d9-e5c78bcba769)
6- Trying to return a book you did not borrow:
![image](https://github.com/user-attachments/assets/b4fa1692-7c2f-44a2-b875-aa4ea92e80b0)


# Books API Documentation

## Overview

The `BooksController` class provides a RESTful API for managing books within a library system. This API allows clients to perform various operations related to books.

## Base URL

The base URL for all endpoints is:

http://localhost:8080/api/books


## Endpoints

### 1. Create a New Book

- **Endpoint:** `/api/books`
- **Method:** `POST`
- **Description:** Adds a new book to the system.

#### Request

- **Content-Type:** `application/json`

- **Request Body Example:**

    ```json
    {
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "isbn": "9780743273565",
      "publishedDate": "1925-04-10"
    }
    ```

  - **Fields:**
    - `title` (String): The title of the book.
    - `author` (String): The author of the book.
    - `isbn` (String): The ISBN of the book.
    - `publishedDate` (String): The publication date of the book in `YYYY-MM-DD` format.


### 2. Update a Book

- **Endpoint:** `/api/books/{id}`
- **Method:** `PUT`
- **Description:** Updates the details of an existing book.

#### Request

- **Content-Type:** `application/json`
- **Path Parameter:** `id` (Long): The ID of the book to be updated.

- **Request Body Example:**

    ```json
    {
      "title": "The Great Gatsby - Updated",
      "author": "F. Scott Fitzgerald",
      "isbn": "9780743273565",
      "publishedDate": "1925-04-10"
    }
    ```

  - **Fields:**
    - `title` (String): The new title of the book.
    - `author` (String): The new author of the book.
    - `isbn` (String): The new ISBN of the book.
    - `publishedDate` (String): The new publication date of the book in `YYYY-MM-DD` format.

### 3. Get a Book by ID

- **Endpoint:** `/api/books/{id}`
- **Method:** `GET`
- **Description:** Retrieves the details of a specific book.

#### Request

- **Path Parameter:** `id` (Long): The ID of the book to be retrieved.

### 4. Delete a Book

- **Endpoint:** `/api/books/{id}`
- **Method:** `DELETE`
- **Description:** Deletes a specific book from the system.

#### Request

- **Path Parameter:** `id` (Long): The ID of the book to be deleted.


## Error Handling

- **400 Bad Request:** Returned when the request body is invalid or missing required fields.
- **404 Not Found:** Returned when the specified book does not exist in the system.
- **422 Unprocessable Entity:** Returned when the request is unable to be processed due to semantic errors, such as invalid values or constraints.


## Dependencies

Ensure the following dependencies are included in your `pom.xml` or `build.gradle` file:

- **Spring Boot Starter Web**
- **Spring Boot Starter Data JPA** (if using a database)











