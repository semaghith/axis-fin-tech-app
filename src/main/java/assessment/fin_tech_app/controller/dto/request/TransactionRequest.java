package assessment.fin_tech_app.controller.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransactionRequest(

        @NotNull(message = "User id field is mandatory")
        Long userId,

        @NotNull(message = "Amount field is mandatory")
        @Positive
        BigDecimal amount
) {
}
