package assessment.fin_tech_app.controller.dto.response;

import java.math.BigDecimal;

public record BalanceResponse(

        Long userId,
        BigDecimal balance
) {
}
