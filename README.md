---

# gRPC Spring Boot implementation with Node.js CRUD UI

This project is a gRPC-based backend built with Spring Boot, coupled with a Node.js application that provides a CRUD-based user interface for managing Spectators. The system also includes a basic login feature for authentication.

---

## Features

### Spring Boot Backend
- **gRPC Implementation**: Provides endpoints to manage Spectators with Create, Read, Update, and Delete (CRUD) operations.
- **Protobuf Integration**: Defines the communication interface using Protocol Buffers.
- **Well-Structured Architecture**: Clean separation of gRPC server logic, service implementations, and protobuf files.

### Node.js Frontend
- **HTML UI**: A user-friendly interface for interacting with the gRPC backend.
- **CRUD Operations**: Perform Spectator creation, retrieval, updating, and deletion.
- **Login System**: Simple username/password authentication.
- **Integration with Backend**: Communicates with the backend using REST endpoints.

---

## Setup Instructions

### Prerequisites
- **Java 17+** (for Spring Boot backend)
- **Node.js 18+** (for frontend server)
- **Maven** (to manage Spring Boot dependencies)
- **npm or yarn** (for managing frontend dependencies)

---

### Spring Boot Backend Setup

1. **Unzip the project files.**
2. Navigate to the backend directory:
   ```bash
   cd backend
   ```
3. **Build and run the project:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
4. The backend will start on port **9090** by default.

---

### Node.js Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
2. **Install dependencies:**
   ```bash
   npm install
   ```
3. **Start the frontend server:**
   ```bash
   node index.js
   ```
4. The UI will be available on **http://localhost:3000**.

---

## Project Structure

### Backend (Spring Boot)
```
spectator-server/
├── src/main/java
│   ├── SpectatorApplication.java
│   ├── com.spectator.bo/
│   │   ├── Entry.java 
│   │   ├── Match.java
│   │   ├── MatchType.java
│   │   ├── Spectator.java 
│   ├── com.spectator.config/
│   │   ├── GrpeServer.java 
│   ├── com.spectator.controller/
│   │   ├── SpectatorController.java 
│   ├── com.spectator.repository/
│   │   ├── EntryRepository.java 
│   │   ├── MatchRepository.java
│   │   ├── SpectatorRepository.java 
│   ├── com.spectator.service/
│   │   ├── SpectatorServiceImpl.java 
├── src/main/proto
│   ├── spectator.proto               # Protocol Buffers definition
├── src/main/resources
│   ├── application.properties        # Application properties

```

### Frontend (Node.js + HTML)
```
frontend/
├── index.js                       # Node.js server
├── index.html                     # Main CRUD and Login UI
├── package.json                   # Dependencies
```

---

## gRPC Endpoints

### Defined in `spectator.proto`
- **CreateSpectator**: Adds a new Spectator.
- **GetSpectatorById**: Fetches Spectator details by ID.
- **UpdateSpectator**: Updates Spectator information.
- **DeleteSpectator**: Removes a Spectator.

---

## REST Endpoints (Frontend -> Node.js)

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| POST   | `/login`              | Authenticates user.          |
| POST   | `/createSpectator`    | Adds a new Spectator.        |
| POST   | `/getSpectatorById`   | Retrieves a Spectator by ID. |
| POST   | `/updateSpectator`    | Updates a Spectator.         |
| POST   | `/deleteSpectator`    | Deletes a Spectator.         |

---

## Usage Guide

1. **Login**:
    - Use the credentials: `username: admin`, `password: password` (can be customized in the Node.js server).
2. **CRUD Operations**:
    - Use the UI to add, view, edit, or delete Spectators.

---

## Future Improvements
- Add user authentication and authorization for gRPC endpoints.
- Enhance the frontend UI with better design and validation.
- Extend the backend to include more entities and relationships.

---
