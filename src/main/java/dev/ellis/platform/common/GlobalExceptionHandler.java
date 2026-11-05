package dev.ellis.platform.common;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> badInput(MethodArgumentNotValidException ex) {
        Map<String,String> fields = ex.getBindingResult().getFieldErrors().stream()
            .collect(Collectors.toMap(e -> e.getField(), e -> String.valueOf(e.getDefaultMessage()), (a,b)->a));
        return ResponseEntity.badRequest().body(new ApiError("VALIDATION_ERROR", "Invalid request", Instant.now(), fields));
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiError> httpError(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(
            new ApiError("HTTP_ERROR", ex.getReason(), Instant.now(), Map.of()));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> unexpected(Exception ex) {
        // Log server-side; avoid exposing internal details.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            new ApiError("INTERNAL_ERROR", "Unexpected server error", Instant.now(), Map.of()));
    }
}
