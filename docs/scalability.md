# Scaling and reliability

- Set realistic throughput, latency (p95/p99), and error-rate objectives.
- Budget HikariCP pool limits across all replicas relative to PostgreSQL max_connections.
- Use keyset pagination for large result sets.
- Add bounded timeouts, circuit breakers, jittered retries, and bulkheads for remote calls.
- Profile SQL query plans, indexes, and long-running transactions.
- Deploy replicas behind a load balancer after proving stateless HTTP behavior.
- Use Actuator metrics and k6 load tests before claiming throughput targets.
- Restrict Actuator endpoints in production; avoid exposing sensitive metrics.
- Avoid manually increasing server thread counts without measurements.
