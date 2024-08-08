*This library system website mainly uses Java, Spring Boot, PostgreSQL and REST APIs.*

**To Run the project:** Run the BackendApplication class (path: backend\src\main\java\com\library\backend\BackendApplication.java). 

**Postman API testing**\
**Books**\
*Creating a Book*\
1- Successfully Create a book:
![image](https://github.com/user-attachments/assets/09a59c40-b961-404f-a077-6a72e4bb17ba)
2- Trying to create an already existing book:
![image](https://github.com/user-attachments/assets/0b8e27d0-f49b-4ef0-abb7-d9b58b41205c)
3- Trying to create a book with missing main attributes:
![image](https://github.com/user-attachments/assets/3bfe1fb7-f112-4d84-8590-f2672e00c635)
4- Entering a non-unique ISBN:
![image](https://github.com/user-attachments/assets/244e6d25-9f6b-48e5-8f68-aa661c5bf8fe)

*Retrieve details of a specific book by ID*\
1- Successfully finding the book:
![image](https://github.com/user-attachments/assets/85aa9a77-9da3-4462-a0f5-cf134df2a4b2)
2- Searching for a book with an id that does not exist:
![image](https://github.com/user-attachments/assets/7a673eba-61a0-418e-9882-5c849cbbbfe2)

*Retrieve all books*\
1- Successful retrieve:
![image](https://github.com/user-attachments/assets/922dddc4-1306-4951-b97d-f813da067351)

*Delete a book*\
1- Succesful Delete:
![image](https://github.com/user-attachments/assets/1e474e40-a760-4c08-978b-58b6cbfc2391)
2- Deleting a non-existing book:
![image](https://github.com/user-attachments/assets/f70beb65-36b0-47a1-8681-cd60b12291f5)

*Update a book*\
1- Succesful update:
![image](https://github.com/user-attachments/assets/1b300d7c-14ac-40b6-9564-2e58b44b2a3a)
2- Updating with invalid input (ex: not a unique Isbn):
![image](https://github.com/user-attachments/assets/2f65ea8c-bdef-43f3-8a9a-397244d39b36)
3- Updating a non-existing book:
![image](https://github.com/user-attachments/assets/07e5d10a-e303-4f61-96cb-bd7cf05cba0b)

**Patron**

*Creating a patron*\
1- Successfully Create:
![image](https://github.com/user-attachments/assets/5e982c10-2890-4261-8b4c-9bd4a8312a3c)
2- Trying to create an already existing one:
![image](https://github.com/user-attachments/assets/14986990-75f9-4013-9d6d-68228e89c375)
3- Trying to create with missing attributes:
![image](https://github.com/user-attachments/assets/8bac7ca3-c1c6-4616-a8c3-63fd166f3d2e)
4- Entering a non-unique email:
![image](https://github.com/user-attachments/assets/7b360121-79c3-41cc-8345-71c85bbd2d87)
5- not including a body:
![image](https://github.com/user-attachments/assets/1f71130a-f589-464f-ab27-43ed9f39b611)

*Retrieve details of a specific patron by ID*\
1- Successfully finding the patron:
![image](https://github.com/user-attachments/assets/c2137eaa-8ace-4615-aa10-88a1501fe499)
2- Searching for a patron with an ID that does not exist:
![image](https://github.com/user-attachments/assets/c6270c2f-7fc0-4f1b-8fd3-7d1e4f93df6a)

*Retrieve all patrons*\
1- Successful retrieve:
![image](https://github.com/user-attachments/assets/008a8347-cb4c-43e9-a479-a73575b58774)

*Delete a patron*\
1- Succesful Delete:
![image](https://github.com/user-attachments/assets/0447baeb-203c-48aa-a1eb-c742814a67e5)
2- Deleting a non-existing patron:
![image](https://github.com/user-attachments/assets/71ef3fad-c446-4137-b0b2-8a2933a60801)

*Update a patron*\
1- Succesful update:
![image](https://github.com/user-attachments/assets/5448ead0-46a8-40d5-a395-aad697cdd213)
2- Updating with invalid input (ex: not a unique phone number):
![image](https://github.com/user-attachments/assets/fc021af5-9451-475c-aadc-59c462c15100)
3- Updating a non-existing patron:
![image](https://github.com/user-attachments/assets/4501809f-18fd-4851-b244-e6be3d158252)

**Borrowing**\

1- A patron borrows a book:
![image](https://github.com/user-attachments/assets/80470f1d-7414-47ef-b64a-fcd631075020)
2- Borrowing with a non-existing patron ID:
![image](https://github.com/user-attachments/assets/a9cd4f20-9049-472d-9481-f15aa7ac27c6)
3- Borrowing with a non-existing book ID:
![image](https://github.com/user-attachments/assets/bb92fc15-8b30-47a0-aa10-8676d6e93008)
4- Borrow an already Borrowed book:
![image](https://github.com/user-attachments/assets/c12dc881-aab4-49fe-a3d0-138f61e8cb4d)
5- Return a book:
![image](https://github.com/user-attachments/assets/ed8e5512-5076-4c14-b3d9-e5c78bcba769)
6- Trying to return a book you did not borrow:
![image](https://github.com/user-attachments/assets/90bebb90-c213-4c70-9a2f-a853774e5a58)
7- Trying to borrow an already borrowed book:
![image](https://github.com/user-attachments/assets/dc75548b-4966-4a5d-973e-091948c0d95f)











