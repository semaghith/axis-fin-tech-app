package assessment.fin_tech_app.service;

import assessment.fin_tech_app.controller.dto.request.TransactionRequest;

public interface TransactionService {

    Long depositMoney(TransactionRequest request) throws Exception;

    Long withdrawMoney(TransactionRequest request) throws Exception;
}
