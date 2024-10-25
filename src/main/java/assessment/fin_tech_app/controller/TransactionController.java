package assessment.fin_tech_app.controller;

import assessment.fin_tech_app.controller.dto.request.TransactionRequest;
import assessment.fin_tech_app.controller.dto.response.TransactionResponse;
import assessment.fin_tech_app.entity.Transaction;
import assessment.fin_tech_app.mapper.TransactionMapper;
import assessment.fin_tech_app.payload.ApiPayload;
import assessment.fin_tech_app.service.TransactionService;
import assessment.fin_tech_app.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Deposit money", description = "Deposits a specified amount to the user's account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction completed successfully",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class))),
            @ApiResponse(responseCode = "400", description = "User not found or invalid amount",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class)))
    })
    @PostMapping(path = "/deposit")
    public ApiPayload<TransactionResponse> depositMoney(@RequestBody @Valid TransactionRequest request) {

        Transaction transaction = transactionService.depositMoney(request);

        TransactionResponse response = transactionMapper.toResponse(transaction);

        return ApiPayload.success(Constants.SuccessMessages.TRANSACTION_COMPLETED_SUCCESSFULLY, 200, response);
    }

    @Operation(summary = "Withdraw money", description = "Withdraws a specified amount from the user's account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Transaction completed successfully",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class))),
            @ApiResponse(responseCode = "400", description = "User not found or low balance",
                    content = @Content(schema = @Schema(implementation = ApiPayload.class)))
    })
    @PostMapping(path = "/withdraw")
    public ApiPayload<TransactionResponse> withdrawMoney(@RequestBody @Valid TransactionRequest request) {

        Transaction transaction = transactionService.withdrawMoney(request);

        TransactionResponse response = transactionMapper.toResponse(transaction);

        return ApiPayload.success(Constants.SuccessMessages.TRANSACTION_COMPLETED_SUCCESSFULLY, 200, response);
    }
}

