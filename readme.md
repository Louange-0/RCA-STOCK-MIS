# Stock Management System

This Stock Management System (SMS) is designed for RCA Stock to automate the management of stock, orders, suppliers, and report generation. The system enhances efficiency, accuracy, and user satisfaction.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Models](#models)
- [Services](#services)
- [Controllers](#controllers)
- [Security](#security)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The Stock Management System (SMS) automates the management of stock items, orders, and suppliers. It also generates various reports and provides user authentication and authorization.

## Features
- **Inventory Management:** Adding, updating, deleting, and searching stock items.
- **Order Management:** Creating, updating, and tracking orders.
- **Supplier Management:** Managing supplier information and communication.
- **Stock Monitoring:** Real-time stock level monitoring and notifications.
- **Report Generation:** Generating various reports such as stock levels, order history, and supplier performance.

## Technology Stack
- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- Lombok
- Jakarta EE
- MySQL or PostgreSQL
- Maven

## Prerequisites
Before you begin, ensure you have the following installed:
- Java 17 or higher
- Maven 3.6 or higher
- MySQL or PostgreSQL database

## Installation
1. **Clone the repository:**
    ```bash
    git clone https://github.com/dev-teamm/RCA-SMS-BACKEND.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd stock-management-system
    ```
3. **Install the dependencies:**
    ```bash
    mvn install
    ```

## Configuration
1. **Update `application.properties`:**  
   Update the database configurations in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgres://localhost:5432/rcastock
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```
2. **Additional configurations:**  
   Modify other settings in `application.properties` as needed.

## Running the Application
1. **Run with Maven:**
    ```bash
    mvn spring-boot:run
    ```
2. **Access the application:**  
   The application will be available at `http://localhost:8080/api/v1`.

## Testing
To run tests, execute:
```bash
mvn test
```

## Project Structure
The project structure follows a standard Maven layout:

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── rca
│   │           └── stockmanagement
│   │               ├── controller        # API controllers
│   │               ├── dto               # Data Transfer Objects
│   │               ├── entity            # Entity classes (e.g., User, Product)
│   │               ├── exception         # Custom exceptions
│   │               ├── repository        # Spring Data repositories
│   │               ├── service           # Service layer for business logic
│   │               └── config            # Configuration classes (e.g., Security config)
│   └── resources
│       ├── application.properties        # Application configuration
│       └── schema.sql                    # Database schema definition
└── test
    └── java
        └── com
            └── rca
                └── stockmanagement       # Test classes
```

## API Endpoints
### Authentication
- **POST** `/api/auth/register` - Register a new user
- **POST** `/api/auth/authenticate` - Login and obtain a token
- **GET** `/api/auth/activate-account` - Activate user account
- **POST** `/api/auth/forgot-password` - Request password reset
- **PUT** `/api/auth/reset-password` - Reset password

### Models
- **User:** Represents a user in the system
- **VerificationToken:** Token for email verification during registration
- **ResetToken:** Token for password reset

### Services
- **AuthenticationService:** Handles user registration, authentication, account activation, and password management

### Controllers
- **AuthenticationController:** Provides endpoints for user authentication and account management

## Security
- JWT-based authentication and authorization
- Role-based access control (roles: admin, manager)

## Contributing
Contributions are welcome! Please fork this repository and submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
