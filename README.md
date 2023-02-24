# Design Multi User Blogging Platform

#### Arpit Bhayani's system design problem

### Requirements Gathering
1. There are two types of users: Author and Reader
2. Author should be able to publish a blog
3. Readers should be able to view the blogs
4. Author can delete a blog
5. Blog may contain images but not videos
6. Show no of blogs published by user on their profile
7. Anyone should be able to search blogs
8. Time to access blogs should be as low as possible
9. platform should scale for 5 million daily active readers
10. platform should scale for 10000 daily active users

---

### Database Setup
    postgres=# create user sanket with password 'sanket';
    
    CREATE ROLE
    
    postgres=# create database blogging__platform;
    
    CREATE DATABASE
    
    postgres=# grant all privileges on database blogging__platform to sanket;
    
    GRANT

---

### Entities
1. User
2. Blog
3. UserBlog

---

### Relationships


---

### Class Diagram


---

### Schema Diagram

