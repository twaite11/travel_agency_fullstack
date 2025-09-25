## Travel Agency Back-End Application
This repository contains the back-end portion of a modern travel agency's vacation booking platform. The project is built using the Spring Framework and is designed to replace a legacy system by providing a robust, modern, and scalable back end that interacts with an existing MySQL database and an Angular front end.

The purpose of this project is to demonstrate core skills in building a Java back-end application, including data modeling, API design, and transaction management.

### Technologies Used
Spring Boot: The foundation for building a stand-alone, production-grade Spring application.

Spring Data JPA: Simplifies data access and provides an ORM layer for interacting with the MySQL database.

Spring Data REST: Automatically generates RESTful API endpoints for the data repositories.

MySQL Connector/J: The JDBC driver for connecting to the MySQL database.

Lombok: A library that reduces boilerplate code by auto-generating getters, setters, and constructors.

Jakarta Validation: Used to enforce data integrity with annotations like @NotNull and @NotBlank.

Maven: The build automation tool for managing project dependencies and building the application.

### Project Structure
The application is structured in a layered architecture to ensure separation of concerns:

controllers: Contains REST controllers that handle incoming HTTP requests from the front end.

services: Holds the business logic for the application, including the checkout process.

dao: Includes repository interfaces that provide a data access layer for the entities.

entities: Defines the data models and their relationships, which map directly to the database tables.

### How to Run the Application
Clone the Repository: Clone this repository to your local machine.

Set up the Database: Ensure you have a MySQL server running and have executed the provided SQL script to create the full-stack-ecommerce database and its tables.

Configure application.properties: Update the src/main/resources/application.properties file with your database connection details (username and password).

Run the Application: Open the project in IntelliJ IDEA and run the TravelAgencyD288Application.java file. The application will start on http://localhost:8080.

Run the Front End: Navigate to your Angular front-end project in a terminal and run ng serve --open.

### Key Features
Customer Management: The back end exposes endpoints to manage customer data. On application startup, a DataLoader class populates the database with five sample customers to facilitate testing.

Vacation & Excursion Catalog: The application provides data for vacations and their associated excursions, which the front end displays for user selection.

Transactional Checkout: The CheckoutController processes POST requests from the front end. It utilizes a transactional service to save customer, cart, and cart item data to the database in a single, atomic operation, ensuring data consistency. A unique order tracking number is generated for each successful purchase.

Cross-Origin Resource Sharing (CORS): All API endpoints are configured with @CrossOrigin to allow requests from the Angular front end running on a different port, preventing common cross-origin security errors.

This project represents a complete, functional back-end solution that is ready for deployment and further development.
