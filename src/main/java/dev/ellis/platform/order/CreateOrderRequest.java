package dev.ellis.platform.order;
import jakarta.validation.constraints.NotBlank;
public record CreateOrderRequest(@NotBlank String customerId) {}
