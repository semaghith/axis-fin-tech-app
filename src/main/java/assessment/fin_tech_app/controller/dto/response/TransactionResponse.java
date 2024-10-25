package assessment.fin_tech_app.controller.dto.response;

import java.math.BigDecimal;

public record TransactionResponse(

        Long transactionId,
        String transactionType,
        BigDecimal amount
) {
}
