package assessment.fin_tech_app.service;

public interface TransactionService {

    Long depositMoney(Long amount);

    Long withdrawMoney(Long amount);
}
