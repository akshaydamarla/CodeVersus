# ⚔️ CodeVersus

A real-time 1v1 DSA coding duel platform. Two players pick a language and a
difficulty, get the same problem, and race to solve it in a three-minute round.
Play against a public opponent or challenge a friend with a private invite link.

> **Status:** early development. The backend problem catalog is working;
> matchmaking, the judge, and the frontend are not built yet.

## Planned features

- Public matchmaking and private friend rooms
- Real-time match events over WebSockets
- Sandboxed code judging for Python, C, C++, and Java
- Server-controlled timer and a single, race-safe winner

## Tech stack

| Layer      | Technology                              |
| ---------- | --------------------------------------- |
| Backend    | Java 26, Spring Boot 4.1, Spring Data JPA |
| Database   | PostgreSQL 15, Flyway migrations        |
| Frontend   | React + TypeScript (planned)            |
| Later      | Redis, WebSockets, Docker-based judge   |

## Getting started

### Prerequisites

- JDK 26 and Maven (the project includes the Maven wrapper)
- PostgreSQL 15 or newer running locally

### 1. Create the database

Run these in `psql` or pgAdmin, one statement at a time:

```sql
CREATE USER codeversus WITH PASSWORD 'codeversus';
CREATE DATABASE codeversus OWNER codeversus;
```

### 2. Run the backend

```bash
cd backend
./mvnw spring-boot:run
```

Flyway creates the schema automatically on startup. The API runs on
`http://localhost:8080`.

### 3. Try it

```
GET /api/v1/problems
GET /api/v1/problems?difficulty=EASY
GET /api/v1/problems/{id}
```

## Project structure

```
backend/   Spring Boot API (controllers, services, repositories, Flyway migrations)
```

## License

[MIT](LICENSE)