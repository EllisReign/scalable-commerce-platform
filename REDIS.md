# Redis cache branch

Read-through order lookup caching using Spring Cache and a 2-minute TTL.

- PostgreSQL remains the source of truth.
- Any future order mutation must invalidate its cache entry after successful commit.
- Test Redis outages, serializer compatibility, stampedes, and reconnection.
- Do not cache data with inappropriate exposure or authorization semantics.
