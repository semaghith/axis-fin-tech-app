package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.TransactionRequest;
import assessment.fin_tech_app.controller.dto.response.TransactionResponse;
import assessment.fin_tech_app.entity.Transaction;
import assessment.fin_tech_app.mapper.TransactionMapper;
import assessment.fin_tech_app.payload.ApiResponse;
import assessment.fin_tech_app.service.TransactionService;
import assessment.fin_tech_app.utils.Constants;
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
    private final TransactionMapper transactionMapper;


//    @GetMapping(path = "/transactions/{id}")
//    public ApiResponse<TransactionResponse> retrieveTransaction(@PathVariable Long id) {
//
//        Transaction transaction = transactionService.retrieveTransaction(id);
//
//        TransactionResponse response = transactionMapper.toResponse(transaction);
//
//        return ApiResponse.success("", 200, response);
//    }

    @PostMapping(path = "/deposit")
    public ApiResponse<TransactionResponse> depositMoney(@RequestBody @Valid TransactionRequest request) {

        Transaction transaction = transactionService.depositMoney(request);

        TransactionResponse response = transactionMapper.toResponse(transaction);

        return ApiResponse.success(Constants.SuccessMessages.TRANSACTION_COMPLETED_SUCCESSFULLY, 200, response);
    }

    @PostMapping(path = "/withdraw")
    public ApiResponse<TransactionResponse> withdrawMoney(@RequestBody @Valid TransactionRequest request) {

        Transaction transaction = transactionService.withdrawMoney(request);

        TransactionResponse response = transactionMapper.toResponse(transaction);

        return ApiResponse.success(Constants.SuccessMessages.TRANSACTION_COMPLETED_SUCCESSFULLY, 200, response);
    }
}

