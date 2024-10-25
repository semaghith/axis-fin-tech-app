package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping(path = "/deposit/{amount}")
    public Long depositMoney(@PathVariable Long amount) {

        return transactionService.depositMoney(amount);
    }
}

