package assessment.fin_tech_app.payload;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private boolean success;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, int statusCode) {
        this.success = false;
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now();
    }
}