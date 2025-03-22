# UserService

UserService is a Spring Boot-based microservice responsible for handling user-related operations. It consumes user signup events from Kafka (produced by AuthService) to register users and provides endpoints to manage user data.

## Features

- Consumes Kafka events to register users automatically.
- Provides RESTful endpoints for user-related operations.
- Integrates with a relational database.

## Tech Stack

- **Spring Boot**
- **Spring Data JPA**
- **Kafka**
- **MySQL**

## Setup & Installation

## Kafka Integration
- Listens to topic for new user events.
- Registers the user in the database upon receiving a signup event.
