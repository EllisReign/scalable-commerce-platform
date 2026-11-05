# RabbitMQ messaging branch

Creates a durable direct exchange and order-created queue, with a basic publisher.

**Not yet connected to order creation.** Publishing after a database transaction without an outbox is unsafe. Before production, add PostgreSQL outbox records, publisher confirms, retries with dead-letter routing, and idempotent consumers.
