package assessment.fin_tech_app.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiPayload<T> {

    private boolean success;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private T payload;

    public ApiPayload(String message, int statusCode) {
        this.success = true;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }

    public ApiPayload(String message, int statusCode, T payload) {
        this.success = true;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
        this.payload = payload;
    }

    public ApiPayload(int statusCode, T payload) {
        this.success = true;
        this.message = "";
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
        this.payload = payload;
    }

    public static ApiPayload<String> success(String message, int statusCode) {
        return new ApiPayload<>(message, statusCode);
    }

    public static <T> ApiPayload<T> success(String message, int statusCode, T payload) {
        return new ApiPayload<>(message, statusCode, payload);
    }

    public static <T> ApiPayload<T> success(int statusCode, T payload) {
        return new ApiPayload<>(statusCode, payload);
    }
}
