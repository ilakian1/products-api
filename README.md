# products-api

Spring Boot REST API for 5COSC019W Object Oriented Programming (University of Westminster).

> **Note:** This repo was moved from [Ilakiancs](https://github.com/Ilakiancs), my main GitHub account for general work, to [ilakian1](https://github.com/ilakian1), the account I use for academic work. The commit history is unchanged.

## Endpoints

| Method | Path | Description |
|---|---|---|
| GET | `/hello` | Greeting |
| GET | `/goodbye` | Goodbye message |
| GET | `/status` | Status with today's date |
| GET | `/products` | All products |
| GET | `/products/{id}` | A product by id |
| POST | `/products` | Create a product (id is assigned by the service) |
| DELETE | `/products/{id}` | Delete a product |
| GET | `/products/search?name=` | Products whose name contains the text |
| GET | `/products/cheaper-than?price=` | Products cheaper than the given price |
| GET | `/customers/{id}` | A customer with a nested address |
| GET | `/info` | About the application |

## Run

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080/swagger-ui.html

## UML

![ProductController, ProductService and Product](docs/uml/ProductService.png)

All class diagrams (PlantUML sources and PNGs) are in [`docs/uml`](docs/uml).
