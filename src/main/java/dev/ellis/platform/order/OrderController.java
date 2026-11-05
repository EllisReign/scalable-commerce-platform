package dev.ellis.platform.order;
import java.net.URI;
import java.util.UUID;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService service;
    public OrderController(OrderService service) { this.service=service; }
    @PostMapping
    public ResponseEntity<OrderResponse> create(@Valid @RequestBody CreateOrderRequest request) {
        OrderResponse response=service.create(request);
        return ResponseEntity.created(URI.create("/api/v1/orders/"+response.id())).body(response);
    }
    @GetMapping("/{id}")
    public OrderResponse get(@PathVariable UUID id) { return service.get(id); }
}
