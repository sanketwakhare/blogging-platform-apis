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


### Kafka service setup steps

1. Install Apache Kafka (Zookeeper comes with installation)

2. Start Zookeeper service 

    
    D:\kafka>start cmd /k bin\windows\zookeeper-server-start.bat config\zookeeper.properties

4. Start Kafka service


    D:\kafka>start cmd /k bin\windows\kafka-server-start.bat config\server.properties

6. Create Kafka Topic


    D:\kafka>bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic blogging
    Created topic blogging.

- You can optionally verify the Kafka stream by starting producer and consumers

5. Start Producer service

    
    D:\kafka>bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic blogging

7. Start Consumer service

    
    D:\kafka>bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic blogging --from-beginning

---

### Class Diagram


---

### Schema Diagram


---

### Resources:
1. https://howtodoinjava.com/kafka/getting-started-windows-10/
2. https://howtodoinjava.com/kafka/spring-boot-with-kafka/