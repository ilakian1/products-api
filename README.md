# products-api

Spring Boot REST API for 5COSC019W Object Oriented Programming (University of Westminster).

> **Note:** This repo was moved from [Ilakiancs](https://github.com/Ilakiancs), my main GitHub account for general work, to [ilakian1](https://github.com/ilakian1), the account I use for academic work. The commit history is unchanged.

## Endpoints

| Method | Path | Description |
|---|---|---|
| GET | `/hello` | Greeting |
| GET | `/goodbye` | Goodbye message |
| GET | `/status` | Status with today's date |
| GET | `/info` | About the application |

## Run

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080/swagger-ui.html
