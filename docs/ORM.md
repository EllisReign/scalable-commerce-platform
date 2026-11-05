# ORM / JPA design

- `Order` is a persistence entity, not a public API payload. Return `OrderResponse` DTOs.
- `@Version` implements optimistic concurrency checking.
- `spring.jpa.open-in-view=false` prevents persistence access from spilling into HTTP rendering.
- Flyway owns schema changes; `ddl-auto: validate` checks mapping compatibility.
- Place transactional boundaries at service methods, not controllers.
- Profile N+1 queries; use entity graphs or targeted fetch joins when necessary.
- Always paginate unbounded collections.
- Enforce global invariants with database constraints, not just ORM annotations.

## Suggested tests
1. Flyway migrations create `orders`.
2. JPA save/load round-trip.
3. Stale concurrent update reports optimistic locking failure.
4. Controller returns DTOs, never entities.
5. Invalid customer input responds with HTTP 400.

Prefer PostgreSQL Testcontainers over H2 for realistic integration testing.
