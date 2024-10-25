package assessment.fin_tech_app.service;

import assessment.fin_tech_app.controller.dto.request.TransactionRequest;
import assessment.fin_tech_app.entity.Transaction;

public interface TransactionService {

    Transaction depositMoney(TransactionRequest request);

    Transaction withdrawMoney(TransactionRequest request);
}
