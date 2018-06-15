# ShareBooks
Sharebooks is a web application that serves as the platform for renting books online for a chosen period of time. This application was developed under the assumption that once the user rents a book online, he would have to meet and pay the owner to buy and return the books.

#### Technologies Used
- Backend language - Java 9
- Backend framework - Spring
- ORM Framework - Spring Data JPA (Hibernate)
- Database - MySql
- Server - Embedded Tomcat
- Build Tool and Dependency Manager - Maven
- Frontend web technologies - HTML5, CSS3, Javascript
- Theming and Styling - Bootstrap 4
- Templating Language - Thymeleaf
- Source Merging - Git
- Others - Spring Boot

#### Features
##### Home page - An appealing video themed background has been used
![image](https://user-images.githubusercontent.com/11651909/41486073-d9466b28-7097-11e8-9d5d-d6e96238b753.png)

##### Sign up / Sign in page - A new user could create an account and an existing user can login. When a new user registers he is automatically logged in and redirected to the Dashboard page.
![image](https://user-images.githubusercontent.com/11651909/41486112-091da7a8-7098-11e8-8ee2-29e4a3cdc562.png)

##### Explore page - Listing all available books. If the user is signed in, the borrow button appears and he can borrow a book. It uses bootstrap for the Masonry view layout.
![image](https://user-images.githubusercontent.com/11651909/41486141-2e8b8e7e-7098-11e8-95ce-0da113282354.png)

##### My Books - Lists the books owned by the logged in user
![image](https://user-images.githubusercontent.com/11651909/41486182-62852596-7098-11e8-8683-e1df71ac58cf.png)

##### Borrow a book - Click on borrow button on Explore page brings the user here where he could enter the period for which he would like to borrow the book.
![image](https://user-images.githubusercontent.com/11651909/41486263-b3cf9cb0-7098-11e8-903e-20744118b2fc.png)

##### My Borrow History - Lists the books borrowed by the logged in user. Once the borrow period is over, the user could click on the return button to return the book and the book reappears in the Explore page.
![image](https://user-images.githubusercontent.com/11651909/41486308-dca7bf0a-7098-11e8-9538-f26b20c610cb.png)

##### Add book - A page where the user could upload books of his own with or without an image
![image](https://user-images.githubusercontent.com/11651909/41486347-f925755a-7098-11e8-815f-f2e3e600484f.png)

#### Future Scope
Sharebooks has great potential for expansion. For the future, this application can be made to include the geographical location of the users and see how far away the book is and how much time it would take to get the book. The UberRush APIs if exposed could be hooked to Sharebooks to carry out the physical delivery of the book, which eliminates the need to physically meet and pay. Also, this application need not just pertain to books alone, if UberRush can be seamlessly integrated within this, Sharebooks has the potential to be a platform where anyone could share, borrow or lend anything.

#### License
Copyright 2018 SCU - COEN 499 Sharebooks




