# Blackjack API

## Description
This project implements a reactive API to manage a Blackjack game using Spring Boot and Spring WebFlux.
The API handles players and game sessions, while enforcing the rules of Blackjack. 
Game data is persisted in MongoDB (Reactive), and player information and rankings are stored in MySQL (JPA).  
It exposes endpoints for creating and deleting games, playing rounds, managing players, and retrieving player rankings.

## Technologies used
- Oracle OpenJDK 21.0.8
- Spring Boot 3.5.8
- Spring WebFlux
- Maven 3.9.11
- MongoDB
- MySQL
- Docker
- Swagger
- JUnit & Mockito
- IntelliJ IDEA Community Edition

## Installation
1. Clone repository (https://github.com/AlbertMedina/5.1-Spring-Framework-Advanced-Nivell2.git).
```
git clone https://github.com/AlbertMedina/5.1-Spring-Framework-Advanced-Nivell2.git
```
2. Navigate to project folder.
```
cd blackjack-api
```
3. Ensure Docker is installed and running.

## Execution
1. Pull the image from Docker Hub:
```
docker pull albertmc/blackjack-api:latest
```
or build it locally:
```
docker build -t blackjack-api .
```
2. Start the application and databases with Docker Compose:
```
docker-compose up
```
This will start MongoDB, MySQL and the Spring Boot API.
The API will be available at
```
http://localhost:8080
```
The API documentation will be available via Swagger at:
```
http://localhost:8080/swagger-ui.html
```
