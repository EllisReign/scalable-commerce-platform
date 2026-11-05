package dev.ellis.platform.order;
import java.time.Instant;
import java.util.UUID;
public record OrderResponse(UUID id,String customerId,OrderStatus status,long version,Instant createdAt) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(order.getId(),order.getCustomerId(),order.getStatus(),order.getVersion(),order.getCreatedAt());
    }
}
