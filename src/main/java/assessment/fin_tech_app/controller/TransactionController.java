package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.TransactionRequest;
import assessment.fin_tech_app.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class TransactionController {

    private final TransactionService transactionService;

//    @GetMapping(path = "/transactions/{id}")
//    public TransactionResponse retrieveTransaction(@PathVariable Long id) {
//
//        return transactionService.retrieveTransaction(id);
//    }

    @PostMapping(path = "/deposit")
    public Long depositMoney(@RequestBody @Valid TransactionRequest request) throws Exception {

        return transactionService.depositMoney(request);
    }

    @PostMapping(path = "/withdraw")
    public Long withdrawMoney(@RequestBody @Valid TransactionRequest request) throws Exception {

        return transactionService.withdrawMoney(request);
    }
}

