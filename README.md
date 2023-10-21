Super Drive Cloud Storage
Overview
SuperDuperDrive Cloud Storage is a secure cloud storage application that enables users to manage their files, notes, and credentials. Built on Java Spring Boot, Thymeleaf, and MyBatis, this application offers comprehensive features while ensuring robust security measures.

Table of Contents
Features
Technology Stack
Installation
Running Tests
Usage
Contributing
License
Features
Security
Custom AuthenticationProvider for database-based user validation.
Spring Security integration for secure user authentication and page access restrictions.
User Management
Signup and login features.
Unique username validation.
File Management
Upload, download, and delete files.
Error handling for duplicate file names.
Notes
Create, view, edit, and delete text-based notes.
Credentials
Store, view, edit, and delete website credentials.
Encryption for stored passwords.
Technology Stack
Java 8+
Spring Boot
Spring Security
Thymeleaf
MyBatis
MySQL
Bootstrap
Selenium for testing
Installation
Clone the repository

bash
Copy code
git clone https://github.com/yourusername/SuperDuperDrive.git
Navigate to the project directory

bash
Copy code
cd SuperDuperDrive
Run the application using Maven

bash
Copy code
mvn spring-boot:run
Running Tests
This application uses Selenium for testing its features. Execute the tests via your IDE or use Maven command:

bash
Copy code
mvn test
