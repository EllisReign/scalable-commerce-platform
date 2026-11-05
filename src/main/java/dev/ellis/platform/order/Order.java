package dev.ellis.platform.order;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id private UUID id;
    @Column(nullable=false) private String customerId;
    @Enumerated(EnumType.STRING) @Column(nullable=false) private OrderStatus status;
    @Version private long version;
    @Column(nullable=false) private Instant createdAt;

    protected Order() {}
    public Order(String customerId) {
        this.id = UUID.randomUUID(); this.customerId = customerId;
        this.status = OrderStatus.CREATED; this.createdAt = Instant.now();
    }
    public UUID getId() { return id; }
    public String getCustomerId() { return customerId; }
    public OrderStatus getStatus() { return status; }
    public long getVersion() { return version; }
    public Instant getCreatedAt() { return createdAt; }
}
