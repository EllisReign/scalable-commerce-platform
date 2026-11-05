package dev.ellis.platform.order;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
@Service
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) { this.repository=repository; }
    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        return OrderResponse.from(repository.save(new Order(request.customerId())));
    }
    @Transactional(readOnly=true)
    public OrderResponse get(UUID id) {
        return repository.findById(id).map(OrderResponse::from)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found"));
    }
}
