package assessment.fin_tech_app.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransactionType {

    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw");

    private final String status;
}
