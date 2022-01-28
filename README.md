School Management Project: Spring Boot + Spring Data JPA ( Hibernate)+ Spring Security +  Thymeleaf and Postgresql Database: 

1- Relationship Mapping with JPA and Hibernate in Spring - Spring Boot: 

- One-to-Many
- Many-to-One
- One-to-One
- Many-to-Many

2- CRUD Full Stack :
- Get all Teacher/Student

- Add a new Teacher/Student

- Update Teacher/Student By ID

- Delete Teacher/Student By ID

- Pagination Student

- Sorting Table Student By Name

3- Redirect to Different Pages after Login based on User Roles – Spring Boot Security:

- The user is redirected to the authentication login page. After successful login, the user is redirected to different dashboard based on logged in user roles.

  ** Login/Password:
  
# admin@gmail.com/admin
# teacher@gmail.com/teacher
# student@gmail.com/student

 4-  Spring Security Remember Me:

 User's login session terminates after closing the browser and if user again access the application by opening browser, it prompts for login, We can avoid this re-login by using remember me feature. It stores user's identity into the Cookie or database and use to identity the user.
 
 ==> So we should so we should create a table persistent_logins for stores the tokens in the databse with "JdbcTokenRepositoryImpl"

## SQL File:  
    -  data.sql

