package assessment.fin_tech_app.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private T payload;

    public ApiResponse(String message, int statusCode) {
        this.success = true;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(String message, int statusCode, T payload) {
        this.success = true;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
        this.payload = payload;
    }

    public ApiResponse(int statusCode, T payload) {
        this.success = true;
        this.message = "";
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
        this.payload = payload;
    }

    public static ApiResponse<String> success(String message, int statusCode) {
        return new ApiResponse<>(message, statusCode);
    }

    public static <T> ApiResponse<T> success(String message, int statusCode, T payload) {
        return new ApiResponse<>(message, statusCode, payload);
    }

    public static <T> ApiResponse<T> success(int statusCode, T payload) {
        return new ApiResponse<>(statusCode, payload);
    }
}
