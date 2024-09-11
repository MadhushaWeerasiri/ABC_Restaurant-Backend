# ABC Restaurant Backend

This repository contains the backend for the ABC Restaurant interactive web-based application. The backend is responsible for handling API requests, managing the database, and providing essential services to the frontend application.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Environment Variables](#environment-variables)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Features
- **User Management**: Secure authentication and authorization using JWT.
- **Reservation System**: API endpoints for creating, updating, and managing reservations.
- **Query Management**: Handling customer queries and staff responses.
- **Product and Menu Management**: APIs for managing restaurant products and menu items.
- **Offers and Promotions**: Manage and retrieve current offers and promotions.
- **Image Uploads**: Store and manage images related to products and facilities.

## Technologies Used
- **Spring Boot**: Framework used to build the backend application.
- **MongoDB**: NoSQL database used to store application data.
- **Spring Data MongoDB**: Spring-based data access framework for MongoDB.
- **Spring Security**: Handles authentication and authorization.
- **JWT (JSON Web Token)**: Used for securing APIs.
- **Maven**: Dependency management and build tool.

## Installation
Follow these steps to set up and run the project locally.

### Prerequisites
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (v11 or higher)
- [Maven](https://maven.apache.org/) (v3.6.x or higher)
- [MongoDB](https://www.mongodb.com/) (v4.x or higher)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/MadhushaWeerasiri/ABC_Restaurant-Backend.git
   cd ABC_Restaurant-Backend

2. Install the dependencies:
   ```bash
    mvn clean install

## Running the Application

### Development Server
To run the application in development mode:
  ```bash
  mvn spring-boot:run
  ```

The server will start on http://localhost:8080/.

## Production Build
To package the application for production:
  ```bash
  mvn clean package
  ```

This will generate a .jar file in the target directory that can be run using:
  ```bash
  java -jar target/abc-restaurant-backend.jar
  ```

## Environment Variables
Create an application.properties or application.yml file in the src/main/resources directory to configure the following environment variables:
  ```properties
  # Server configuration
  server.port=8080

  # MongoDB configuration
  spring.data.mongodb.uri=mongodb://localhost:27017/abc_restaurant

  # JWT configuration
  jwt.secret=your_jwt_secret_key
  jwt.expiration=3600000

  # File storage configuration
  file.upload-dir=src/main/resources/static/assets
  ```
server.port: The port on which the server will run.
spring.data.mongodb.uri: MongoDB connection string.
jwt.secret: Secret key used to sign JWT tokens.
jwt.expiration: Expiration time for JWT tokens (in milliseconds).
file.upload-dir: Directory to store uploaded files and images.

## Project Steucture
```bash
ABC_Restaurant-Backend/
├── src/
│   ├── main/
│   │   ├── java/com/abc/restaurant/
│   │   │   ├── config/            # Security and application configurations
│   │   │   ├── controller/        # REST controllers for handling requests
│   │   │   ├── model/             # MongoDB data models
│   │   │   ├── repository/        # MongoDB repositories
│   │   │   ├── service/           # Business logic and services
│   │   │   └── ABCRestaurantBackendApplication.java  # Main application class
│   │   └── resources/
│   │       ├── application.properties  # Environment configuration
│   │       └── static/assets/          # Directory for uploaded files and images
├── .gitignore            # Git ignore file
├── pom.xml               # Maven configuration file
└── README.md             # Project documentation

```

## API Endpoints
### Authentication
POST /api/auth/register - Register a new user.
POST /api/auth/login - Authenticate user and generate a JWT token.

### Reservations
GET /api/reservations - Get all reservations.
POST /api/reservations - Create a new reservation.
GET /api/reservations/{id} - Get reservation by ID.
PUT /api/reservations/{id} - Update reservation by ID.
DELETE /api/reservations/{id} - Delete reservation by ID.

### Products
GET /api/products - Get all products.
POST /api/products - Add a new product.
GET /api/products/{id} - Get product by ID.
PUT /api/products/{id} - Update product by ID.
DELETE /api/products/{id} - Delete product by ID.

### Queries
GET /api/queries - Get all queries.
POST /api/queries - Submit a new query.
GET /api/queries/{id} - Get query by ID.
PUT /api/queries/{id} - Update query by ID.
DELETE /api/queries/{id} - Delete query by ID.

### Offers
GET /api/offers - Get all offers.
POST /api/offers - Create a new offer.
GET /api/offers/{id} - Get offer by ID.
PUT /api/offers/{id} - Update offer by ID.
DELETE /api/offers/{id} - Delete offer by ID.

## Contributing
We welcome contributions to improve this project! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature/your-feature).
3. Make your changes.
4. Commit your changes (git commit -m 'Add some feature').
5. Push to the branch (git push origin feature/your-feature).
6. Open a pull request.

Please ensure your code follows the project's coding standards and includes appropriate tests.
