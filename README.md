# Scalable Commerce Platform

A Java 21 / Spring Boot 3.3 starter for layered architecture, Spring Data JPA, optimistic locking, Redis, and RabbitMQ.

## Run locally
Requires Java 21, Maven, Docker Compose.

```bash
docker compose up -d
mvn spring-boot:run
curl -H 'Content-Type: application/json' -d '{"customerId":"alice"}' http://localhost:8080/api/v1/orders
```

## Feature branches
- `feature/orm-jpa`: JPA / Hibernate concurrency and repository design
- `feature/scalability`: scaling and observability notes
- `feature/reusable-architecture`: reusable API error handling
- `feature/redis-cache`: Redis cache manager and cached order retrieval
- `feature/rabbitmq-messaging`: RabbitMQ topology and publisher foundation

**Educational starter—not production ready or load tested.** Credentials in Docker Compose are for local development. Add authentication, secrets, robust testing, messaging outbox, idempotency, retries and monitoring before deployment.
