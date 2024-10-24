package assessment.fin_tech_app.service.impl;

import assessment.fin_tech_app.repository.TransactionRepository;
import assessment.fin_tech_app.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;


    @Override
    public Long depositMoney(Long amount) {
        return 0L;
    }
}
