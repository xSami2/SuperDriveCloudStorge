# Super Drive Cloud Storage Overview

Super Drive Cloud Storage is a secure cloud storage application that enables users to manage their files, notes, and credentials. Built on Java Spring Boot, Thymeleaf, and MyBatis, this application offers comprehensive features while ensuring robust security measures.

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Installation](#installation)
- [Running Tests](#running-tests)
- [Usage](#usage)


## Features

### Security

- **Custom AuthenticationProvider** for database-based user validation.
- **Spring Security integration** for secure user authentication and page access restrictions.

### User Management

- Signup and login features.
- Unique username validation.

### File Management

- Upload, download, and delete files.
- Error handling for duplicate file names.

### Notes

- Create, view, edit, and delete text-based notes.

### Credentials

- Store, view, edit, and delete website credentials.
- Encryption for stored passwords.

## Technology Stack

- Java 8+
- Spring Boot
- Spring Security
- Thymeleaf
- MyBatis
- MySQL
- Bootstrap
- Selenium for testing

## Installation

```bash
git clone https://github.com/yourusername/SuperDuperDrive.git

## Running Tests

```bash
mvn test

